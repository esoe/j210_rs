package com.example.dev_j200_2.repo;

import com.example.dev_j200_2.entities.DomainEntity;
import com.example.dev_j200_2.entities.PersonEntity;
import com.example.dev_j200_2.entities.UsersEntity;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Set;

@Local
public interface AppRepositoryI {

    List<PersonEntity> findAllPerson();
    List<DomainEntity> findAllDomain();
    <T>List<T> findAll(Class<T> clazz);
    PersonEntity findPersonById(long id);
    UsersEntity findUserById(long id);
    <T>T findById(Class<T> clazz, long id);
    <T> void delete(Class<T> clazz, long id);
    <T> void save(T entity);
    <T> void update(T entity);
}
