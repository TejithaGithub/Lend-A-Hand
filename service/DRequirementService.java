package com.lendhand.service;

import java.util.List;

import com.lendhand.model.DRequirement;

public interface DRequirementService {

    DRequirement addDRequirement(DRequirement dRequirement);

    DRequirement updateDRequirement(DRequirement dRequirement);

    List<DRequirement> getAllDRequirement();

    List<DRequirement> getAllDRequirementRelatedToDrive(String id);

    Boolean deleteDRequirementRelatedToDrive(String id);

    DRequirement getDRequirementById(String id);

}
