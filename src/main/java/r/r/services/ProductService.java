package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.ProductDto;
import r.r.models.Product;

@Service
public interface ProductService {
   String save(ProductDto productDto);

   Product get(int id);

   List<Product> all();

   String update(int id, ProductDto productDto);

   String drop(int id);

   List<Product> byCatId(int id);

   List<Product> bySubcatId(int id);

   List<Product> byChildcatId(int id);

   List<Product> byTagId(int id);

}
