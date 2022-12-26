package com.raisetech.lecture10.exeption;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.Map;

@RestControllerAdvice
public class MedicalRecordExceptionHandler {
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNoResourceFound(
		ResourceNotFoundException e, HttpServletRequest request
	) {
		Map<String, String> body = Map.of("timestamp", ZonedDateTime.now().toString(), "status", String.valueOf(HttpStatus.NOT_FOUND.value()), "error", HttpStatus.NOT_FOUND.getReasonPhrase(), "message", e.getMessage(), "path", request.getRequestURI());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=BadRequestException.class)
	public ResponseEntity<Map<String, String>> handleArrayIndexOutOfBoundsException(
		BadRequestException e, HttpServletRequest request
	) {
		Map<String, String> body = Map.of("timestamp", ZonedDateTime.now().toString(), "status", String.valueOf(HttpStatus.BAD_REQUEST.value()), "error", HttpStatus.BAD_REQUEST.getReasonPhrase(), "message", e.getMessage(), "path", request.getRequestURI());
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=BatchUpdateException.class)
	public ResponseEntity<Map<String, String>> BatchUpdateException(
		BatchUpdateException e, HttpServletRequest request
	) {
		Map<String, String> body = Map.of("timestamp", ZonedDateTime.now().toString(), "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "message", e.getMessage(), "path", request.getRequestURI());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value=SQLException.class)
	public ResponseEntity<Map<String, String>> SQLException(
		SQLException e, HttpServletRequest request
	) {
		Map<String, String> body = Map.of("timestamp", ZonedDateTime.now().toString(), "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "message", e.getMessage(), "path", request.getRequestURI());
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
