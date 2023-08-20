package com.agriscience.salesindent;

/**
 * Created by Kanagaraj.M on 06/10/2016.
 */
public class CountryRemark {

    String code = null;
    String name = null;
    String cancelremarks=null;
    String eventdata =null;
    boolean selected = false;

    public CountryRemark(String code, String name, String cancelremarks,String eventdata, boolean selected) {
        super();
        this.code = code;
        this.name = name;
        this.cancelremarks = cancelremarks;
        this.eventdata = eventdata;
        this.selected = selected;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCancelremarks() {
        return cancelremarks;
    }
    public void setCancelremarks(String cancelremarks) {
        this.cancelremarks = cancelremarks;
    }

    public String getEventdata() {
        return eventdata;
    }
    public void setEventdata(String eventdata) {
        this.eventdata = eventdata;
    }


    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}