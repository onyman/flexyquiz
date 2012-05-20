package com.flexyquiz.app.client.core.mvp;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PlaceWithName {
  String name();
}
