package com.lendhand.service;

import java.util.ArrayList;
import java.util.List;

import com.lendhand.model.Users;
import com.lendhand.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String id) {
        return userRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllNgos() {
        List<Users> allUsers = getAllUsers();
        List<Users> allNgos = new ArrayList<Users>();
        for (Users u : allUsers) {
            if (u.getRole().equals("ngo")) {
                allNgos.add(u);
            }
        }
        return allNgos;
    }

    @Override
    public Users getNgoById(String id) {
        List<Users> allNgos = getAllNgos();
        Users resultNgo = null;
        for (Users u : allNgos) {
            if (u.getId() == Long.parseLong(id)) {
                resultNgo = u;
            }
        }

        return resultNgo;
    }

    @Override
    public List<Users> getAllPendingNgos() {

        List<Users> allNgos = getAllNgos();
        List<Users> pendingNgos = new ArrayList<Users>();
        for (Users u : allNgos) {
            if (u.getStatus() == 0) {
                pendingNgos.add(u);
            }
        }
        return pendingNgos;
    }

    @Override
    public List<Users> getAllAccpetedNgos() {
        List<Users> allNgos = getAllNgos();
        List<Users> accpetedNgos = new ArrayList<Users>();
        for (Users u : allNgos) {
            if (u.getStatus() == 1) {
                accpetedNgos.add(u);
            }
        }
        return accpetedNgos;
    }

    @Override
    public List<Users> getAllRejectedNgos() {
        List<Users> allNgos = getAllNgos();
        List<Users> rejectedNgos = new ArrayList<Users>();
        for (Users u : allNgos) {
            if (u.getStatus() == 2) {
                rejectedNgos.add(u);
            }
        }
        return rejectedNgos;
    }

    @Override
    public Users acceptNgos(String id) {
        Users ngo = getNgoById(id);
        if (ngo != null) {
            ngo.setStatus(1);
            userRepository.save(ngo);
        }
        return ngo;
    }

    @Override
    public Users rejectNgos(String id) {
        Users ngo = getNgoById(id);
        if (ngo != null) {
            ngo.setStatus(2);
            userRepository.save(ngo);
        }
        return ngo;
    }

    @Override
    public Users adminLogin(String email) {
        List<Users> allUsers = getAllUsers();
        for (Users u : allUsers) {
            if (u.getRole().equals("admin") && u.getEmailId().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Users donorLogin(String email) {
        List<Users> allUsers = getAllUsers();
        for (Users u : allUsers) {
            if (u.getRole().equals("donor") && u.getEmailId().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Users ngoLogin(String email) {
        List<Users> allUsers = getAllUsers();
        for (Users u : allUsers) {
            if (u.getRole().equals("ngo") && u.getEmailId().equals(email)) {
                return u;
            }
        }
        return null;
    }

}
