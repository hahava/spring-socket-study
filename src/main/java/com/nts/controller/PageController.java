package com.nts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "home";
	}

	@GetMapping("/board")
	public String board() {
		return "board";
	}

}
