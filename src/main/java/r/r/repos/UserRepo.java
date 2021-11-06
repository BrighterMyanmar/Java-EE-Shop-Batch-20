package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
   public User findByName(String name);
}
