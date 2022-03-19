package com.codeman.servlet;

import com.codeman.context.ContextLoaderListener;
import com.codeman.context.four.WebApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author hdgaadd
 * Created on 2022/03/10
 */
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 131313131313L;

    private WebApplicationContext webApplicationContext;

    @Override
    public void init(ServletConfig config) throws ServletException {

        Object attribute = config.getServletContext().getAttribute(ContextLoaderListener.ROOT_CXT_ATTR);

    }
}
