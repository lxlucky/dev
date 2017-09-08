package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(value="IndexController", description="首页")
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
