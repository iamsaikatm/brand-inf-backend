package com.saikat.influencerapp.controller;

import com.saikat.influencerapp.dto.BrandProfileRequest;
import com.saikat.influencerapp.entity.BrandProfile;
import com.saikat.influencerapp.service.BrandProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandProfileController {

    @Autowired
    private BrandProfileService service;

    @PostMapping("/profile")
    public BrandProfile createOrUpdate(@RequestBody BrandProfileRequest request) {
        return service.createOrUpdate(request);
    }

    @GetMapping("/profile/{userId}")
    public BrandProfile getProfile(@PathVariable Integer userId) {
        return service.getByUserId(userId);
    }
}