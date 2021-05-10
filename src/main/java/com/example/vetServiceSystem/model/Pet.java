package com.example.vetServiceSystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pets")
@MappedSuperclass
public class Pet extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visists=new HashSet<>();

    public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visists) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthDate = birthDate;
        this.visists = visists;
    }

    public Pet(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Visit> getVisists() {
        return visists;
    }

    public void setVisists(Set<Visit> visists) {
        this.visists = visists;
    }
}
