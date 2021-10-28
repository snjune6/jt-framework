package com.link.jk.jkframework.controller.kcms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KcmsIndexController {

	@GetMapping(value = {"/kcms", "/kcms/"})
	public String kcmsMain() {
		return "kcms/index";
	}

}
