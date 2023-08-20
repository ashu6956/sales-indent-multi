package com.agriscience.salesindent.room_database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.agriscience.salesindent.model.STOMaterialDetailsResponse;
import com.agriscience.salesindent.model.ZOrganogramResponseDetails;
import com.agriscience.salesindent.room_database.dao.CustomerDao;
import com.agriscience.salesindent.room_database.dao.MaterialDao;
import com.agriscience.salesindent.room_database.dao.PlantDao;
import com.agriscience.salesindent.room_database.dao.STOIndentTmpDao;
import com.agriscience.salesindent.room_database.dao.STOMaterialDao;
import com.agriscience.salesindent.room_database.dao.SalesIndentDetailsDao;
import com.agriscience.salesindent.room_database.dao.SalesIndentTmpDao;
import com.agriscience.salesindent.room_database.dao.SeasonDao;
import com.agriscience.salesindent.room_database.dao.ZOrganogramDetailsDao;
import com.agriscience.salesindent.room_database.entity.CustomerEntity;
import com.agriscience.salesindent.room_database.entity.MaterialEntity;
import com.agriscience.salesindent.room_database.entity.STOIndentTmpEntity;
import com.agriscience.salesindent.room_database.entity.SalesIndentDetailsTmpEntity;
import com.agriscience.salesindent.room_database.entity.SalesIndentRequestDetailsEntity;
import com.agriscience.salesindent.room_database.entity.SeasonEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.agriscience.salesindent.model.PlantDetailsResponse;

@Database(entities = {CustomerEntity.class, MaterialEntity.class, SeasonEntity.class, SalesIndentDetailsTmpEntity.class, SalesIndentRequestDetailsEntity.class, ZOrganogramResponseDetails.class, PlantDetailsResponse.class, STOMaterialDetailsResponse.class, STOIndentTmpEntity.class}, version = 1, exportSchema = false)
public abstract class SalesIndentDataBase extends RoomDatabase {

    public static volatile SalesIndentDataBase INSTANCE;

    public static final String DATABASE_NAME = "sales_indent";
    public static final int NUMBER_OF_THREADS = 20;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static SalesIndentDataBase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SalesIndentDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SalesIndentDataBase.class, DATABASE_NAME)
                            .setQueryCallback((s, list) -> {
                                Log.d("SalesIndentDataBase", s + " " + list);
                            }, Executors.newSingleThreadExecutor())
                            .build();
                }

            }
        }

        return INSTANCE;
    }

    public abstract CustomerDao customerDao();

    public abstract MaterialDao materialDao();

    public abstract SeasonDao seasonDao();

    public abstract SalesIndentDetailsDao salesIndentDetailsDao();

    public abstract SalesIndentTmpDao salesIndentTmpDao();

    public abstract ZOrganogramDetailsDao zOrganogramDetailsDao();

    public abstract PlantDao plantDao();

    public abstract STOMaterialDao stoMaterialDao();

    public abstract STOIndentTmpDao stoIndentTmpDao();
}
