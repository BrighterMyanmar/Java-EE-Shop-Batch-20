package r.r.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.ChildcatDto;
import r.r.models.Childcat;
import r.r.services.ChildcatService;

@RestController
@RequestMapping("/childcats")
public class ChildcatController {

   @Autowired
   ChildcatService childcatService;

   @PostMapping
   public Childcat save(@ModelAttribute ChildcatDto childcatDto) {
      return childcatService.save(childcatDto);
   }

   @GetMapping
   public List<Childcat> all() {
      return childcatService.all();
   }

   @GetMapping("{id}")
   public Childcat get(@PathVariable("id") int id) {
      return childcatService.get(id);
   }

   @PutMapping("{id}")
   public Childcat update(@PathVariable("id") int id, @ModelAttribute ChildcatDto childcatDto) {
      return childcatService.update(id, childcatDto);
   }

   @PatchMapping("name/{id}")
   public Childcat nameChange(@PathVariable("id") int id, @ModelAttribute ChildcatDto childcatDto) {
      return childcatService.nameChange(id, childcatDto);
   }

   @PatchMapping("image/{id}")
   public Childcat imageChange(@PathVariable("id") int id, @ModelAttribute ChildcatDto childcatDto) {
      return childcatService.imageChange(id, childcatDto);
   }

   @PatchMapping("subcat/{id}")
   public Childcat subcatChange(@PathVariable("id") int id, @ModelAttribute ChildcatDto childcatDto) {
      return childcatService.subcatChange(id, childcatDto);
   }

   @DeleteMapping("{id}")
   public String delete(@PathVariable("id") int id) {
      return childcatService.drop(id);
   }

}
