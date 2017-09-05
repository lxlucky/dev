package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(value="IndexController", description="首页")
public class IndexController {

	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
}
