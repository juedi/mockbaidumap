package com.example.demo;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("")
@ComponentScan(basePackages="com.example.demo")
@CrossOrigin
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@GetMapping("/geocoder/v2")
	public String test1(HttpServletRequest request) throws IOException{
		String callback = request.getParameter("callback");
		return String.format("%s && %s(%s)", callback, callback, FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("location.json").getFile()), "GBK"));
	}
	@GetMapping("/location/ip")
	public String test2(HttpServletRequest request) throws IOException{
		String callback = request.getParameter("callback");
		return String.format("%s && %s(%s)", callback, callback, FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("ip.json").getFile()), "GBK"));
	}
	@GetMapping("/getscript")
	public String test3(HttpServletRequest request) throws IOException{
		return FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("script.json").getFile()), "GBK");
	}
	@GetMapping("/api")
	public String test4(HttpServletRequest request) throws IOException{
		return FileUtils.readFileToString(new File(this.getClass().getClassLoader().getResource("api.json").getFile()), "GBK");
	}
}
