package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;


public class SeasonMasterDetailsResponse {

	@SerializedName("season_start_date")
	private String seasonStartDate;

	@SerializedName("season_code")
	private String seasonCode;

	@SerializedName("message")
	private String message;

	@SerializedName("season_end_date")
	private String seasonEndDate;

	@SerializedName("status")
	private String status;

	@SerializedName("crop_code")
	private String cropCode;

	@SerializedName("season_name")
	private String seasonName;

	@SerializedName("crop_name")
	private String cropName;

	@SerializedName("active")
	private String active;

	@SerializedName("return_cut_off_date")
	private String returnCutOffDate;

	public String getReturnCutOffDate() {
		return returnCutOffDate;
	}

	public void setReturnCutOffDate(String returnCutOffDate) {
		this.returnCutOffDate = returnCutOffDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@SerializedName("description")
	private String description;


	@SerializedName("state")
	private String state;

	public void setSeasonStartDate(String seasonStartDate){
		this.seasonStartDate = seasonStartDate;
	}

	public String getSeasonStartDate(){
		return seasonStartDate;
	}

	public void setSeasonCode(String seasonCode){
		this.seasonCode = seasonCode;
	}

	public String getSeasonCode(){
		return seasonCode;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setSeasonEndDate(String seasonEndDate){
		this.seasonEndDate = seasonEndDate;
	}

	public String getSeasonEndDate(){
		return seasonEndDate;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setCropCode(String cropCode){
		this.cropCode = cropCode;
	}

	public String getCropCode(){
		return cropCode;
	}

	public void setSeasonName(String seasonName){
		this.seasonName = seasonName;
	}

	public String getSeasonName(){
		return seasonName;
	}

	public void setCropName(String cropName){
		this.cropName = cropName;
	}

	public String getCropName(){
		return cropName;
	}

	public void setActive(String active){
		this.active = active;
	}

	public String getActive(){
		return active;
	}

	@Override
	public String toString() {
		return "SeasonMasterDetailsResponse{" +
				"seasonStartDate='" + seasonStartDate + '\'' +
				", seasonCode='" + seasonCode + '\'' +
				", message='" + message + '\'' +
				", seasonEndDate='" + seasonEndDate + '\'' +
				", status='" + status + '\'' +
				", cropCode='" + cropCode + '\'' +
				", seasonName='" + seasonName + '\'' +
				", cropName='" + cropName + '\'' +
				", active='" + active + '\'' +
				", returnCutOffDate='" + returnCutOffDate + '\'' +
				", description='" + description + '\'' +
				", state='" + state + '\'' +
				'}';
	}
}