package com.cursojava.projeto_spring_mongo.resources;

import com.cursojava.projeto_spring_mongo.domain.Post;
import com.cursojava.projeto_spring_mongo.resources.util.URL;
import com.cursojava.projeto_spring_mongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET,value = "titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
