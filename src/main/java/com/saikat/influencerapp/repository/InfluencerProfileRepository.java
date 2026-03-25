package com.saikat.influencerapp.repository;

import com.saikat.influencerapp.entity.InfluencerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InfluencerProfileRepository extends JpaRepository<InfluencerProfile, Integer> {
    Optional<InfluencerProfile> findByUserId(Integer userId);
    List<InfluencerProfile> findByCategory(String category);
}