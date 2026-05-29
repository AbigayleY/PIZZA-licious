package com.pluralsight.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptWriter {

    public void saveReceipt(String receiptText) {
        try {
            File folder = new File("receipts");

            if (!folder.exists()){
                folder.mkdir();
            }

            //Creating timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss-SSS"));

            //Creating File Name
            String fileName = "receipts/" + timestamp + ".txt";

            // Writing receipt
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            writer.println(receiptText);

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving receipt");
            System.out.println(e.getMessage());}
    }
    }