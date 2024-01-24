package com.backend.pp0124.utils;

import com.backend.pp0124.entity.Tools;

import java.util.HashMap;

public class ToolsCache {
    private static ToolsCache toolsCache;
    private HashMap<String, Tools> map = new HashMap<>();

    private  ToolsCache() {
        // Replace the hardcoded values with a database call to get the values when it is the right time
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
    // This method helps with a effective way of singleton implementation
    // This could be replaced with a better Cache as and when needed
    public static synchronized ToolsCache getInstance() {
        if (toolsCache == null) {
            toolsCache = new ToolsCache();
        }
        return toolsCache;
    }

    public Tools getTools(String toolCode) {
        return map.get(toolCode);
    }

}
