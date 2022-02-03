package com.elieser.autenticacaoJwt.response;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private T data;
	private List<String> errors;
	private String message;
	private HttpStatus status;

	public Response() {
	}
	public Response(String message) { this.message = message; }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() { return message;	}

	public void setMessage(String message) { this.message = message;	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}