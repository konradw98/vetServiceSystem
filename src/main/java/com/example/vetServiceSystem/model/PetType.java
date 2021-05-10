package com.example.vetServiceSystem.model;

import javax.persistence.Column;

public class PetType extends BaseEntity{

    @Column(name="name")
    private String name;

    public PetType(Long id, String name){
        super(id);
        this.name=name;
    }

    public PetType(){};

    @Override
    public String toString() {
        return name;
    }
}
