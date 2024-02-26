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
        userService.addNewUserWithHash(u1);

        UserEz u2=new UserEz();
        u2.setUsername("admin");
        u2.setPassword("123456");
        userService.addNewUserWithHash(u2);

        Stream.of("STUDENT","USRE","ADMINE").forEach(r->{
            RoleEz r1=new RoleEz();
            r1.setRolename(r);
            userService.addNewRole(r1);
        });

        userService.addRoleToUser("user1","STUDENT");
        userService.addRoleToUser("admin","ADMINE");
        userService.addRoleToUser("admin","USRE");

        try {
            UserEz againConsulter=userService.authenticateWithHash("admin","123456");
//            System.out.println(againConsulter.getUserId());
//            System.out.println(againConsulter.getUsername());
            againConsulter.getRoleEzs().forEach(r->{
                System.out.println("Role=>"+r.toString());
            });
        }catch(Exception e){
            System.out.println("user ou  motpasse incorete!!");
            System.out.println(e.getMessage());
        }



//
//        UserEz u3=new UserEz();
//        u1.setUsername("user3");
//        u1.setPassword("123456");
//        userService.addNewUsersansash(u3);
//
//        UserEz u4=new UserEz();
//        u2.setUsername("admin4");
//        u2.setPassword("123456");
//        userService.addNewUsersansash(u4);
//
//        Stream.of("STUDENT","USRE","ADMINE").forEach(r->{
//            RoleEz r1=new RoleEz();
//            r1.setRolename(r);
//            userService.addNewRole(r1);
//        });
//
//        userService.addRoleToUser("user3","STUDENT");
//        userService.addRoleToUser("admin4","ADMINE");
//        userService.addRoleToUser("admin4","USRE");
    }
}
