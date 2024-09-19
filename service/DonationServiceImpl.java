package com.lendhand.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lendhand.email_service.SendEmailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendhand.model.DonationsTable;
import com.lendhand.model.Drive;
import com.lendhand.model.Users;
import com.lendhand.repository.DonationRepository;
import com.lendhand.model.DonorInfo;
import com.lendhand.repository.UserRepository;

import javax.mail.MessagingException;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Autowired
    DriveService driveService;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<DonationsTable> getAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public DonationsTable addDonations(DonationsTable DonationsTable) {

        DonationsTable donation = donationRepository.save(DonationsTable);

        // once user has donated updating the donor count in respective drive

        int driveId = donation.getDriveId();

        Drive drive = driveService.getDriveById(String.valueOf(driveId));
        drive.setDonorCount(drive.getDonorCount() + 1);
        driveService.upadateDrive(drive);

        String message = "You have successfully donated to " + drive.getDriveName()+"\n"+"Drive details : "+"\n"+" Location : "+drive.getPlace()+"\n"+" Date and Time : "+drive.getCreateDate();
        try {
            // TODO: change mail id
            new SendEmailImpl().sendmail("lendahandgnits@gmail.com", userRepository.findById(donation.getDonorId()).get().getEmailId(), "Thank you...",
                    message);
        } catch (MessagingException | IOException e) {
            System.out.println("Failed to send Email");
            e.printStackTrace();
        }
        return donation;
    }

    @Override
    public DonationsTable updateDonations(DonationsTable DonationsTable) {
        return donationRepository.save(DonationsTable);
    }

    @Override
    public DonationsTable getDonationById(String id) {
        return donationRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public List<DonorInfo> getDonationsByDriveId(String id) {
        List<DonationsTable> donationsList = donationRepository.findByDriveId(Integer.parseInt(id));
        List<Users> usersList = donationsList.stream().map(temp -> userRepository.findById(temp.getDonorId()).get()).collect(Collectors.toList());
        List<DonorInfo> resultList = new ArrayList<>();
        donationsList.forEach(temp -> {
            DonorInfo obj = new DonorInfo();
            obj.setProductName(temp.getProductName());
            obj.setQuantity(temp.getQuantity());
            obj.setDonorName(usersList.stream().filter(user -> user.getId().equals(temp.getDonorId())).findAny().get().getName());
            obj.setDonorPhone(usersList.stream().filter(user -> user.getId().equals(temp.getDonorId())).findAny().get().getPhone());
            obj.setDescription(temp.getDescription());
            resultList.add(obj);
        });
        return resultList;
    }

    @Override
    public List<DonationsTable> getDonationByUserId(String id) {
        List<DonationsTable> allDonations = getAllDonations();
        List<DonationsTable> currentUserDonation = new ArrayList<DonationsTable>();
        for (DonationsTable DonationsTable : allDonations) {
            if (DonationsTable.getDonorId() == Long.parseLong(id)) {
                currentUserDonation.add(DonationsTable);
            }
        }
        return currentUserDonation;
    }

}
