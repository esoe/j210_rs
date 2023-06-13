package com.example.dev_j200_2;

import jakarta.ejb.Local;

import java.util.Set;

@Local
public interface PersonService {

    Set<Person> getAllPerson();
}
