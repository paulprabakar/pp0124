package com.backend.pp0124.entity;

import jakarta.validation.constraints.*;

@Data
@Builder
public class RequestPayload {
    @NotBlank(message = "ToolCode cannot be blank")
    @NotNull(message = "ToolCode cannot be null")
    String toolCode;

    @Min(value = 1, message = "DaysCount must be at least 1")
    Short daysCount;

    @Min(value = 0, message = "Discount must be between 0 and 100")
    @Max(value = 100, message = "Discount must be between 0 and 100")
    Short discount;

    @NotBlank(message = "CheckoutDate cannot be blank")
    @NotNull(message = "CheckoutDate cannot be null")
    String checkoutDate;
}
