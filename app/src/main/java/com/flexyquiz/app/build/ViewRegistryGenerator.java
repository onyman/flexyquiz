package com.flexyquiz.app.build;

import com.flexyquiz.app.client.core.mvp.BaseActivity;
import com.flexyquiz.app.client.core.mvp.BaseDisplay;
import com.flexyquiz.app.client.core.mvp.View;
import com.flexyquiz.app.client.core.mvp.ViewRegistry;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class ViewRegistryGenerator extends AbstractGenerator {
  private String VIEW_CLASS_NAME = BaseDisplay.class.getName();

  protected void generateSource(SourceWriter out, TypeOracle typeOracle, String generatedClassName)
      throws NotFoundException, UnableToCompleteException {
    out.println("public " + VIEW_CLASS_NAME + " getView(BaseActivity activity) {");
    out.println("  " + VIEW_CLASS_NAME + " view = null;");
    out.println("  if (false) {}");
    
    final JClassType viewType = typeOracle.getType(VIEW_CLASS_NAME);
    JClassType[] types = typeOracle.getTypes();
    for (JClassType type : types) {
      if (type.isInterface() == null && type.isAssignableTo(viewType)) {
        View annotation = type.getAnnotation(View.class);
        if (annotation != null) {

          Class<? extends BaseActivity> activityClass = annotation.forActivity();
          out.println("  else if (activity instanceof " + activityClass.getName() + ") {");
          out.println("    view = new " + type.getQualifiedSourceName() + "();");
          out.println("  }");
          log("Binding " + type.getName() + " as default view for " + activityClass.getSimpleName());
          
        }
      }
    }

    out.println("  return view;");
    out.println("}");
    out.println();
  }

  protected ClassSourceFileComposerFactory getComposerFactory(String packageName, String simpleName) {
    ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
    composer.addImplementedInterface(ViewRegistry.class.getName());
    return composer;
  }
}
