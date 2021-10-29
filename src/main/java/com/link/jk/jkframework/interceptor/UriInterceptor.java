package com.link.jk.jkframework.interceptor;

import com.link.jk.jkframework.dto.MenuDto;
import com.link.jk.jkframework.dto.SiteDto;
import com.link.jk.jkframework.service.MenuService;
import com.link.jk.jkframework.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.List;

public class UriInterceptor implements HandlerInterceptor {

    @Autowired
    private SiteService siteService;

    @Autowired
    private MenuService menuService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String servletPath = request.getServletPath();

        System.out.println("=========================");
        System.out.println("UriInterceptor::preHandle");
        System.out.println("UriInterceptor");
        System.out.printf("preHandle URI : %s%n", servletPath);
        System.out.println("=========================");

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Enumeration<String> en = request.getParameterNames();
        while (en.hasMoreElements()) {
            Object keyObj = en.nextElement();
            if ((keyObj instanceof String)) {
                String key = (String)keyObj;
                if (request.getParameterValues(key).length != 1) {
                    for (String value : request.getParameterValues(key)) {
                        System.out.printf("########### parameter key = '%s',Array value = '%s'%n", key, value);
                    }
                } else {
                    System.out.printf("########### parameter key = '%s', value = '%s'%n", key, request.getParameter(key));
                }
            } else {
                System.out.println("parameter key is Object");
            }
        }

        SiteDto siteDto = siteService.selectSiteList();

        // 사이트 정보 입력
        if(siteDto!=null) {
            request.setAttribute("siteName", siteDto.getSiteName());
            request.setAttribute("siteState", siteDto.getSiteState());
            request.setAttribute("siteDomain", siteDto.getSiteDomain());
            request.setAttribute("siteCdn", siteDto.getSiteCdn());
        }

        List<MenuDto> menuFullList;
        menuFullList = menuService.selectFullMenuList();
        request.setAttribute("menuFullList", menuFullList);

        MenuDto menuDto = menuService.selectMenuType(servletPath);
        int menuType = menuDto.getMenuType();

        if(menuType<0) {
            System.err.println("menuType is null!!");
        } else {
            if(menuType==1) {

                System.out.println("menuDto.getMenuId() : " + menuDto.getMenuId());
                response.sendRedirect("/contents/" + menuDto.getMenuId());
                return false;
            }
        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("UriInterceptor::postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("UriInterceptor::afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
