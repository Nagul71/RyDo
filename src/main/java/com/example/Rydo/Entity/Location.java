package com.example.Rydo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @Column(name = "loca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locaId;

    @Column(name = "Names")
    private String names;

    @OneToMany(mappedBy = "location")
    private List<Driver> drivers;

    // Getters and Setters


    public Integer getLocaId() {
        return locaId;
    }

    public void setLocaId(Integer locaId) {
        this.locaId = locaId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public List<Driver> getDriver() {
        return drivers;
    }

    public void setDriver(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
