package com.example.Rydo.Entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RATE")
public class Rate {

    @Id
    @Column(name = "rate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rateId;

    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    private Location source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dest_id")
    private Location destin;

    @OneToMany(mappedBy = "rate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bookings> bookings;

    // Getters and Setters


    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestin() {
        return destin;
    }

    public void setDestin(Location destin) {
        this.destin = destin;
    }

    public List<Bookings> getBookings() {
        return bookings;
    }

    public void setBookings(List<Bookings> bookings) {
        this.bookings = bookings;
    }
}

