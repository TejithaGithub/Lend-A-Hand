package com.lendhand.service;

import java.util.List;

import com.lendhand.model.Drive;

public interface DriveService {

    Drive addDrive(Drive drive);

    Drive upadateDrive(Drive drive);

    List<Drive> getAllDrives();

    Drive getDriveById(String id);

    List<Drive> getDrivesByNgo(String id);

}
