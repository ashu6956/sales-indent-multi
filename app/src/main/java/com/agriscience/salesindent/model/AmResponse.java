package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.AmDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AmResponse {

	@SerializedName("result")
	private List<com.agriscience.salesindent.model.AmDetailsResponse> result;

	public void setResult(List<com.agriscience.salesindent.model.AmDetailsResponse> result){
		this.result = result;
	}

	public List<AmDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"AmResponse{" +
			"result = '" + result + '\'' + 
			"}";
		}
}