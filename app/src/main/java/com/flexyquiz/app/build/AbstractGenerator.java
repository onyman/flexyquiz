package com.flexyquiz.app.build;

import java.io.PrintWriter;

import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public abstract class AbstractGenerator extends Generator {
  private TreeLogger logger;

  public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {
    this.logger = logger;

    // search for metadata about class to generate
    log("Generating source for " + typeName);
    TypeOracle typeOracle = context.getTypeOracle();
    JClassType clazz = typeOracle.findType(typeName);
    if (clazz == null) {
      logError("Unable to find metadata for type '" + typeName + "'");
      throw new UnableToCompleteException();
    }

    // keep these as constants
    final String generatedClassQualifiedSourceName = clazz.getQualifiedSourceName() + "Impl";
    String generatedClassName = clazz.getSimpleSourceName() + "Impl";

    // build source writer
    log("   Qualified source name " + clazz.getQualifiedSourceName());
    SourceWriter sourceWriter = getSourceWriter(clazz, context, generatedClassName);
    if (sourceWriter == null) {
      log("Will not generate this time ");
      return generatedClassQualifiedSourceName;
    }

    // all the prerequisites are in place - generate now...

    try {
      generateSource(sourceWriter, typeOracle, generatedClassName);
      sourceWriter.commit(logger);
      log("Done Generating source for " + clazz.getName());
      return generatedClassQualifiedSourceName;
    } catch (NotFoundException e) {
      // normally this can't be, so if this happens - it indicates the error in
      // this class
      // therefore, don't handle it anyhow, just print the error
      e.printStackTrace();
      return null;
    }
  }

  protected abstract void generateSource(SourceWriter sourceWriter, TypeOracle typeOracle, String generatedClassName)
      throws NotFoundException, UnableToCompleteException;

  public SourceWriter getSourceWriter(JClassType classType, GeneratorContext context, String generatedClassName) {
    String packageName = classType.getPackage().getName();
    ClassSourceFileComposerFactory composer = getComposerFactory(packageName, generatedClassName);
    PrintWriter printWriter = context.tryCreate(logger, packageName, generatedClassName);
    return printWriter == null ? null : composer.createSourceWriter(context, printWriter);
  }

  protected abstract ClassSourceFileComposerFactory getComposerFactory(String packageName, String simpleName);

  public void log(String message) {
    logger.log(TreeLogger.INFO, message, null);
  }

  public void logError(String message) {
    logger.log(TreeLogger.ERROR, message, null);
  }
}
