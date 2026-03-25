package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.CampaignRequest;
import com.saikat.influencerapp.entity.Campaign;
import com.saikat.influencerapp.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository repository;

    public Campaign create(CampaignRequest request) {

        Campaign campaign = new Campaign();
        campaign.setBrandId(request.getBrandId());
        campaign.setTitle(request.getTitle());
        campaign.setDescription(request.getDescription());
        campaign.setBudget(request.getBudget());
        campaign.setCategory(request.getCategory());

        return repository.save(campaign);
    }

    public List<Campaign> getByBrand(Integer brandId) {
        return repository.findByBrandId(brandId);
    }
}