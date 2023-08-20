package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class IndentNoDetailsResponse {

	@SerializedName("indent_no")
	private String indentNo;

	public void setIndentNo(String indentNo){
		this.indentNo = indentNo;
	}

	public String getIndentNo(){
		return indentNo;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"indent_no = '" + indentNo + '\'' + 
			"}";
		}
}