package io.github.PetersonSantos9K.workshopmongo.controllers;

import io.github.PetersonSantos9K.workshopmongo.dto.UserDTO;
import io.github.PetersonSantos9K.workshopmongo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
