package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToolType {
    String toolType;
    Double dailyCharge;
    boolean weekdayCharge;
    boolean weekendCharge;
    boolean holidayCharge;
}
