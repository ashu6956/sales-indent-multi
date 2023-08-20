package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.PlantDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlantResponse{

	@SerializedName("Plants")
	private List<PlantDetailsResponse> plantResponse;

	public void setPlantResponse(List<PlantDetailsResponse> plantResponse){
		this.plantResponse = plantResponse;
	}

	public List<PlantDetailsResponse> getPlantResponse(){
		return plantResponse;
	}

	@Override
 	public String toString(){
		return 
			"PlantResponse{" + 
			"plantResponse = '" + plantResponse + '\'' + 
			"}";
		}
}