package org.example.manytomany1;

import org.apache.catalina.User;
import org.example.manytomany1.bean.RoleEz;
import org.example.manytomany1.bean.UserEz;
import org.example.manytomany1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Manytomany1Application implements CommandLineRunner{
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Manytomany1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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
    }
}
