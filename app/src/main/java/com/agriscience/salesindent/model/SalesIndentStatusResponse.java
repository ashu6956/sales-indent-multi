package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.SalesIndentStatusDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SalesIndentStatusResponse{

	@SerializedName("result")
	private List<SalesIndentStatusDetailsResponse> result;

	public void setResult(List<SalesIndentStatusDetailsResponse> result){
		this.result = result;
	}

	public List<SalesIndentStatusDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"SalesIndentStatusResponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}