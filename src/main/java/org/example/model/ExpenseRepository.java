package org.example.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseRepository {
    private static final String FILE_PATH = "expenses.json";
    private ObjectMapper objectMapper;
    private List<Expense> expenses;

    public ExpenseRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Register the JavaTimeModule
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        expenses = new ArrayList<>();
        loadExpenses(); // Load tasks from the JSON file on initialization
    }

    private void loadExpenses() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, new ArrayList<Expense>());
            }
            else {
                if(file.length() == 0) {
                    expenses = new ArrayList<>();
                } else {
                    expenses = objectMapper.readValue(file, new TypeReference<List<Expense>>() {});


                }
            }
        } catch (IOException e) {
            System.err.println("Error loading expenses from file: " + e.getMessage());
        }
    }


    private void saveExpenses() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), expenses);
        } catch (IOException e) {
            System.err.println("Error saving expenses to file: " + e.getMessage());
        }
    }

    public void addExpense(String description, double amount) {
    //    Expense last = expenses.getLast();

        expenses.add(new Expense(description, amount));

        saveExpenses();
    }
    public void updateTask(int id, String description, double amount, LocalDate date) {
        try {
            for (Expense expense : expenses) {
                if (expense.getId() == id) {
                    expense.setDescription(description);
                    expense.setAmount(amount);
                    expense.setDate(date);
                    saveExpenses(); // Save the updated task to the JSON file
                    return;
                }
            }
            System.err.println("Task with ID " + id + " not found.");
        } catch (Exception e) {
            System.err.println("Error updating task: " + e.getMessage());
        }
    }
    public void deleteExpense(int id){
        try {
            for (int i = 0; i < expenses.size(); i++) {
                if (expenses.get(i).getId() == id) {
                    expenses.remove(i);
                    saveExpenses(); // Save the updated list to the JSON file
                    return;
                }
            }
            System.err.println("Task with ID " + id + " not found.");
        } catch (Exception e) {
            System.err.println("Error deleting task: " + e.getMessage());
        }
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }
    public List<Expense> getExpensesByMonth(int month) {
        return expenses.stream().filter(expense -> expense.getDate().getMonthValue() == month).collect(Collectors.toList());
    }

    public  int getId() {
        return expenses.size();
    }

}
