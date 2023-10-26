package com.example.mywildberries.repository;

import com.example.mywildberries.model.Order;
import com.example.mywildberries.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String username);
    Optional<User> findUserByNameAndPassword(String username,String password);
    boolean existsUserByName(String login);
}
