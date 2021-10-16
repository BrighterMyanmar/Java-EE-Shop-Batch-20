package r.r.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.CategoryDto;
import r.r.models.Category;
import r.r.repos.CategoryRepo;
import r.r.services.CategoryService;
import r.r.services.ImageUploadService;

@Service
public class CategoryImpl implements CategoryService {

   private ImageUploadService imageUploadService;
   private CategoryRepo categoryRepo;

   public CategoryImpl(ImageUploadService imageUploadService, CategoryRepo categoryRepo) {
      this.imageUploadService = imageUploadService;
      this.categoryRepo = categoryRepo;
   }

   @Override
   public Category save(CategoryDto categoryDto) {
      Category category = new Category();
      category.setName(categoryDto.getName());
      category.setImage(imageUploadService.saveFile(categoryDto.getFile()));
      return categoryRepo.save(category);
   }

   @Override
   public List<Category> all() {
      return categoryRepo.findAll();
   }

   @Override
   public Category get(int id) {
      return categoryRepo.findById(id).orElse(null);
   }

   @Override
   public void drop(int id) {
      Category category = categoryRepo.findById(id).orElse(null);
      categoryRepo.delete(category);
   }

   @Override
   public Category put(int id, CategoryDto categoryDto) {
      Category category = categoryRepo.findById(id).orElse(null);
      category.setName(categoryDto.getName());
      category.setImage(imageUploadService.saveFile(categoryDto.getFile()));
      return categoryRepo.save(category);
   }

   @Override
   public Category changeName(int id, CategoryDto categoryDto) {
      Category category = categoryRepo.findById(id).orElse(null);
      category.setName(categoryDto.getName());
      return categoryRepo.save(category);
   }

   @Override
   public Category changeImage(int id, CategoryDto categoryDto) {
      Category category = categoryRepo.findById(id).orElse(null);
      category.setImage(imageUploadService.saveFile(categoryDto.getFile()));
      return categoryRepo.save(category);
   }

}
