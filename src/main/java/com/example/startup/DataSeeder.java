package com.example.startup;

import com.example.entity.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        /*if(userRepository.count()==0){
            userRepository.saveAll(
                    List.of(
                            new User(null, "Alice", 22),
                            new User(null, "Bob", 16),
                            new User(null, "Charlie", 30),
                            new User(null, "Diana", 18),
                            new User(null, "Eve", 12),
                            new User(null, "Frank", 45),
                            new User(null, "Grace", 27),
                            new User(null, "Hank", 35),
                            new User(null, "Ivy", 19),
                            new User(null, "Jack", 60),
                            new User(null, "Karen", 14),
                            new User(null, "Leo", 21),
                            new User(null, "Mona", 33),
                            new User(null, "Nina", 25),
                            new User(null, "Oscar", 40)
                    )
            );
        }*/
    }
}
