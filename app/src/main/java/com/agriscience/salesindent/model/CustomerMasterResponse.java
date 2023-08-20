package com.agriscience.salesindent.model;

import com.agriscience.salesindent.model.CustomerMasterDetailsResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomerMasterResponse {

	@SerializedName("Acsen_CustomerMaster_Res")
	private List<CustomerMasterDetailsResponse> acsenCustomerMasterRes;

	public void setAcsenCustomerMasterRes(List<CustomerMasterDetailsResponse> acsenCustomerMasterRes){
		this.acsenCustomerMasterRes = acsenCustomerMasterRes;
	}

	public List<CustomerMasterDetailsResponse> getAcsenCustomerMasterRes(){
		return acsenCustomerMasterRes;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"acsen_CustomerMaster_Res = '" + acsenCustomerMasterRes + '\'' + 
			"}";
		}
}