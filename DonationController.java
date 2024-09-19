package com.lendhand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lendhand.model.DonationsTable;
import com.lendhand.model.DonorInfo;
import com.lendhand.service.DonationService;

@CrossOrigin
@RestController
@RequestMapping("api/v1/donation")
public class DonationController {

    @Autowired
    DonationService donationService;

    // add donation
    @PostMapping("/")
    public DonationsTable addDonations(@RequestBody DonationsTable DonationsTable) {
        return donationService.addDonations(DonationsTable);
    }

    // update donation
    @PutMapping("/")
    public DonationsTable updateDonations(@RequestBody DonationsTable DonationsTable) {
        return donationService.updateDonations(DonationsTable);
    }

    // get all DonationsTable
    @GetMapping("/")
    public List<DonationsTable> getAllDonations() {
        return donationService.getAllDonations();
    }

    // get DonationsTable by id
    @GetMapping("/{id}")
    public DonationsTable getDonationById(@PathVariable String id) {
        return donationService.getDonationById(id);
    }

    // get Donation related to user-id
    @GetMapping("/user/{id}")
    public List<DonationsTable> getDonationByUserId(@PathVariable String id) {
        return donationService.getDonationByUserId(id);
    }

    @GetMapping("/drive/{id}")
    public List<DonorInfo> getDonationsByDriveId(@PathVariable String id) {
        return donationService.getDonationsByDriveId(id);
    }

}
