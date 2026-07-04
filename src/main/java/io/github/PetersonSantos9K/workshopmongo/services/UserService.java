package io.github.PetersonSantos9K.workshopmongo.services;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import io.github.PetersonSantos9K.workshopmongo.dto.request.UserRequestDTO;
import io.github.PetersonSantos9K.workshopmongo.dto.response.UserResponseDTO;
import io.github.PetersonSantos9K.workshopmongo.repositories.UserRepository;
import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repo;

    public List<UserResponseDTO> findAll(){
        List<User> list = repo.findAll();
        return list.stream().map(UserResponseDTO::new).toList();
    }

    public UserResponseDTO findById(String id){
        User user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return new UserResponseDTO(user);
    }

    public UserResponseDTO insert(UserRequestDTO user){
        return new UserResponseDTO(repo.save(fromDTO(user)));
    }


    public User fromDTO (UserRequestDTO objDTO){
        return new User(null, objDTO.getName(), objDTO.getEmail());
    }


}
