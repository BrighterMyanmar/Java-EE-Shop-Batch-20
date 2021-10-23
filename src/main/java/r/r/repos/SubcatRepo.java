package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Subcat;

@Repository
public interface SubcatRepo extends JpaRepository<Subcat, Integer> {

}
