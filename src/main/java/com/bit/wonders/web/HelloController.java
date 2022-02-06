package com.bit.wonders.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import com.bit.wonders.application.AppConfigProperties;



@RestController
public class HelloController {



public static String PROJECT_VERSION = "Version - 1.0";
public static String CONTROLLER_MSG = "Hello World @ Azure.";



@Autowired
private AppConfigProperties config;



@GetMapping(value = "/")
public String projectVersion() {
return PROJECT_VERSION;
}



@GetMapping(value = "/hello")
public String helloWorld() {
return CONTROLLER_MSG;
}
}
