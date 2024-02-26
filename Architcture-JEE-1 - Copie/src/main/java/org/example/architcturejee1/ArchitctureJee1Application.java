package org.example.architcturejee1;

import org.example.architcturejee1.bean.Patinet;
import org.example.architcturejee1.dao.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ArchitctureJee1Application {
    public static void main(String[] args) {
        SpringApplication.run(ArchitctureJee1Application.class, args);

    }

    @Bean
     CommandLineRunner commandLineRunner(PatientDao patientDao){
        return args -> {
            patientDao.save(
                    new Patinet(null,"mohammed",new Date(),false,20000)
            );
            patientDao.save(
                    new Patinet(null,"hassane",new Date(),true,332)
            );
            patientDao.save(
                    new Patinet(null,"ismail",new Date(),false,13000)
            );
            patientDao.save(
                    new Patinet(null,"abd2ilahh",new Date(),false,13000)
            );
            patientDao.findAll().forEach(p->{
                System.out.println("----------------------------------");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getDateNassance());
                System.out.println(p.getNom()+" est malade:"+p.isMalade());
                System.out.println(p.getScore());
            });
        };
    }
}
