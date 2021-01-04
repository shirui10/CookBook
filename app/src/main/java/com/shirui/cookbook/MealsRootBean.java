package com.shirui.cookbook;


import java.io.Serializable;
import java.util.List;

public class MealsRootBean implements Serializable {    //JavaBean类，因为获取到的Json数据为复杂数据，其为数组与对象的结合，该类中的变量对应所需Json数据中的Json数组，实现Serializable接口序列化后可进行IO操作便于传输

    private List<MealsBean> meals;

    public MealsRootBean(List<MealsBean> meals) {
        this.meals = meals;
    }

    public MealsRootBean() {
    }


    public List<MealsBean> getMeals() {
        return meals;
    }

    public void setMeals(List<MealsBean> meals) {
        this.meals = meals;
    }
}
