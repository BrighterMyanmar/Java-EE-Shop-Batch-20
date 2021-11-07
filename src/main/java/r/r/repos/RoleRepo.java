package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
