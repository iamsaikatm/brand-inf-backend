package com.saikat.influencerapp.dto;

import lombok.Data;

@Data
public class InfluencerProfileRequest {

    private Integer userId;
    private String bio;
    private String instagramLink;
    private Integer followersCount;
    private String category;
}