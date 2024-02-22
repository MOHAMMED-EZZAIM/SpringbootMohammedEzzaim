package org.example.manytomany;

import org.example.manytomany.bean.RoleEz;
import org.example.manytomany.bean.UserEz;
import org.example.manytomany.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }
    // chaque methodes @Bean executre ou demarages
    @Bean
    CommandLineRunner start(UserService userService){
        return args -> {
            UserEz u1=new UserEz();
            u1.setUsername("user1");
            u1.setPassword("123456");
            userService.addNewUser(u1);

            UserEz u2=new UserEz();
            u2.setUsername("admin");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT","USRE","ADMINE").forEach(r->{
                RoleEz r1=new RoleEz();
                r1.setRolename(r);
                userService.addNewRole(r1);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("admin","ADMINE");
            userService.addRoleToUser("admin","USRE");

        };
    }

}
