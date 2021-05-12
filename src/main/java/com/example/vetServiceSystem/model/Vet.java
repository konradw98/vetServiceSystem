package com.example.vetServiceSystem.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="vets")
public class Vet {
    // TO TYLKO VET I SPECIALITY TO NIEWAZNE TO NA KONCU MOZNA NAJWYZEJ I TAK NIE ZMIENIA TO FUNKCJONALNOSCI, NAWET MOZNA TO POMINAC
    ///TODO Many to Many relationship to implement
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties;



    public Vet(Long id, String firstname, String lastname, Set<Specialty> specialties) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.specialties = specialties;
    }

    public Vet(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
