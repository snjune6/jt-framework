package com.link.jk.jkframework.controller.jk;

import com.link.jk.jkframework.config.State;
import com.link.jk.jkframework.dto.SiteDto;
import com.link.jk.jkframework.service.SiteService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping(value = "/jk-framework/site")
public class JkSiteController {

	private SiteService siteService;

	private static final Logger LOGGER = LogManager.getLogger(JkSiteController.class.getName());

	@GetMapping(value = "")
	public String siteForm(HttpServletRequest request, HttpServletResponse response, Model model) {

		SiteDto siteDto = (SiteDto) request.getAttribute("siteDto");
		model.addAttribute("siteDto", siteDto);

		List<String> siteStateList = new ArrayList<String>();
		State state[] = State.values();
		for(State i:state) {
			siteStateList.add(String.valueOf(i));
		}
		model.addAttribute("siteStateList", siteStateList);


		return "jk/site/site";
	}

	@PostMapping(value = "")
	public String siteAction(@Valid SiteDto siteDto, Errors errors, HttpServletRequest request, HttpServletResponse response, Model model) {

		List<String> siteStateList = new ArrayList<String>();

		State state[] = State.values();
		for(State i:state) {
			siteStateList.add(String.valueOf(i));
		}
		model.addAttribute("siteStateList", siteStateList);


		if(errors.hasErrors()) {
			return "jk/site/site";
		} else {
			siteService.updateSite(siteDto);
		}

		return "jk/site/site";
	}

}
