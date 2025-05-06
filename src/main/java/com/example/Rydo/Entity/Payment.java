package com.example.Rydo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column(name = "amount_paid")
    private double amountPaid;
    private String status;


    @OneToOne
    @JoinColumn(name = "booking_id")
    private Bookings booking;

    // Getters and Setters


    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }
}
