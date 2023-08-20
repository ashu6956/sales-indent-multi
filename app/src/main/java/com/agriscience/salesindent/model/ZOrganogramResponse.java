package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ZOrganogramResponse {

	@SerializedName("Acsen_ZorganogramMaster_Res")
	private List<ZOrganogramResponseDetails> response;

	public List<ZOrganogramResponseDetails> getResponse(){
		return response;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"response = '" + response + '\'' + 
			"}";
		}
}