package com.saikat.influencerapp.controller;

import com.saikat.influencerapp.dto.CampaignRequest;
import com.saikat.influencerapp.entity.Campaign;
import com.saikat.influencerapp.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService service;

    @PostMapping
    public Campaign create(@RequestBody CampaignRequest request) {
        return service.create(request);
    }

    @GetMapping("/{brandId}")
    public List<Campaign> getCampaigns(@PathVariable Integer brandId) {
        return service.getByBrand(brandId);
    }
}