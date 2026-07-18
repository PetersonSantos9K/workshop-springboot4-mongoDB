package io.github.PetersonSantos9K.workshopmongo.controllers;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findById(){

        return ResponseEntity.ok().body(postService.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){

        return ResponseEntity.ok().body(postService.findById(id));
    }

}
