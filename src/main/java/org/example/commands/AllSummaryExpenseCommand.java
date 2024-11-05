package org.example.commands;

import org.example.model.*;

public class AllSummaryExpenseCommand implements Command {
    private final ExpenseRepository repository;

    public AllSummaryExpenseCommand(ExpenseRepository repository) {
        this.repository = repository;
    }
    @Override
    public void execute() {
        double sum = repository.getAllExpenses().stream().mapToDouble(Expense::getAmount).sum();

        System.out.println("Total expenses: " + sum);
    }
}
