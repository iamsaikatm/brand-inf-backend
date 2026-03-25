package com.saikat.influencerapp.dto;

import lombok.Data;

@Data
public class CampaignRequest {

    private Integer brandId;
    private String title;
    private String description;
    private Double budget;
    private String category;
}