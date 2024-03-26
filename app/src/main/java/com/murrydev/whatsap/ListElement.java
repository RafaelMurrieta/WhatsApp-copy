package com.murrydev.whatsap;

public class ListElement {
    public String name;
    public String profile;
    public String msg;
    public String checked;
    public String dates;
    public String alertMsg;



    public String setImg;

    public ListElement() {
    }

    public ListElement(String name, String profile, String msg, String checked, String dates, String alertMsg,String setImg) {
        this.name = name;
        this.profile = profile;
        this.msg = msg;
        this.checked = checked;
        this.dates = dates;
        this.alertMsg = alertMsg;
        this.setImg = setImg;
    }

    public String getSetImg() {return setImg;}

    public void setSetImg(String setImg) {this.setImg = setImg;}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getAlertMsg() {
        return alertMsg;
    }

    public void setAlertMsg(String alertMsg) {
        this.alertMsg = alertMsg;
    }
}
