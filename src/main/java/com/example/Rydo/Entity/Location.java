package com.example.Rydo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
    @Column(name = "loca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locaId;

    @Column(name = "Names")
    private String names;

    @OneToMany(mappedBy = "location")
    private Driver driver;


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rate> rates;




    // Getters and Setters


    public int getLocaId() {
        return locaId;
    }

    public void setLocaId(int locaId) {
        this.locaId = locaId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
