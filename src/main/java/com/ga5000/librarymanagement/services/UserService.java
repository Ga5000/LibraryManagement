package com.ga5000.librarymanagement.services;

import com.ga5000.librarymanagement.model.User;
import com.ga5000.librarymanagement.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){ userRepository.save(user);}

    public void deleteUser(UUID id){ userRepository.deleteById(id);}

}
