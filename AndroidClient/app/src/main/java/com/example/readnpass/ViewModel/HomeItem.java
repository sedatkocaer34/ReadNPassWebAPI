package com.example.readnpass.ViewModel;

public class HomeItem {
    public String desc;
    public String title;
    public String id;
    public String photo;
    public boolean satilik;
    public boolean takas;

    public HomeItem(String desc, String id) {
        this.desc = desc;
        this.id = id;
    }

    public HomeItem( String id,String title,String desc, String photo, boolean satilik, boolean takas) {
        this.desc = desc;
        this.id = id;
        this.photo = photo;
        this.satilik = satilik;
        this.takas = takas;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean getSatilik() {
        return satilik;
    }

    public void setSatilik(boolean satilik) {
        this.satilik = satilik;
    }

    public boolean getTakas() {
        return takas;
    }

    public void setTakas(boolean takas) {
        this.takas = takas;
    }

    public HomeItem(){ }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
