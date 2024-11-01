package com.example.demo.dao;

import com.example.demo.entity.Person;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findById(long id);

    Person findByName(String name);

    List<Person> findByCountry(String country);

    List<Person> findByCountryAndCity(String country, String city);
    List<Person> findByGender(String gender);
    List<Person> findByAge(Long age);
    List<Person> findByAgeGreaterThan(Long age);
    @Query("SELECT name FROM Person  WHERE age = :age")
    List<String> findNameByAge(Long age);
    @Query("SELECT name, address FROM Person  WHERE country = :country")
    List<String> findNameAndAddressByCountry(String country);
}
