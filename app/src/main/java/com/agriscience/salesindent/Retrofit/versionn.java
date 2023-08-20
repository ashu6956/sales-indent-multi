package com.agriscience.salesindent.Retrofit;

import com.google.gson.annotations.SerializedName;

public class versionn {
    @SerializedName("V")
    public  String V;
    @SerializedName("L")
    public  String   L;

    public versionn(String v, String l) {
        V = v;
        L = l;
    }

    public void setV(String v) {
        V = v;
    }

    public void setL(String l) {
        L = l;
    }

    public String getV() {
        return V;
    }

    public String getL() {
        return L;
    }
}
