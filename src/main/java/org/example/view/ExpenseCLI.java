package org.example.view;

import org.example.controller.ExpenseController;

import java.util.Scanner;

public class ExpenseCLI {
    private ExpenseController controller;

    public ExpenseCLI(ExpenseController controller) {
        this.controller = controller;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Expense Tracker CLI!");
        System.out.println("Enter a command (type 'exit' to quit):");

        while (true) {
            System.out.print("expense-tracker> ");
            String input = scanner.nextLine().trim();

            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting the application.");
                break;
            }

            controller.handleCommand(input);
        }

        scanner.close();
    }
}
