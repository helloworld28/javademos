package com.powerjun.demos.corejava;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Manager extends Employee implements Serializable {


    public Manager(String name, int salary, LocalDate hiredDate, Employee secretary) {
        super(name, salary, hiredDate);
        this.secretary = secretary;
    }

    public Manager(Employee secretary) {
        this.secretary = secretary;
    }

    public Manager(){}

    private Employee secretary;

    public Employee getSecretary() {
        return secretary;
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }
}
