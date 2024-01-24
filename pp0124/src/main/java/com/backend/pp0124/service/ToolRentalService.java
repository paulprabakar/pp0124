package com.backend.pp0124.service;

import com.backend.pp0124.entity.RequestPayLoad;
import com.backend.pp0124.entity.ResponseData;
import com.backend.pp0124.entity.ToolType;
import com.backend.pp0124.utils.DateOperations;
import com.backend.pp0124.utils.PrintOperations;
import com.backend.pp0124.utils.ToolTypeCache;
import com.backend.pp0124.utils.ToolsCache;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class ToolRentalService {

    public ResponseData processToolRentalRequest(RequestPayLoad requestPayLoad)
    {
        ResponseData responseData = new ResponseData();
        PrintOperations printOperations = new PrintOperations();
        String toolTypeName = ToolsCache.getInstance().getTools(requestPayLoad.getToolCode()).getToolType();
        DateOperations dateOperations = new DateOperations();
        LocalDate checkoutDate = LocalDate.parse(requestPayLoad.getCheckoutDate());
        LocalDate dueDate = checkoutDate.plusDays(requestPayLoad.getDaysCount());


        ToolType toolType = ToolTypeCache.getInstance().getToolType(toolTypeName);
        short chargeDays = dateOperations.countNumberOfChargeableDays(checkoutDate, dueDate, toolType);
        double preDiscountCharge = toolType.getDailyCharge() * chargeDays;
        BigDecimal discount = new BigDecimal(preDiscountCharge * requestPayLoad.getDiscount() / 100);
        BigDecimal discountCharge = discount.setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalCharge = new BigDecimal(preDiscountCharge - discountCharge.doubleValue());
        BigDecimal finalCharge = totalCharge.setScale(2, RoundingMode.HALF_UP);
        try {
            responseData.setToolCode(requestPayLoad.getToolCode());
            responseData.setToolType(toolTypeName);
            responseData.setToolBrand(ToolsCache.getInstance().getTools(requestPayLoad.getToolCode()).getBrand());
            responseData.setRentalDays(requestPayLoad.getDaysCount().toString());
            responseData.setCheckoutDate(checkoutDate.toString());
            responseData.setDueDate(checkoutDate.plusDays(requestPayLoad.getDaysCount()).toString());
            responseData.setDailyRentalCharge("$" + toolType.getDailyCharge().toString());
            responseData.setChargeDays(String.valueOf(chargeDays));
            responseData.setPreDiscountCharge("$" + String.valueOf(preDiscountCharge));
            responseData.setDiscountPercent(requestPayLoad.getDiscount().toString() + "%");

            responseData.setDiscountAmount("$" + String.valueOf(discountCharge));
            responseData.setFinalCharge("$" + String.valueOf(finalCharge.doubleValue()));
            printOperations.printRentalAgreement(responseData);
            return responseData;

        } catch (Exception e) {
            e.printStackTrace();
            responseData.setToolCode(requestPayLoad.getToolCode());
            responseData.setRentalDays(requestPayLoad.getDaysCount().toString());
            responseData.setCheckoutDate(checkoutDate.toString());
            responseData.setDueDate(checkoutDate.plusDays(requestPayLoad.getDaysCount()).toString());
            responseData.setDiscountPercent(requestPayLoad.getDiscount().toString() + "%");

            return responseData;
        }
    }
}
