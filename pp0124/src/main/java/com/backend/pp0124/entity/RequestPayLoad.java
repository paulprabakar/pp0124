package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;


import jakarta.validation.constraints.*;

@Data
@Builder
public class RequestPayLoad {
    @NotBlank(message = "Invalid ToolCode: Empty ToolCode")
    @NotNull(message = "Invalid ToolCode: ToolCode is NULL")
    String toolCode;

    @Min(value = 1, message = "Invalid Discount: Rental day count is not 1 or greater")
    Short daysCount;

    @Min(value = 0, message = "Invalid Discount: Discount percent is not in the range 0-100")
    @Max(value = 100, message = "Invalid Discount: Discount percent is not in the range 0-100")
    Short discount;

    @NotBlank(message = "Invalid CheckoutDate: Empty CheckoutDate")
    @NotNull(message = "Invalid CheckoutDate: CheckoutDate is NULL")
    String checkoutDate;
}
