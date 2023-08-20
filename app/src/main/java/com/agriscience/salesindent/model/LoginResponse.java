package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

	@SerializedName("data")
	private LoginDetailsResponse data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(LoginDetailsResponse data){
		this.data = data;
	}

	public LoginDetailsResponse getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}