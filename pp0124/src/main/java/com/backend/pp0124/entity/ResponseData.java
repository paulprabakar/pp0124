package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;

@Data
//@Builder
public class ResponseData {
    String toolCode;
    String toolType;
    String toolBrand;
    String rentalDays;
    String checkoutDate;
    String dueDate;
    String dailyRentalCharge;
    String chargeDays;
    String preDiscountCharge;
    String discountPercent;
    String discountAmount;
    String finalCharge;


}
