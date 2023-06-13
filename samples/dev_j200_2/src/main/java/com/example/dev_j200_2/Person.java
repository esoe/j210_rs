package com.example.dev_j200_2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {
    private long id;
    private String name;
    private Set<Passport> passports;

    public Person(long id, String name) {
        passports = new HashSet<>();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Passport> getPassports() {
        return new HashSet<>(passports);
    }

    public void addPassport(Passport passport){
        passports.add(passport);
        passport.setPerson(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
