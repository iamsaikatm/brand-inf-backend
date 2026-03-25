package com.saikat.influencerapp.repository;

import com.saikat.influencerapp.entity.Collaboration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollaborationRepository extends JpaRepository<Collaboration, Integer> {

    List<Collaboration> findByInfluencerId(Integer influencerId);
}