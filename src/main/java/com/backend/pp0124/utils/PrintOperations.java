package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ResponseData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrintOperations {
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

    public void printRentalAgreement(ResponseData responseData) {
        System.out.println("Tool Code: " + responseData.getToolCode());
        System.out.println("Tool Type: " + responseData.getToolType());
        System.out.println("Brand: " + responseData.getToolBrand());
        System.out.println("Rental Days: " + responseData.getRentalDays());
        
        printDate("CheckoutDate", responseData.getCheckoutDate());
        printDate("Due Date", responseData.getDueDate());
        
        System.out.println("Daily Rental Charge: " + responseData.getDailyRentalCharge());
        System.out.println("Charge Days: " + responseData.getChargeDays());
        System.out.println("Pre-Discount Charge: " + responseData.getPreDiscountCharge());
        System.out.println("Discount Percent: " + responseData.getDiscountPercent());
        System.out.println("Discount Amount: " + responseData.getDiscountAmount());
        System.out.println("Final Charge: " + responseData.getFinalCharge());
    }
    
    private void printDate(String label, String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        System.out.println(label + ": " + date.format(dateFormatter));
    }
}
