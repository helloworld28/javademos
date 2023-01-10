package com.powerjun.demos.corejava.io;

import com.powerjun.demos.corejava.Employee;
import com.powerjun.demos.corejava.Manager;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class ObjectSerialization {
    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.dat"));
        Employee secretary = new Employee("Secretary", 100,  LocalDate.now());
        Employee manager = new Manager("manager1", 200, LocalDate.now(),secretary);
        Employee manager2 = new Manager("manager2", 300, LocalDate.now(),secretary);



        objectOutputStream.writeObject(secretary);
        objectOutputStream.writeObject(manager);
        objectOutputStream.writeObject(manager2);

        objectOutputStream.close();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee secretary2 = (Employee) objectInputStream.readObject();
            Manager manager3 = (Manager) objectInputStream.readObject();
            Manager manager4 = (Manager) objectInputStream.readObject();

            System.out.println(secretary2 == secretary);
            System.out.println(manager3.getSecretary() == manager4.getSecretary());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Employee foo = new Employee("Foo", 120, LocalDate.now());
        Employee foo2 = (Employee) foo.clone();
        System.out.println(foo.getHiredDate() == foo2.getHiredDate());



    }
}
