package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.InfluencerProfileRequest;
import com.saikat.influencerapp.entity.InfluencerProfile;
import com.saikat.influencerapp.repository.InfluencerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluencerProfileService {

    @Autowired
    private InfluencerProfileRepository repository;

    public InfluencerProfile createOrUpdate(InfluencerProfileRequest request){

        InfluencerProfile profile = repository.findByUserId(request.getUserId()).orElse(new InfluencerProfile());

        profile.setUserId(request.getUserId());
        profile.setBio(request.getBio());
        profile.setInstagramLink(request.getInstagramLink());
        profile.setFollowersCount(request.getFollowersCount());
        profile.setCategory(request.getCategory());

        return repository.save(profile);
    }

    public InfluencerProfile getByUserId(Integer userId) {
        return repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public List<InfluencerProfile> search(String category) {
        if (category == null || category.isEmpty()) {
            return repository.findAll();
        }
        return repository.findByCategory(category);
    }
}
