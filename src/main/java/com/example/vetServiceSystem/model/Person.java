package com.example.vetServiceSystem.model;

import javax.persistence.Column;

public class Person extends BaseEntity {

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(){}

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

}
