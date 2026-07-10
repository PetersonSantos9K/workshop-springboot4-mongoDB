package io.github.PetersonSantos9K.workshopmongo.config;

import io.github.PetersonSantos9K.workshopmongo.domain.Post;
import io.github.PetersonSantos9K.workshopmongo.domain.User;
import io.github.PetersonSantos9K.workshopmongo.dto.AuthorDTO;
import io.github.PetersonSantos9K.workshopmongo.repositories.PostRepository;
import io.github.PetersonSantos9K.workshopmongo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@RequiredArgsConstructor
@Configuration
@Profile(value = "dev")
public class Instantiation implements CommandLineRunner {

    private final UserRepository repository;
    private final PostRepository postRepository;

    @Override
    public void run(String ... args) throws Exception {

        var sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null,"Maria Brown", "maria@gmail.com");
        User alex = new User(null,"Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        repository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
