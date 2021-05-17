package com.example.vetServiceSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public PetType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PetType() {
    }

    ;

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
}
