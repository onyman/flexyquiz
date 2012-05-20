package com.flexyquiz.app.shared.core.model;

import org.springframework.data.annotation.Id;

public abstract class AbstractPersistent implements Persistent {
  @Id
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public boolean isNew() {
    return id == null; 
  }
}
