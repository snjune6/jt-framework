package com.link.jk.jkframework.controller;

import com.link.jk.jkframework.comm.JavaScript;
import com.link.jk.jkframework.comm.JavaScriptView;
import com.link.jk.jkframework.comm.Util;
import com.link.jk.jkframework.dto.MenuDto;
import com.link.jk.jkframework.dto.UserDetailDto;
import com.link.jk.jkframework.service.MenuService;
import com.link.jk.jkframework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/auth")
public class UserController {

	private UserService userService;

	@GetMapping(value = "/login")
	public String loginForm(HttpServletRequest request, HttpServletResponse response, Model model) {

		String referer = request.getHeader("Referer");
		request.getSession().setAttribute("prevPage", referer);

		return "auth/login";
	}



	@GetMapping(value = "/signup")
	public String signupForm() {

		return "auth/signup";
	}

	@PostMapping(value = "/signup")
	public String signup(UserDetailDto userDetailDto, HttpServletRequest request, HttpServletResponse response) {

		userService.joinUser(userDetailDto);

		return null;
	}

}
