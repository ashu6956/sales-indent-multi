package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.STOIndentNoDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class STOIndentNoResponse {

	@SerializedName("result")
	private List<STOIndentNoDetailsResponse> result;

	public void setResult(List<STOIndentNoDetailsResponse> result){
		this.result = result;
	}

	public List<STOIndentNoDetailsResponse> getResult(){
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