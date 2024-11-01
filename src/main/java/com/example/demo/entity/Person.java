package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "person_record")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "person_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;


    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Column(name = "DOB")
    private String dob;

    @Column(name = "Age")
    private Long age;




    @Column(name = "Gender")
    private String gender;

    @Column(name = "record_create_ts")
    @CreationTimestamp
    private Timestamp rcd_crt_ts;

    @Column(name = "record_update_ts")
    @UpdateTimestamp
    private Timestamp rcd_upd_ts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getRcd_crt_ts() {
        return rcd_crt_ts;
    }

    public void setRcd_crt_ts(Timestamp rcd_crt_ts) {
        this.rcd_crt_ts = rcd_crt_ts;
    }

    public Timestamp getRcd_upd_ts() {
        return rcd_upd_ts;
    }

    public void setRcd_upd_ts(Timestamp rcd_upd_ts) {
        this.rcd_upd_ts = rcd_upd_ts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}


