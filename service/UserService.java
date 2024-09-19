package com.lendhand.service;

import java.util.List;

import com.lendhand.model.Users;

public interface UserService {

    Users addUser(Users user);

    List<Users> getAllUsers();

    Users getUser(String id);

    Users updateUser(Users user);

    List<Users> getAllNgos();

    Users getNgoById(String id);

    List<Users> getAllPendingNgos();

    List<Users> getAllAccpetedNgos();

    List<Users> getAllRejectedNgos();

    Users acceptNgos(String id);

    Users rejectNgos(String id);

    Users adminLogin(String email);

    Users donorLogin(String email);

    Users ngoLogin(String email);

}
