package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.RbmDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RbmResponse {

	@SerializedName("result")
	private List<RbmDetailsResponse> result;

	public void setResult(List<RbmDetailsResponse> result){
		this.result = result;
	}

	public List<RbmDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"RbmDetails{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}