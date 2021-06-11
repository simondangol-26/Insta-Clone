package com.Legend.Insta.Clone.service.impl;

import com.Legend.Insta.Clone.dto.UserDTO;
import com.Legend.Insta.Clone.model.User;
import com.Legend.Insta.Clone.repository.UserRepository;
import com.Legend.Insta.Clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO); //copy user dto to user
        User savedUser = userRepository.save(user); //save to database
        UserDTO savedUserDTO = new UserDTO(savedUser);  //copy user to user dto
        return savedUserDTO;
    }

    @Override
    public UserDTO findById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new RuntimeException("User with given id not found"));
        UserDTO userDTO = new UserDTO(user);
        return userDTO;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : users){
            UserDTO userDTO = new UserDTO(user);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }
}
