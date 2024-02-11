package com.backend.pp0124.utils;

import com.backend.pp0124.entity.Tools;

import java.util.HashMap;
import java.util.Map;

public class ToolsCache {
    private static ToolsCache instance;
    private final Map<String, Tools> map = new HashMap<>();

    private ToolsCache() {
        initializeCache();
    }

    public static synchronized ToolsCache getInstance() {
        if (instance == null) {
            instance = new ToolsCache();
        }
        return instance;
    }

    private void initializeCache() {
        map.put("CHNS", Tools.builder()
                .toolCode("CHNS")
                .toolType("Chainsaw")
                .brand("Stihl")
                .build());
        map.put("LADW", Tools.builder()
                .toolCode("LADW")
                .toolType("Ladder")
                .brand("Werner")
                .build());
        map.put("JAKD", Tools.builder()
                .toolCode("JAKD")
                .toolType("Jackhammer")
                .brand("DeWalt")
                .build());
        map.put("JAKR", Tools.builder()
                .toolCode("JAKR")
                .toolType("Jackhammer")
                .brand("Ridgid")
                .build());
    }

    public Tools getTools(String toolCode) {
        return map.get(toolCode);
    }
}
