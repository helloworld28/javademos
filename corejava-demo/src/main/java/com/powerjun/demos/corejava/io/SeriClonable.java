package com.powerjun.demos.corejava.io;

import java.io.*;

public class SeriClonable implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            objectOutputStream.writeObject(this);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
            return objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return super.clone();
    }
}

