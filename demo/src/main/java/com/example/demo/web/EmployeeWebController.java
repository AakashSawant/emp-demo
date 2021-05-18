package com.example.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.responseDto.ResponseDto;

@Controller
public class EmployeeWebController {

	@Value("${baseURL}")
	private String baseURL;

	@RequestMapping
	public ModelAndView index() {
		ModelAndView md = new ModelAndView("index");
		RestTemplate template = new RestTemplate();
		ResponseDto employees = template.getForObject(baseURL + "/api/employee", ResponseDto.class);
		if (employees.getIsSuccess()) {
			md.addObject("employees", employees.getResponse());
		} else {
			md.addObject("error", employees.getResponse());
		}
		return md;
	}
}
