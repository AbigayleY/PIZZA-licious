package com.pluralsight.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptWriter {

    public void saveReceipt(String receiptText) {
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            String fileName = "receipts/" + timestamp + ".txt";

            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(receiptText);

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving receipt");}
    }
    }