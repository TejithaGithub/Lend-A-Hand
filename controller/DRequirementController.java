package com.lendhand.controller;

import java.util.List;

import com.lendhand.model.DRequirement;
import com.lendhand.service.DRequirementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/require")
public class DRequirementController {

    @Autowired
    DRequirementService dRequirementService;

    // add drive requirement
    @PostMapping("/")
    public DRequirement addDRequirement(@RequestBody DRequirement dRequirement) {
        return dRequirementService.addDRequirement(dRequirement);
    }

    // update drive requirement
    @PutMapping("/")
    public DRequirement updateDRequirement(@RequestBody DRequirement dRequirement) {
        return dRequirementService.updateDRequirement(dRequirement);
    }

    // get all requirements
    @GetMapping("/")
    public List<DRequirement> getAllDRequirement() {
        return dRequirementService.getAllDRequirement();
    }

    // get all requirements
    @GetMapping("/{id}")
    public DRequirement getDRequirementById(@PathVariable String id) {
        return dRequirementService.getDRequirementById(id);
    }

    // get all requirement related to drive
    @GetMapping("/drive/{id}")
    public List<DRequirement> getAllDRequirementRelatedToDrive(@PathVariable String id) {
        return dRequirementService.getAllDRequirementRelatedToDrive(id);
    }

    // delete requirement
    @DeleteMapping("/{id}")
    public Boolean deleteDRequirementRelatedToDrive(@PathVariable String id) {
        return dRequirementService.deleteDRequirementRelatedToDrive(id);
    }

}
