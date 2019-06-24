package com.popwerjun.spring;

/**
 * Created by Administrator on 2019/6/24.
 */
public class ConstructDIBean {

    private int years;

    private String ultimateAnswer;

    public ConstructDIBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
