package com.cityguide.HelperClasses.CategoriesAdapter;

public class CategoriesHelperClass {
    int image;
    String title, description;

    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }
    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

}
