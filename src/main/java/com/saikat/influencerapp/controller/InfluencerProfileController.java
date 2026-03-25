package com.saikat.influencerapp.controller;

import com.saikat.influencerapp.dto.InfluencerProfileRequest;
import com.saikat.influencerapp.entity.InfluencerProfile;
import com.saikat.influencerapp.service.InfluencerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/influencer")
public class InfluencerProfileController {

    @Autowired
    private InfluencerProfileService service;

    @PostMapping("/profile")
    public InfluencerProfile createOrUpdate(@RequestBody InfluencerProfileRequest request) {
        return service.createOrUpdate(request);
    }

    @GetMapping("/profile/{userId}")
    public InfluencerProfile getProfile(@PathVariable Integer userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/search")
    public List<InfluencerProfile> search(@RequestParam(required = false) String category) {
        return service.search(category);
    }
}