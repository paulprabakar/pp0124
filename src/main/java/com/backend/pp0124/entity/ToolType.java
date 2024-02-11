package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToolType {
    private String toolType;
    private Double dailyCharge;
    private boolean weekdayCharge;
    private boolean weekendCharge;
    private boolean holidayCharge;
}
