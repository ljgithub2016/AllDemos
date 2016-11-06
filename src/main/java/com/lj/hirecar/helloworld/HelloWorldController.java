package com.lj.hirecar.helloworld;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam (value="name",defaultValue="world") String name){
		System.out.println("hello " + name);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		return new ModelAndView("/hello",map);
	}
}
