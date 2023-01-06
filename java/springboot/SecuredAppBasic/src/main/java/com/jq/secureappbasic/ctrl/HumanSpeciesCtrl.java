package com.jq.secureappbasic.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jq.secureappbasic.service.HumanSpecieService;
import com.jq.secureappbasic.service.IAuthenticationFacade;

@Controller
public class HumanSpeciesCtrl {
	@Autowired
	HumanSpecieService humanSpecieService;

	@Autowired
	private IAuthenticationFacade authenticationFacade;

	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		model.addAttribute("name", authenticationFacade.getNameFromAuth());
		return "home";
	}

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}

	@GetMapping(value = {"/human", "/human/list"})
	public String humanList(Model model) {

		model.addAttribute("humans", humanSpecieService.findAll());
		return "human";
	}

}