package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ToolType;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class ToolTypeCache {
    private static ToolTypeCache toolTypeCache;
    private HashMap<String, ToolType> map = new HashMap<>();

    private ToolTypeCache() {
        // Replace the hardcoded values with a database call to get the values when it is the right time
        map.put("Ladder", ToolType.builder()
                .toolType("Ladder")
                .dailyCharge(1.99)
                .weekdayCharge(true)
                .weekendCharge(true)
                .holidayCharge(false)
                .build());
        map.put("Chainsaw", ToolType.builder()
                .toolType("Chainsaw")
                .dailyCharge(1.49)
                .weekdayCharge(true)
                .weekendCharge(false)
                .holidayCharge(true)
                .build());
        map.put("Jackhammer", ToolType.builder()
                .toolType("Jackhammer")
                .dailyCharge(2.99)
                .weekdayCharge(true)
                .weekendCharge(false)
                .holidayCharge(false)
                .build());
    }
    // This method helps with a effective way of singleton implementation
    // This could be replaced with a better Cache as and when needed
    public static synchronized ToolTypeCache getInstance() {
        if (toolTypeCache == null) {
            toolTypeCache = new ToolTypeCache();
        }
        return toolTypeCache;
    }

    public ToolType getToolType(String toolType) {
        return map.get(toolType);
    }
}
