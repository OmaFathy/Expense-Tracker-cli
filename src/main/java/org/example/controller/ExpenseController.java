package org.example.controller;

import org.example.commands.Command;
import org.example.factory.CommandFactory;

public class ExpenseController {
    private CommandFactory commandFactory;

    public ExpenseController(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void handleCommand(String input) {
        Command command = commandFactory.createCommand(input);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }
}
