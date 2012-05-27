package com.flexyquiz.app.shared.core.model;

import java.io.Serializable;

public interface Persistent extends HasIdentity, Comparable, Serializable {
  public boolean isNew();
}
