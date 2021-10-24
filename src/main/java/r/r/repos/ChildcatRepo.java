package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Childcat;

@Repository
public interface ChildcatRepo extends JpaRepository<Childcat, Integer> {

}
