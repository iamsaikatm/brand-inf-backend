package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.BrandProfileRequest;
import com.saikat.influencerapp.entity.BrandProfile;
import com.saikat.influencerapp.repository.BrandProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandProfileService {

    @Autowired
    private BrandProfileRepository repository;

    public BrandProfile createOrUpdate(BrandProfileRequest request) {

        BrandProfile profile = repository
                .findByUserId(request.getUserId())
                .orElse(new BrandProfile());

        profile.setUserId(request.getUserId());
        profile.setCompanyName(request.getCompanyName());

        return repository.save(profile);
    }

    public BrandProfile getByUserId(Integer userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Brand profile not found"));
    }
}