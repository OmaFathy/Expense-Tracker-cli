package org.example.commands;

import org.example.model.ExpenseRepository;

public class DeleteExpenseCommand implements Command {
    private ExpenseRepository repository;
    private int id;

    public DeleteExpenseCommand(ExpenseRepository repository, int id)
    {
        this.repository = repository;
        this.id = id;
    }
    @Override
    public void execute() {
        repository.deleteExpense(id);
        System.out.println("Expense deleted successfully (ID: " + id + ")");
    }

}
