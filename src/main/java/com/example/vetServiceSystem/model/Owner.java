package com.example.vetServiceSystem.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@MappedSuperclass
@Table(name="owners")
public class Owner extends BaseEntity {

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="telephone")
    private String telephoe;

    @OneToMany(cascade= CascadeType.ALL,mappedBy = "owner")
    private Set<Pet> pers = new HashSet<>();

    public Owner(Long id, String address, String city, String telephoe, Set<Pet> pers) {
        super(id);
        this.address = address;
        this.city = city;
        this.telephoe = telephoe;
        this.pers = pers;
    }

    public Owner(){};

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

    public String getTelephoe() {
        return telephoe;
    }

    public void setTelephoe(String telephoe) {
        this.telephoe = telephoe;
    }

    public Set<Pet> getPers() {
        return pers;
    }

    public void setPers(Set<Pet> pers) {
        this.pers = pers;
    }
}
