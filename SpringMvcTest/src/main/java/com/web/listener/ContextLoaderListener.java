package com.web.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        servletContext.setAttribute("app",app);
        System.out.println("spring container created--------------------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
