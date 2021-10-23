package r.r.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.SubcatDto;
import r.r.models.Subcat;
import r.r.services.SubcatService;

@RestController
@RequestMapping("/subcats")
public class SubcatController {

   private SubcatService subcatService;

   private SubcatController(SubcatService subcatService) {
      this.subcatService = subcatService;
   }

   @PostMapping
   public Subcat save(@ModelAttribute SubcatDto subcatDto) {
      System.out.println(subcatDto.getCatId());
      return subcatService.save(subcatDto);
   }

   @GetMapping
   public List<Subcat> get() {
      return subcatService.all();
   }

   @GetMapping("{id}")
   public Subcat singleCat(@PathVariable("id") int id) {
      return subcatService.get(id);
   }

   @PutMapping("{id}")
   public Subcat update(@PathVariable("id") int id, @ModelAttribute SubcatDto subcatDto) {
      return subcatService.update(id, subcatDto);
   }

   @PatchMapping("name/{id}")
   public Subcat nameChnage(@PathVariable("id") int id, @ModelAttribute SubcatDto subcatDto) {
      return subcatService.nameChange(id, subcatDto);
   }

   @PatchMapping("image/{id}")
   public Subcat imageChnage(@PathVariable("id") int id, @ModelAttribute SubcatDto subcatDto) {
      return subcatService.imageChange(id, subcatDto);
   }

   @DeleteMapping("{id}")
   public String drop(@PathVariable("id") int id) {
      return subcatService.drop(id);
   }

}
