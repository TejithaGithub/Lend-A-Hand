package com.lendhand.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import com.lendhand.email_service.SendEmailImpl;
import com.lendhand.model.Users;
import com.lendhand.service.UserService;

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
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    // add user
    @PostMapping("/add-user")
    public Users addUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    // get list of users
    @GetMapping("/")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    // admin login
    @GetMapping("/login/admin/{email}")
    public Users adminLogin(@PathVariable String email) {
        return userService.adminLogin(email);
    }

    // ngo login
    @GetMapping("/login/ngo/{email}")
    public Users ngoLogin(@PathVariable String email) {
        return userService.ngoLogin(email);
    }

    // donor login
    @GetMapping("/login/donor/{email}")
    public Users donorLogin(@PathVariable String email) {
        return userService.donorLogin(email);
    }

    // get user by id
    @GetMapping("/{id}")
    public Users getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    // update user by id
    @PutMapping("/")
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }

    // NGO

    // get all NGOs
    @GetMapping("/ngo")
    public List<Users> getAllNgos() {
        return userService.getAllNgos();
    }

    @GetMapping("/ngo/{id}")
    public Users getNgoById(@PathVariable String id) {
        return userService.getNgoById(id);
    }

    // get pending Ngos
    @GetMapping("/ngo/pending")
    public List<Users> getAllPendingNgos() {
        return userService.getAllPendingNgos();
    }

    // get accepted Ngos
    @GetMapping("/ngo/accepted")
    public List<Users> getAllAcceptedNgos() {
        return userService.getAllAccpetedNgos();
    }

    // get rejected Ngos
    @GetMapping("/ngo/rejected")
    public List<Users> getAllRejectedNgos() {
        return userService.getAllRejectedNgos();
    }

    // accept Ngo
    @PutMapping("/ngo/accept/{id}")
    public Users acceptNgos(@PathVariable String id) {
        Users resultUser = userService.acceptNgos(id);
        String message = "Congratulation your " + resultUser.getName() + " Ngo request is accepted...";
        try {
            // TODO: change mail id
            new SendEmailImpl().sendmail("lendahandgnits@gmail.com", resultUser.getEmailId(), "Congratulations...",
                    message);
        } catch (MessagingException | IOException e) {
            System.out.println("Failed to send Email");
            e.printStackTrace();
        }

        return resultUser;
    }

    // reject Ngo
    @PutMapping("/ngo/reject/{id}")
    public Users rejectNgos(@PathVariable String id) {

        Users resultUser = userService.rejectNgos(id);
        String message = "Ohho your " + resultUser.getName() + " Ngo request is Declined...";
        try {
            // change mail id
            new SendEmailImpl().sendmail("lendahandgnits@gmail.com", resultUser.getEmailId(), "Request denied",
                    message);
        } catch (MessagingException | IOException e) {
            System.out.println("Failed to send Email");
            e.printStackTrace();
        }

        return resultUser;
    }

    // get Ngo count
    @GetMapping("/ngo/count")
    public int getNgoCount() {
        return getAllNgos().size();
    }

}
