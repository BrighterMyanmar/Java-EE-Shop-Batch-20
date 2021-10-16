package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.CategoryDto;
import r.r.models.Category;

@Service
public interface CategoryService {
   Category save(CategoryDto categoryDto);

   List<Category> all();

   Category get(int id);

   void drop(int id);

   Category put(int id, CategoryDto categoryDto);

   Category changeName(int id, CategoryDto categoryDto);

   Category changeImage(int id, CategoryDto categoryDto);
}
