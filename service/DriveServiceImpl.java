package com.lendhand.service;

import java.util.ArrayList;
import java.util.List;

import com.lendhand.model.Drive;
import com.lendhand.repository.DriveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    DriveRepository driveRepository;

    @Override
    public Drive addDrive(Drive drive) {
        return driveRepository.save(drive);
    }

    @Override
    public Drive upadateDrive(Drive drive) {
        return driveRepository.save(drive);
    }

    @Override
    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    @Override
    public Drive getDriveById(String id) {
        return driveRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<Drive> getDrivesByNgo(String id) {
        List<Drive> allDrives = getAllDrives();
        List<Drive> drivesByNgo = new ArrayList<Drive>();
        for (Drive d : allDrives) {
            if (d.getNgoId() == Long.parseLong(id)) {
                drivesByNgo.add(d);
            }
        }
        return drivesByNgo;
    }

}
