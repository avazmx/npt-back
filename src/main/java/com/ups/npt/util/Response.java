package com.ups.npt.util;

import java.util.List;

import lombok.Data;


@Data
public class Response {
	
	final private int code;
	private boolean complete;
	private List<?> response;
	private String error;
	private String message;
	
}
