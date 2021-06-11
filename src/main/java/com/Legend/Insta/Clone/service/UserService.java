package com.Legend.Insta.Clone.service;

import com.Legend.Insta.Clone.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO); //Create
    UserDTO findById(int id);
    List<UserDTO> findAll(); //Retrieve
    UserDTO updateUser(UserDTO userDTO); //Update
    void deleteUser(int id); //Delete
}
