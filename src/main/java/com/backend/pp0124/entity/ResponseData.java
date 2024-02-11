package com.backend.pp0124.entity;

import lombok.Data;

@Data
public class ResponseData {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private String rentalDays;
    private String checkoutDate;
    private String dueDate;
    private String dailyRentalCharge;
    private String chargeDays;
    private String preDiscountCharge;
    private String discountPercent;
    private String discountAmount;
    private String finalCharge;
}
