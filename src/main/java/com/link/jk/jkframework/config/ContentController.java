package com.link.jk.jkframework.config;

import com.link.jk.jkframework.dto.MenuDto;
import com.link.jk.jkframework.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@Controller
public class ContentController {

	private MenuService menuService;

	@GetMapping(value = "/contents/{menuId}")
	public String contents(@PathVariable String menuId, HttpServletRequest request, HttpServletResponse response, Model model) {

		MenuDto menuDto = menuService.selectMenuReturn(menuId);

		return menuDto.getMenuReturn().toLowerCase();
	}
}
