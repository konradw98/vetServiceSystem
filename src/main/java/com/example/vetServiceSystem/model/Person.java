package com.example.vetServiceSystem.model;

import javax.persistence.Column;


public class Person extends BaseEntity {

    public Person(Long id, String firstname, String lastname) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(){
        super();
    }

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
