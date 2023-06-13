package com.example.dev_j200_2;

import java.util.Objects;

public class Passport {
    private int serial;
    private int number;
    private Person person;

    public Passport(int serial, int number) {
        this.serial = serial;
        this.number = number;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return serial == passport.serial && number == passport.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, number);
    }
}
