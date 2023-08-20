package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.STOIndentDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class STOIndentResponse{

	@SerializedName("result")
	private List<STOIndentDetailsResponse> result;

	public void setResult(List<STOIndentDetailsResponse> result){
		this.result = result;
	}

	public List<STOIndentDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"STOIndentResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}