package com.cursojava.projeto_spring_mongo.config;

import com.cursojava.projeto_spring_mongo.domain.Post;
import com.cursojava.projeto_spring_mongo.domain.User;
import com.cursojava.projeto_spring_mongo.dto.AuthorDTO;
import com.cursojava.projeto_spring_mongo.repository.PostRepository;
import com.cursojava.projeto_spring_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018",fmt), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("23/03/2018",fmt), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
