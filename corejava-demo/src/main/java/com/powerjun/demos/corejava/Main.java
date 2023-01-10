package com.powerjun.demos.corejava;

public class Main {
    public static void main(String[] args) {
        Manager cfo = new Manager();
        Manager ceo = new Manager();
        Pair<Manager> managers = new Pair<>(cfo, ceo);

        Pair<Employee> employeePair = new Pair<>();

        Pair<? extends Employee> wildcards = managers;
        wildcards = employeePair;
        Manager employee = new Manager();
//        wildcards.setFirst(employee);
//        Employee employee1 = wildcards.getSecond();


    }
}
