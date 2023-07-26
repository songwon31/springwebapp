package com.mycompany.springwebapp.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@ControllerAdvice
@Slf4j
public class Ch10SoldOutException extends RuntimeException {
	public Ch10SoldOutException() {
		
	}
	
	public Ch10SoldOutException(String message) {
		super(message);
	}
}
