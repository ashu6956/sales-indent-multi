package com.agriscience.salesindent.room_database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.agriscience.salesindent.model.ZOrganogramResponseDetails;

import java.util.List;


@Dao
public interface ZOrganogramDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ZOrganogramResponseDetails... responseDetails);

    @Query("Select * from ZOrganogramResponseDetails")
    List<ZOrganogramResponseDetails> getAllZOrganogramReponseDetails();

    @Query("Select * from ZOrganogramResponseDetails where inChargeT =:tInCharge")
    ZOrganogramResponseDetails getZOrganogramDetailsByUserId(String tInCharge);

    @Query("Select * from ZOrganogramResponseDetails where rbm =:rbmId")
    ZOrganogramResponseDetails getZOrganogramDetailsByRbmId(String rbmId);

    @Query("Select * from ZOrganogramResponseDetails where dbm =:dbmId")
    ZOrganogramResponseDetails getZOrganogramDetailsByDbmId(String dbmId);

    @Query("Select * from ZOrganogramResponseDetails where rbm =:rbmId")
    List<ZOrganogramResponseDetails> getAllZOrganogramReponseDetailsByRbmId(String rbmId);

}
