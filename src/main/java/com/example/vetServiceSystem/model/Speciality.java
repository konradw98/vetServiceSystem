package com.example.vetServiceSystem.model;

import javax.persistence.*;

@Entity
@Table(name = "specialities")
public class Speciality  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    public Speciality(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Speciality() {
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
