package com.moringaschool.outingapi2;

public class Member {
    private String Name;
    private String Type;
    private String Description;
    private String Dresscode;
    private String Time;
    private String imageURL;

    public Member() {
    }

    public String getName() {
        return Name;
    }

    public  void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDresscode() {
        return Dresscode;
    }

    public void setDresscode(String dresscode) {
        Dresscode = dresscode;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
