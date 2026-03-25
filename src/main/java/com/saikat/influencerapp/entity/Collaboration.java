package com.saikat.influencerapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "collaboration_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Collaboration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer campaignId;

    private Integer influencerId;

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, ACCEPTED, REJECTED
}