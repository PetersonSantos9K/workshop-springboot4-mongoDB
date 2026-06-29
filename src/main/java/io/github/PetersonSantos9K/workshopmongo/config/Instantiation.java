package io.github.PetersonSantos9K.workshopmongo.config;

import io.github.PetersonSantos9K.workshopmongo.domain.User;
import io.github.PetersonSantos9K.workshopmongo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@RequiredArgsConstructor
@Configuration
@Profile(value = "dev")
public class Instantiation implements CommandLineRunner {

    private final UserRepository repository;


    @Override
    public void run(String ... args) throws Exception {

        repository.deleteAll();

        User maria = new User(null,"Maria Brown", "maria@gmail.com");
        User alex = new User(null,"Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repository.saveAll(Arrays.asList(maria, alex, bob));

    }
}
