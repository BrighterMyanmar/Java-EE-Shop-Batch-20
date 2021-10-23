package r.r.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.CategoryDto;
import r.r.models.Category;
import r.r.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/cats")
public class CategoryController {

   @Autowired
   CategoryService categoryService;

   @GetMapping(value = "/")
   public List<Category> all() {
      return categoryService.all();
   }

   @GetMapping("{id}")
   public Category get(@PathVariable("id") int id) {
      return categoryService.get(id);
   }

   @PostMapping
   public Category save(@ModelAttribute CategoryDto categoryDto) {
      return categoryService.save(categoryDto);
   }

   @PutMapping("{id}")
   public Category update(@PathVariable("id") int id, @ModelAttribute CategoryDto categoryDto) {
      return categoryService.put(id, categoryDto);
   }

   @PatchMapping("{id}")
   public Category patchName(@PathVariable("id") int id, @ModelAttribute CategoryDto categoryDto) {
      return categoryService.changeName(id, categoryDto);
   }

   @PatchMapping("profile/{id}") // cats/profile/id
   public Category imageChange(@PathVariable("id") int id, @ModelAttribute CategoryDto categoryDto) {
      return categoryService.changeImage(id, categoryDto);
   }

   @DeleteMapping("{id}")
   public String drop(@PathVariable("id") int id) {
      categoryService.drop(id);
      return "Success";
   }

}
