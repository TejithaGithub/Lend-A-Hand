package com.lendhand.service;

import java.util.ArrayList;
import java.util.List;

import com.lendhand.model.DRequirement;
import com.lendhand.repository.DRequirementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DRequirementImpl implements DRequirementService {

    @Autowired
    DRequirementRepository dRequirementRepository;

    @Override
    public DRequirement addDRequirement(DRequirement dRequirement) {
        return dRequirementRepository.save(dRequirement);
    }

    @Override
    public DRequirement updateDRequirement(DRequirement dRequirement) {
        return dRequirementRepository.save(dRequirement);
    }

    @Override
    public List<DRequirement> getAllDRequirement() {
        return dRequirementRepository.findAll();
    }

    @Override
    public DRequirement getDRequirementById(String id) {
        return dRequirementRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<DRequirement> getAllDRequirementRelatedToDrive(String id) {
        List<DRequirement> allDRequirements = getAllDRequirement();
        List<DRequirement> resultDriveRequirements = new ArrayList<DRequirement>();
        for (DRequirement d : allDRequirements) {
            if (d.getDriveId() == Long.parseLong(id)) {
                resultDriveRequirements.add(d);
            }
        }
        return resultDriveRequirements;
    }

    @Override
    public Boolean deleteDRequirementRelatedToDrive(String id) {
        try {
            dRequirementRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
