package com.flexyquiz.app.build;

import java.util.ArrayList;
import java.util.List;

import com.flexyquiz.app.client.core.mvp.BasePlace;
import com.flexyquiz.app.client.core.mvp.PlaceWithName;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.NotFoundException;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class PlaceHistoryMapperGenerator extends AbstractGenerator {
  private String PLACE_CLASS_NAME = BasePlace.class.getName();
  
  @Override
  protected void generateSource(SourceWriter out, TypeOracle typeOracle, String generatedClassName)
      throws NotFoundException, UnableToCompleteException {
    List<JClassType> places = new ArrayList<JClassType>();
    
    final JClassType viewType = typeOracle.getType(PLACE_CLASS_NAME);
    JClassType[] types = typeOracle.getTypes();
    for (JClassType type : types) {
      if (type.isInterface() == null && type.isAssignableTo(viewType)) {
        PlaceWithName annotation = type.getAnnotation(PlaceWithName.class);
        if (annotation != null) {
          places.add(type);
          log("Binding token '" + annotation.name() + "' to place " + type.getName());
        }
      }
    }
    
    
    out.println("public Place getPlace(String token) {");
    out.println("  BasePlace place = null;");
    out.println("  String[] tokenParts = token.split(\":\", 2);");
    out.println("  if (false) {}");
    for (JClassType place : places) {
      out.println("  else if (\"" + place.getAnnotation(PlaceWithName.class).name() + "\".equals(tokenParts[0])) {");
      out.println("    place = new " + place.getQualifiedSourceName() + "();");
      out.println("    if (tokenParts.length == 2) {");
      out.println("      place.init(tokenParts[1]);");
      out.println("    }");
      out.println("  }");
    }
    out.println("  return place;");
    out.println("}");
    
    
    out.println("public String getToken(Place place) {");
    out.println("  String token = null;");
    out.println("  if (false) {}");
    for (JClassType place : places) {
      out.println("  else if (place instanceof " + place.getQualifiedSourceName() + ") {");
      out.println("    token = \"" + place.getAnnotation(PlaceWithName.class).name() + "\";");
      out.println("  }");
    }
    out.println("  if (((BasePlace) place).getToken() != null) {");
    out.println("    token = token + \":\" + ((BasePlace) place).getToken();");
    out.println("  }");
    out.println("  return token;");
    out.println("}");
  }

  @Override
  protected ClassSourceFileComposerFactory getComposerFactory(String packageName, String simpleName) {
    ClassSourceFileComposerFactory composer = new ClassSourceFileComposerFactory(packageName, simpleName);
    composer.addImport(Place.class.getName());
    composer.addImplementedInterface(PlaceHistoryMapper.class.getName());
    return composer;
  }
}
