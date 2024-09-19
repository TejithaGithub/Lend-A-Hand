package com.lendhand.repository;

import com.lendhand.model.DRequirement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DRequirementRepository extends JpaRepository<DRequirement, Long> {

}
