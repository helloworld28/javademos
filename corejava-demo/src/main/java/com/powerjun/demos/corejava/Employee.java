package com.powerjun.demos.corejava;

import com.powerjun.demos.corejava.io.SeriClonable;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends SeriClonable implements Serializable {

    private String name;
    private int salary;
    private LocalDate hiredDate;

    public Employee(String name, int salary, LocalDate hiredDate) {
        this.name = name;
        this.salary = salary;
        this.hiredDate = hiredDate;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }
}
