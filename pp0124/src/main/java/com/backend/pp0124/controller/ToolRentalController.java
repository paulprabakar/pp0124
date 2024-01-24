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
@RequestMapping("/")
public class ToolRentalController {
    @Autowired
    ToolRentalService localToolRentalService;

    @PostMapping("/reservation")
    public ResponseData saveEmployee(@RequestBody @Valid RequestPayLoad requestPayLoad) {
        ToolRentalService toolRentalService = new ToolRentalService();
        return toolRentalService.processToolRentalRequest(requestPayLoad);

    }
}
