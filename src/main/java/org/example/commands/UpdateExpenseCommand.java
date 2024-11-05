package org.example.commands;

import org.example.model.ExpenseRepository;

import java.time.LocalDate;
public class UpdateExpenseCommand implements Command {
    private ExpenseRepository repository;
    private int id;
    private String description;
    private double amount;
    private LocalDate date;

    public UpdateExpenseCommand(ExpenseRepository repository, int id, String description, double amount) {
        this.repository = repository;
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    @Override
    public void execute() {
        //  Expense expense = new Expense(description, amount);
        repository.updateTask(id,description,amount,date);
        System.out.println("Expense updated successfully (ID: " + id + ")");
    }

}