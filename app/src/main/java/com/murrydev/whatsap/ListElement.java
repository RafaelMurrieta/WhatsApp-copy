package com.murrydev.whatsap;

public class ListElement {
    public String name,profile,msg,checked,dates,alertMsg;

    public ListElement(String name, String profile, String msg, String checked, String dates, String alertMsg) {
        this.name = name;
        this.profile = profile;
        this.msg = msg;
        this.checked = checked;
        this.dates = dates;
        this.alertMsg = alertMsg;
    }

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
