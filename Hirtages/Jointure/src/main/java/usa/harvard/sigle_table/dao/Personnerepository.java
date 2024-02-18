package usa.harvard.sigle_table.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import usa.harvard.sigle_table.bean.Personne;

public interface Personnerepository extends JpaRepository<Personne,Long> {
}
