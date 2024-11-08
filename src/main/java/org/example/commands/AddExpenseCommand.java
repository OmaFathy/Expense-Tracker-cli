package org.example.commands;

import org.example.model.Expense;
import org.example.model.ExpenseRepository;

public class AddExpenseCommand implements Command {
        private ExpenseRepository repository;
        private String description;
        private double amount;

        public AddExpenseCommand(ExpenseRepository repository, String description, double amount) {
            this.repository = repository;
            this.description = description;
            this.amount = amount;
        }

        @Override
        public void execute() {
          //  Expense expense = new Expense(description, amount);
            repository.addExpense(description,amount);
            System.out.println("Expense added successfully (ID: " + repository.getId() + ")");
        }

}
