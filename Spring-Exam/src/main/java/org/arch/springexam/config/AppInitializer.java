package org.arch.springexam.config;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class <?> [] getRootConfigClasses() {
        System.out.println("AppInitializer root");
        return new Class[] {
               AppContext.class,
        };
    }

    @Override
    protected Class <?> [] getServletConfigClasses() {
        System.out.println("AppInitializer servlet");
        return new Class[] {
                WebMvcConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("AppInitializer servlet mapping");
        return new String[] {
                "/"
        };
    }
}
