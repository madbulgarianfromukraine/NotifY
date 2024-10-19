package com.example.notify.settings;

public class Setting {
    private String mainText;
    private String subText;

    public Setting(String mainText, String subText){
        this.mainText = mainText;
        this.subText = subText;
    }

    public String getMainText() {
        return mainText;
    }

    public String getSubText() {
        return subText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }
}
