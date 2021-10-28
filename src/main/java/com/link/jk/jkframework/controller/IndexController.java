package com.link.jk.jkframework.controller;

import com.link.jk.jkframework.dto.CategoryDto;
import com.link.jk.jkframework.dto.MenuDto;
import com.link.jk.jkframework.dto.SiteDto;
import com.link.jk.jkframework.service.CategoryService;
import com.link.jk.jkframework.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@Controller
public class IndexController {

    private MenuService menuService;
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {

        SiteDto siteDto = (SiteDto) request.getAttribute("siteDto");
        model.addAttribute("siteDto", siteDto);

        // 메인메뉴
        List<MenuDto> menuFullList = (List<MenuDto>) request.getAttribute("menuFullList");
        model.addAttribute("menuFullList", menuFullList);

        // 카테고리
        List<CategoryDto> categoryFullList;
        categoryFullList = categoryService.selectFullCategoryList();
        model.addAttribute("categoryFullList", categoryFullList);

        return "index";
    }

    @GetMapping(value = "/test2")
    public String test(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "contents/test2";
    }
}
