package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tools {
    private String toolCode;
    private String toolType;
    private String brand;
}
