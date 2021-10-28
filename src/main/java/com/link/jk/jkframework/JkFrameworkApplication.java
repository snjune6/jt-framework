package com.link.jk.jkframework;

import com.link.jk.jkframework.config.SiteMeshConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class JkFrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JkFrameworkApplication.class, args);
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public FilterRegistrationBean<SiteMeshConfig> sitemeshFilter() {
        FilterRegistrationBean<SiteMeshConfig> filter = new FilterRegistrationBean<SiteMeshConfig>();
        filter.setFilter(new SiteMeshConfig());

        return filter;
    }

}
