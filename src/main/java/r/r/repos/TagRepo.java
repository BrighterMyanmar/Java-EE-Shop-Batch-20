package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Tag;

@Repository
public interface TagRepo extends JpaRepository<Tag, Integer> {

}
