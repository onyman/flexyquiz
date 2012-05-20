package com.flexyquiz.app.client.core.util;

public class ExceptionsUtil {
  private ExceptionsUtil() {
  }
  
  public static String throwableToString(Throwable e) {
    StringBuilder sb = new StringBuilder();
    sb.append(e.getClass().getName()).append(": ").append(e.getMessage()).append("\n");
    for (StackTraceElement element : e.getStackTrace()) {
      sb.append("\t").append(element.toString()).append("\n");
    }
    return sb.toString();
  }
}
