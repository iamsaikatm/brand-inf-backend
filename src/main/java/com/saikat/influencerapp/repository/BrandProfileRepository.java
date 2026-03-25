package com.saikat.influencerapp.repository;

import com.saikat.influencerapp.entity.BrandProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandProfileRepository extends JpaRepository<BrandProfile, Integer> {

    Optional<BrandProfile> findByUserId(Integer userId);
}