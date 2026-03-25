package com.saikat.influencerapp.service;

import com.saikat.influencerapp.dto.CollaborationRequest;
import com.saikat.influencerapp.dto.CollaborationRequest;
import com.saikat.influencerapp.entity.Collaboration;
import com.saikat.influencerapp.repository.CollaborationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollaborationService {

    @Autowired
    private CollaborationRepository repository;

    public Collaboration sendRequest(CollaborationRequest dto) {

        Collaboration request = new Collaboration();
        request.setCampaignId(dto.getCampaignId());
        request.setInfluencerId(dto.getInfluencerId());
        request.setStatus("PENDING");

        return repository.save(request);
    }

    public List<Collaboration> getRequests(Integer influencerId) {
        return repository.findByInfluencerId(influencerId);
    }

    public Collaboration updateStatus(Integer id, String status) {
        Collaboration req = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        req.setStatus(status);
        return repository.save(req);
    }
}