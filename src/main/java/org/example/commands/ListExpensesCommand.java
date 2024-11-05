package org.example.commands;

import org.example.model.Expense;
import org.example.model.ExpenseRepository;

import java.util.List;

public class ListExpensesCommand implements Command {
    private final ExpenseRepository repository;

    public ListExpensesCommand(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        List<Expense> expenses = repository.getAllExpenses();

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
        } else {
            System.out.printf("%-5s %-12s %-20s %s%n", "ID", "Date", "Description", "Amount");
            for (Expense expense : expenses) {
                System.out.printf("%-5d %-12s %-20s $%.2f%n",
                        expense.getId(),
                        expense.getDate(),
                        expense.getDescription(),
                        expense.getAmount());
            }
        }
    }
}