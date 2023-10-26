package com.example.mywildberries.service;

import com.example.mywildberries.model.User;
import com.example.mywildberries.repository.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository clientRepository) {
        this.userRepository = clientRepository;
    }

    public List<User> getListOfClients() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.getReferenceById(id);
    }

    public User findByNameAndPassword(String name,String password) {
        //TODO add custom exception
        return userRepository.findUserByNameAndPassword(name,password).orElseThrow(() -> new RuntimeException() );
    }
    public User findByName(String name) {
        //TODO add custom exception
        return userRepository.findUserByName(name).orElseThrow(() -> new RuntimeException() );
    }

    @Transactional
    public void save(User client) {
        userRepository.save(client);
    }

    @Transactional
    public void delete(int id) {
        userRepository.delete(findById(id));
    }

}