package com.agriscience.salesindent.model;

public class Response{
	private Data data;
	private boolean success;
	private Zorganogram zorganogram;
	private String message;

	public Data getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	public Zorganogram getZorganogram(){
		return zorganogram;
	}

	public String getMessage(){
		return message;
	}
}
