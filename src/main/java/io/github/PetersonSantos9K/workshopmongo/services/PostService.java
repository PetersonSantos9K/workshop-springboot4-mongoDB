
package io.github.PetersonSantos9K.workshopmongo.services;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.repositories.PostRepository;
import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository repository;

    public Post findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findAll(){
        return repository.findAll();
    }

    public List<Post> findByTitle(String title){
        return repository.findByTitleContainingIgnoreCase(title);
    }
}
