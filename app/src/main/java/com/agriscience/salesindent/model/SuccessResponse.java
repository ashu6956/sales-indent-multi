package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class SuccessResponse{

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"SuccessResponse{" + 
			"success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}