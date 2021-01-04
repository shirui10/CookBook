package com.shirui.cookbook.Offline;

import java.io.Serializable;

public class offMealsBean implements Serializable {     // //JavaBean类，其中变量一一对应所需Json数据中的本地数据数组中的对象，实现Serializable接口序列化后可进行IO操作便于传输
    private String title;
    private String category;
    private String tag;
    private int picID;
    private String ingredients;
    private String measure;
    private String step;

    public offMealsBean(String title, String category, String tag, int picID, String ingredients, String measure, String step) {
        this.title = title;
        this.category = category;
        this.tag = tag;
        this.picID = picID;
        this.ingredients = ingredients;
        this.measure = measure;
        this.step = step;
    }

    public offMealsBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}