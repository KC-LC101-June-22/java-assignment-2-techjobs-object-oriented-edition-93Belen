package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    int id;
    static int nextId = 1;
    String value;

    public JobField(){
        this.id = nextId;
        nextId++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id && Objects.equals(value, jobField.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.value;
    }

    //nextId <-
    //value <-
    //toString
    //equals <-
    //hashcode <-
    //getValue <-
    //setValue <-
    //getId <-
}
