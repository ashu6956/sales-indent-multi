package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.STORbmDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class STORbmResponse {

	@SerializedName("result")
	private List<STORbmDetailsResponse> result;

	public void setResult(List<STORbmDetailsResponse> result){
		this.result = result;
	}

	public List<STORbmDetailsResponse> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"STORbmREsponse{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}