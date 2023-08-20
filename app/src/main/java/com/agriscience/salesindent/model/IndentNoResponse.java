package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.IndentNoDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IndentNoResponse{

	@SerializedName("result")
	private List<IndentNoDetailsResponse> result;

	public void setResult(List<IndentNoDetailsResponse> result){
		this.result = result;
	}

	public List<IndentNoDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"IndentNoResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}