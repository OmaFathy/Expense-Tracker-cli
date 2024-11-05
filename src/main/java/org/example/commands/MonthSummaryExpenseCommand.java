package org.example.commands;

import org.example.model.Expense;
import org.example.model.ExpenseRepository;

public class MonthSummaryExpenseCommand implements Command {

    private  ExpenseRepository repository;
    private int month;

    public MonthSummaryExpenseCommand(ExpenseRepository repository, int month) {
        this.repository = repository;
        this.month = month;
    }
    @Override
    public void execute() {
        double sum = repository.getExpensesByMonth(month).stream().mapToDouble(Expense::getAmount).sum();

        System.out.println("Total expenses in month " + month + ": " + sum);

    }
}

