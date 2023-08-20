package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.TmDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TmResponse{

	@SerializedName("result")
	private List<TmDetailsResponse> result;

	public void setResult(List<TmDetailsResponse> result){
		this.result = result;
	}

	public List<TmDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"TmResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}