package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.responseDto.ResponseDto;
import com.example.demo.responseDto.ResponseMessageDto;

@RestControllerAdvice
public class ExceptionTranslator extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleExceptions(Exception exception, WebRequest webRequest) {
		ResponseDto response = new ResponseDto(Boolean.FALSE, Boolean.TRUE,
				new ResponseMessageDto(exception.getMessage()));
		ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		return entity;
	}
}