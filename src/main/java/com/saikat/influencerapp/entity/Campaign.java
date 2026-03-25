package com.saikat.influencerapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer brandId;

    private String title;

    private String description;

    private Double budget;

    private String category;
}