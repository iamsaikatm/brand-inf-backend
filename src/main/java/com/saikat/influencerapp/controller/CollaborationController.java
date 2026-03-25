package com.saikat.influencerapp.controller;

import com.saikat.influencerapp.dto.CollaborationRequest;
import com.saikat.influencerapp.entity.Collaboration;
import com.saikat.influencerapp.service.CollaborationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborations")
public class CollaborationController {

    @Autowired
    private CollaborationService service;

    @PostMapping
    public Collaboration send(@RequestBody CollaborationRequest request) {
        return service.sendRequest(request);
    }

    @GetMapping("/influencer/{id}")
    public List<Collaboration> getRequests(@PathVariable Integer id) {
        return service.getRequests(id);
    }

    @PutMapping("/{id}")
    public Collaboration updateStatus(
            @PathVariable Integer id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status);
    }
}