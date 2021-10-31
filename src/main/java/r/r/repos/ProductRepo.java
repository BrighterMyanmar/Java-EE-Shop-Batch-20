package r.r.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
   public List<Product> findByCategoryId(int id);

   public List<Product> findByChildcatId(int id);

   public List<Product> findBySubcatId(int id);

   public List<Product> findBytagId(int id);
}
