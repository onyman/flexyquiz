package com.flexyquiz.app.server.core.rpc;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class GwtRpcController extends RemoteServiceServlet implements Controller, ServletContextAware,
    RemoteService {
  private Logger logger = LoggerFactory.getLogger(GwtRpcController.class);

  private ServletConfig servletConfig;

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    doPost(request, response);
    return null;
  }

  @Override
  public ServletConfig getServletConfig() {
    return servletConfig;
  }

  @Override
  protected void doUnexpectedFailure(Throwable e) {
    logger.error("Error in remote service", e);
    super.doUnexpectedFailure(e);
  }

  public void setServletContext(ServletContext servletContext) {
    this.servletConfig = new SimpleServletConfig(servletContext);
  }

  private static class SimpleServletConfig implements ServletConfig {
    private ServletContext context;

    private SimpleServletConfig(ServletContext context) {
      super();
      this.context = context;
    }

    public String getInitParameter(String arg0) {
      return null;
    }

    @SuppressWarnings("rawtypes") // this comes from Servlet API
    public Enumeration getInitParameterNames() {
      return null;
    }

    public ServletContext getServletContext() {
      return context;
    }

    public String getServletName() {
      return null;
    }
  }
}
