package com.backend.pp0124.utils;

import com.backend.pp0124.entity.ToolType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ToolTypeCache {
    private static ToolTypeCache instance;
    private final Map<String, ToolType> map = new HashMap<>();

    private ToolTypeCache() {
        initializeCache();
    }

    public static synchronized ToolTypeCache getInstance() {
        if (instance == null) {
            instance = new ToolTypeCache();
        }
        return instance;
    }

    private void initializeCache() {
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

    public ToolType getToolType(String toolType) {
        return map.get(toolType);
    }
}
