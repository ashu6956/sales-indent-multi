package com.agriscience.salesindent.room_database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "season_entity")
public class SeasonEntity {

    public String getSeasonStartDate() {
        return seasonStartDate;
    }


    public void setSeasonStartDate(String seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public String getSeasonCode() {
        return seasonCode;
    }

    public void setSeasonCode(String seasonCode) {
        this.seasonCode = seasonCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(String seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NonNull
    public String getCropCode() {
        return cropCode;
    }

    public void setCropCode(@NonNull String cropCode) {
        this.cropCode = cropCode;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @ColumnInfo(name = "season_start_date")
    private String seasonStartDate;

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "season_code")
    private String seasonCode;

    @ColumnInfo(name = "message")
    private String message;

    @ColumnInfo(name = "season_end_date")
    private String seasonEndDate;


    @ColumnInfo(name = "status")
    private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "crop_code")
    private String cropCode;

    @ColumnInfo(name = "season_name")
    private String seasonName;

    @ColumnInfo(name = "crop_name")
    private String cropName;

    @ColumnInfo(name = "active")
    private String active;

    @ColumnInfo(name = "return_cut_off_date")
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

    @ColumnInfo(name = "description")
    private String description;


    @ColumnInfo(name = "state")
    private String state;

    @Override
    public String toString() {
        return "SeasonEntity{" +
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
