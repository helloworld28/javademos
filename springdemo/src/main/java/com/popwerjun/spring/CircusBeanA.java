package com.popwerjun.spring;

/**
 * Created by Administrator on 2019/6/24.
 */
public class CircusBeanA {

    private CircusBeanB circusBeanB;

    public CircusBeanA() {
    }

    public CircusBeanA(CircusBeanB circusBeanB) {
        this.circusBeanB = circusBeanB;
    }

    public void setCircusBeanB(CircusBeanB circusBeanB) {
        this.circusBeanB = circusBeanB;
    }
}
