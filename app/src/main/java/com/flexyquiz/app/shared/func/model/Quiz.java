package com.flexyquiz.app.shared.func.model;

import com.flexyquiz.app.shared.core.model.Persistent;

public interface Quiz extends Persistent {
  public abstract String getName();

  public abstract void setName(String name);

  public abstract String getDescription();

  public abstract void setDescription(String description);

}