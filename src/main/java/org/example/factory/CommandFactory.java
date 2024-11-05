package org.example.factory;

import org.example.commands.*;
import org.example.model.ExpenseRepository;

public class CommandFactory {
    private ExpenseRepository repository;

    public CommandFactory(ExpenseRepository repository) {
        this.repository = repository;
    }

    public Command createCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();

        switch (command) {
            case "add":
                // Handle add command
                break;

            case "update":
                // Handle update command
                break;

            case "delete":
                // Handle delete command
                break;

            case "list":
                // Handle list command
                break;

            case "summary":
                if (parts.length > 1 && parts[1].contains("--month")) {
                    // Extract the month from the input
                    String[] monthParts = parts[1].split("--month");
                    if (monthParts.length > 1) {
                        try {
                            int month = Integer.parseInt(monthParts[1].trim());
                            return new MonthSummaryExpenseCommand(repository, month);
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid month format.");
                        }
                    }
                }
                // Default summary (total expenses)
                return new AllSummaryExpenseCommand(repository);

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
        return null;
    }
}
