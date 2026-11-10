package com.cursojava.projeto_spring_mongo.services;

import com.cursojava.projeto_spring_mongo.domain.Post;
import com.cursojava.projeto_spring_mongo.repository.PostRepository;
import com.cursojava.projeto_spring_mongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Post obj = repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Post not found"));
        return obj;
    }

}
