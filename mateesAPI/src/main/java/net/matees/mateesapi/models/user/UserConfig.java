package net.matees.mateesapi.models.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepo repo){
        return args ->{
            User banan = new User("banan",
                    11,
                    "banantajam@gmail.com");

            repo.saveAll(List.of(banan));
        };
    }
}
