package com.example.ntk_thtuan7;

public class FriendsModel {
    String image,name,age;

    FriendsModel(){

    }

    public FriendsModel(String image, String name, String age) {
        this.image = image;
        this.name = name;
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
