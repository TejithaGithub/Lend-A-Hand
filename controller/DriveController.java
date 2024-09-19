package com.lendhand.controller;

import java.util.List;

import com.lendhand.model.Drive;
import com.lendhand.service.DriveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/drive")
public class DriveController {

    @Autowired
    DriveService driveService;

    // add-drive
    @PostMapping("/")
    public Drive addDrive(@RequestBody Drive drive) {
        return driveService.addDrive(drive);
    }

    // update drive-detils
    @PutMapping("/")
    public Drive updateDrive(@RequestBody Drive drive) {
        return driveService.upadateDrive(drive);
    }

    // get all-drives
    @GetMapping("/")
    public List<Drive> getAllDrives() {
        return driveService.getAllDrives();
    }

    // get drive by Id
    @GetMapping("/{id}")
    public Drive getDriveById(@PathVariable String id) {
        return driveService.getDriveById(id);
    }

    // get all drives related to respective ngo

    @GetMapping("/ngo/{id}")
    public List<Drive> getDrivesByNgo(@PathVariable String id) {
        return driveService.getDrivesByNgo(id);
    }

    // TODO: update donor count
    // @PostMapping("/update-donorcount")
    // public Drive updateDonorCount(@)
}
