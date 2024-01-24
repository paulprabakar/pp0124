package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ResponseData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrintOperations {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");

    public void printRentalAgreement(ResponseData responseData) {
        System.out.println("Tool Code: " + responseData.getToolCode());
        System.out.println("Tool Type: " + responseData.getToolType());
        System.out.println("Brand: " + responseData.getToolBrand());
        System.out.println("Rental Days: " + responseData.getRentalDays());
        LocalDate date = LocalDate.parse(responseData.getCheckoutDate());
        System.out.println("CheckoutDate: " + date.format(dateTimeFormatter));
        date = LocalDate.parse(responseData.getDueDate());
        System.out.println("Due Date:  " + date.format(dateTimeFormatter));
        System.out.println("Daily Rental Charge: " + responseData.getDailyRentalCharge());
        System.out.println("Charge Days: " + responseData.getChargeDays());
        System.out.println("Pre-Discount Charge: " + responseData.getPreDiscountCharge());
        System.out.println("Discount Percent: " + responseData.getDiscountPercent());
        System.out.println("Discount Amount: " + responseData.getDiscountAmount());
        System.out.println("Final Charge: " + responseData.getFinalCharge());

    }
}
