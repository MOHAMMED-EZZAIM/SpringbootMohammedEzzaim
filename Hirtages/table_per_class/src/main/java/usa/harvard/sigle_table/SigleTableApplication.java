package usa.harvard.sigle_table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import usa.harvard.sigle_table.bean.Enseignat;
import usa.harvard.sigle_table.bean.Etudaint;
import usa.harvard.sigle_table.dao.Personnerepository;

@SpringBootApplication
public class SigleTableApplication implements CommandLineRunner {
    @Autowired
    private Personnerepository personnerepository;
    public static void main(String[] args) {
        SpringApplication.run(SigleTableApplication.class, args);

    }
    @Override
    public void run(String... args) throws Exception {
        Etudaint etudaint=new Etudaint();
        etudaint.setNom("mohammed");
        etudaint.setDateNaissance("18/6/2003");
        etudaint.setId(1L);
        etudaint.setNote(20);
        personnerepository.save(etudaint);

        Enseignat enseignat=new Enseignat();
        enseignat.setNom("mohammed rpof");
        enseignat.setDateNaissance("18/6/2003");
        enseignat.setMatier("Programmation java");
        enseignat.setId(2L);

        personnerepository.save(enseignat);

    }
}
