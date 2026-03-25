package com.saikat.influencerapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "brand_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private String companyName;
}