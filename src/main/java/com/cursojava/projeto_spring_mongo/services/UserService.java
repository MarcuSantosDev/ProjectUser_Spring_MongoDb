package com.cursojava.projeto_spring_mongo.services;

import com.cursojava.projeto_spring_mongo.domain.User;
import com.cursojava.projeto_spring_mongo.repository.UserRepository;
import com.cursojava.projeto_spring_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id){
        return repository.findById(id).orElseThrow(() ->  new ObjectNotFoundException("User not found"));
    }
}
