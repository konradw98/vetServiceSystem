package com.example.vetServiceSystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name="vets")
public class Vet extends  Person{

    ///TODO Many to Many relationship to implement
    private Set<Speciality> specialities= new HashSet<>();
}
