package com.popwerjun.spring;

/**
 * Created by Administrator on 2019/6/24.
 */
public class CircusBeanB {

    private CircusBeanA circusBeanA;

    public CircusBeanB() {
    }

    public CircusBeanB(CircusBeanA circusBeanA) {
        this.circusBeanA = circusBeanA;
    }

    public void setCircusBeanA(CircusBeanA circusBeanA) {
        this.circusBeanA = circusBeanA;
    }
}
