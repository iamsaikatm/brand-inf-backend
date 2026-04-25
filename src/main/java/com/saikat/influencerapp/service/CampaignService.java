package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.CampaignRequest;
import com.saikat.influencerapp.entity.Campaign;
import com.saikat.influencerapp.entity.User;
import com.saikat.influencerapp.repository.CampaignRepository;
import com.saikat.influencerapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Campaign create(CampaignRequest request, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Campaign campaign = new Campaign();
        campaign.setBrandId(user.getId()); // ✅ from token
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