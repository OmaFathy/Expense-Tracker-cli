package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Expense {
    private static int idCounter = 0;
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String description;
    private double amount;

    public Expense() {
        this.id = ++idCounter;
        this.date = LocalDate.now();
    }

    public Expense(String description, double amount) {
        this.id = ++idCounter;
        this.date = LocalDate.now();
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    // Change parameter type from LocalDateTime to LocalDate
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
