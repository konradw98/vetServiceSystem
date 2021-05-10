package com.example.vetServiceSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="types")
@MappedSuperclass
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
