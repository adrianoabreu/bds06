package com.devsuperior.movieflix.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Instant timestatus;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	public StandardError() {
	}

	public Instant getTimestatus() {
		return timestatus;
	}

	public void setTimestatus(Instant timestatus) {
		this.timestatus = timestatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
