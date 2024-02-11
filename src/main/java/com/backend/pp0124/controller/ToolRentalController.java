package com.backend.pp0124.controller;

import com.backend.pp0124.entity.RequestPayLoad;
import com.backend.pp0124.entity.ResponseData;
import com.backend.pp0124.service.ToolRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ToolRentalController {
    private final ToolRentalService toolRentalService;

    @Autowired
    public ToolRentalController(ToolRentalService toolRentalService) {
        this.toolRentalService = toolRentalService;
    }

    @PostMapping("/reservation")
    public ResponseData processToolRentalRequest(@RequestBody @Valid RequestPayLoad requestPayLoad) {
        return toolRentalService.processToolRentalRequest(requestPayLoad);
    }
}
