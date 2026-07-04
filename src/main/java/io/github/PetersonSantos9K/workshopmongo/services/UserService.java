package io.github.PetersonSantos9K.workshopmongo.services;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import io.github.PetersonSantos9K.workshopmongo.dto.UserDTO;
import io.github.PetersonSantos9K.workshopmongo.repositories.UserRepository;
import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repo;

    public List<UserDTO> findAll(){
        List<User> list = repo.findAll();
        return list.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id){
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return new UserDTO(user);
    }



}
