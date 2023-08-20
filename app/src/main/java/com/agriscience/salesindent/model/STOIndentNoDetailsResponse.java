package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class STOIndentNoDetailsResponse {

	@SerializedName("STO_indent_no")
	private String sTOIndentNo;

	public void setSTOIndentNo(String sTOIndentNo){
		this.sTOIndentNo = sTOIndentNo;
	}

	public String getSTOIndentNo(){
		return sTOIndentNo;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"sTO_indent_no = '" + sTOIndentNo + '\'' + 
			"}";
		}
}