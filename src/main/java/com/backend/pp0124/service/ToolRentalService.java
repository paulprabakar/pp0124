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

@Component
public class ToolRentalService {

    public ResponseData processToolRentalRequest(RequestPayLoad requestPayLoad) {
        ResponseData responseData = new ResponseData();
        PrintOperations printOperations = new PrintOperations();
        
        try {
            String toolCode = requestPayLoad.getToolCode();
            ToolsCache toolsCache = ToolsCache.getInstance();
            ToolTypeCache toolTypeCache = ToolTypeCache.getInstance();
            Tools tool = toolsCache.getTools(toolCode);
            String toolType = tool.getToolType();
            LocalDate checkoutDate = LocalDate.parse(requestPayLoad.getCheckoutDate());
            LocalDate dueDate = checkoutDate.plusDays(requestPayLoad.getDaysCount());
            ToolType toolType = toolTypeCache.getToolType(toolType);
            DateOperations dateOperations = new DateOperations();
            short chargeDays = dateOperations.countNumberOfChargeableDays(checkoutDate, dueDate, toolType);
            double preDiscountCharge = toolType.getDailyCharge() * chargeDays;
            BigDecimal discount = new BigDecimal(preDiscountCharge * requestPayLoad.getDiscount() / 100);
            BigDecimal discountCharge = discount.setScale(2, RoundingMode.HALF_UP);
            BigDecimal totalCharge = new BigDecimal(preDiscountCharge - discountCharge.doubleValue());
            BigDecimal finalCharge = totalCharge.setScale(2, RoundingMode.HALF_UP);
    
            responseData.setToolCode(toolCode);
            responseData.setToolType(toolType);
            responseData.setToolBrand(tool.getBrand());
            responseData.setRentalDays(String.valueOf(requestPayLoad.getDaysCount()));
            responseData.setCheckoutDate(checkoutDate.toString());
            responseData.setDueDate(dueDate.toString());
            responseData.setDailyRentalCharge("$" + String.valueOf(toolType.getDailyCharge()));
            responseData.setChargeDays(String.valueOf(chargeDays));
            responseData.setPreDiscountCharge("$" + String.valueOf(preDiscountCharge));
            responseData.setDiscountPercent(requestPayLoad.getDiscount() + "%");
            responseData.setDiscountAmount("$" + String.valueOf(discountCharge));
            responseData.setFinalCharge("$" + String.valueOf(finalCharge));
    
            printOperations.printRentalAgreement(responseData);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
        }
        
        return responseData;
    }
}
