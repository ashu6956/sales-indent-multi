package com.agriscience.salesindent.room_database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.room_database.entity.CustomerEntity;

import java.util.List;

@Dao
public interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CustomerEntity... customerEntities);

    @Query("Select * from customer_entity")
    List<CustomerEntity>  getAllCustomers();

    @Query("Select * from customer_entity where customer_code = :customerCode")
    CustomerEntity  getCustomerByCustomerCode(String customerCode);

    @Query("Delete from customer_entity where customer_code = :customerCode")
    void deleteCustomerByCustomerCode(String customerCode);


    @Query("Delete from customer_entity")
    void deleteAllCustomerData();

}
