package com.saikat.influencerapp.repository;

import com.saikat.influencerapp.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    List<Campaign> findByBrandId(Integer brandId);
}