package com.example.startup;

import com.example.entity.Person;
import com.example.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        if(personRepository.count()==0){
            personRepository.saveAll(
                    List.of(
                            new Person(null, "Alice", 22),
                            new Person(null, "Bob", 16),
                            new Person(null, "Charlie", 30),
                            new Person(null, "Diana", 18),
                            new Person(null, "Eve", 12),
                            new Person(null, "Frank", 45),
                            new Person(null, "Grace", 27),
                            new Person(null, "Hank", 35),
                            new Person(null, "Ivy", 19),
                            new Person(null, "Jack", 60),
                            new Person(null, "Karen", 14),
                            new Person(null, "Leo", 21),
                            new Person(null, "Mona", 33),
                            new Person(null, "Nina", 25),
                            new Person(null, "Oscar", 40)
                    )
            );
        }
    }
}
