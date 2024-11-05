package org.example;

import org.example.controller.ExpenseController;
import org.example.factory.CommandFactory;
import org.example.model.ExpenseRepository;
import org.example.view.ExpenseCLI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ExpenseRepository repository = new ExpenseRepository();
        CommandFactory commandFactory = new CommandFactory(repository);
        ExpenseController controller = new ExpenseController(commandFactory);
        ExpenseCLI cli = new ExpenseCLI(controller);

        cli.start();
    }
}