package com.saikat.influencerapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "influencer_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfluencerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String bio;

    private String instagramLink;

    private Integer followersCount;

    private String category;
}