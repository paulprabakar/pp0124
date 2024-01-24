package com.backend.pp0124.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tools {
    String toolCode;
    String toolType;
    String brand;
}
