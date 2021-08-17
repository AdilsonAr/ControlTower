package com.controltower.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controltower.model.KeyValue;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	@GetMapping
	public ResponseEntity<?> get(){
		KeyValue keyValue=new KeyValue();
		keyValue.setKeyAttribute(null);
		keyValue.setValAttribute(null);
		return new ResponseEntity<>(keyValue, HttpStatus.OK);		
	}
}
