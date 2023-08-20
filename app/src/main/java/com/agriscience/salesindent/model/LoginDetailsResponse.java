package com.agriscience.salesindent.model;

import com.google.gson.annotations.SerializedName;

public class LoginDetailsResponse {

    @SerializedName("Role")
    private String role;

    @SerializedName("UserName")
    private String userName;

    @SerializedName("id")
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("IsTm")
    private boolean isTM;

    @SerializedName("IsAm")
    private boolean isAM;

    @SerializedName("IsRbm")
    private boolean isRbM;

    public boolean isTM() {
        return isTM;
    }

    public void setTM(boolean TM) {
        isTM = TM;
    }

    public boolean isAM() {
        return isAM;
    }

    public void setAM(boolean AM) {
        isAM = AM;
    }

    public boolean isRbM() {
        return isRbM;
    }

    public void setRbM(boolean rbM) {
        isRbM = rbM;
    }

    public boolean isDbM() {
        return isDbM;
    }

    public void setDbM(boolean dbM) {
        isDbM = dbM;
    }

    @SerializedName("IsDbm")
    private boolean isDbM;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "LoginDetailsResponse{" +
                        "role = '" + role + '\'' +
                        ",userName = '" + userName + '\'' +
                        ",id = '" + id + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}