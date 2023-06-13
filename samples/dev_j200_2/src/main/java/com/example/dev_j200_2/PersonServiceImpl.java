package com.example.dev_j200_2;

import jakarta.ejb.Stateful;

import java.util.HashSet;
import java.util.Set;

@Stateful
public class PersonServiceImpl implements PersonService{

    private static Set<Person> persons;

    static {
        persons = new HashSet<>();
        Person p1 = new Person(1, "Andrey");
        p1.addPassport(new Passport(5654, 548785));
        persons.add(p1);
        Person p2 = new Person(2, "Michail");
        p2.addPassport(new Passport(1234, 55685));
        p2.addPassport(new Passport(4321, 57785));
        persons.add(p2);
        Person p3 = new Person(3, "Olga");
        p3.addPassport(new Passport(4500, 236777));
        persons.add(p3);
        Person p4 = new Person(4, "Yana");
        p4.addPassport(new Passport(1204, 521004));
        persons.add(p4);
        Person p5 = new Person(5, "Alexsandr");
        p5.addPassport(new Passport(9513, 300540));
        persons.add(p5);
        persons.add(new Person(6, "Boby"));
    }

    @Override
    public Set<Person> getAllPerson() {
        return persons;
    }
}
