package org.geektimes.projects.web;

import org.geektimes.projects.web.filter.EncodeFilter;
import org.geektimes.projects.web.servlet.ForwadServlet;
import org.geektimes.projects.web.servlet.InitServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @title: ServletWebApplicationInitializer
 * @Author sean
 * @Date: 2021/6/12 1:02 下午
 * TODO:
 */
public class ServletWebApplicationInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("servletContext-path="+servletContext.getContextPath());
    }
}
