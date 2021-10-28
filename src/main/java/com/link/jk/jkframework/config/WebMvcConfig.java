package com.link.jk.jkframework.config;

import com.link.jk.jkframework.interceptor.JkInterceptor;
import com.link.jk.jkframework.interceptor.KcmsInterceptor;
import com.link.jk.jkframework.interceptor.UriInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


    @Bean
    public JkInterceptor jkInterceptor() {
        return new JkInterceptor();
    }

    @Bean
    public KcmsInterceptor kcmsInterceptor() {
        return new KcmsInterceptor();
    }

    @Bean
    public UriInterceptor uriInterceptor() {
        return new UriInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(jkInterceptor())
                        .addPathPatterns("/jk-framework/**")
                            .excludePathPatterns("/static/**", "/error");


        registry.addInterceptor(kcmsInterceptor())
                    .addPathPatterns("/kcms/**")
                        .excludePathPatterns("/static/**", "/error");

        registry.addInterceptor(uriInterceptor())
                    .addPathPatterns("/**")
                        .excludePathPatterns("/kcms/**", "/static/**", "/error", "/contents/**", "/favicon.ico", "/auth/**");

    }
}
