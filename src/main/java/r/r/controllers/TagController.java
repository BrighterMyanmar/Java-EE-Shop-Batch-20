package r.r.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.TagDto;
import r.r.models.Tag;
import r.r.services.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

   private TagService tagService;

   public TagController(TagService tagService) {
      this.tagService = tagService;
   }

   @PostMapping
   public ResponseEntity<Tag> save(@Valid @ModelAttribute TagDto tagDto, BindingResult result) {
      if (result.hasErrors()) {
         try {
            throw new Exception("Model Validation Error");
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else {
         System.out.println("Aung Tal");
         return ResponseEntity.ok(tagService.save(tagDto));
      }
      return ResponseEntity.ok(tagService.save(tagDto));
   }

   @GetMapping
   public ResponseEntity<List<Tag>> all() {
      return ResponseEntity.ok(tagService.all());
   }

   @GetMapping("{id}")
   public ResponseEntity<Tag> get(@PathVariable("id") int id) {
      return ResponseEntity.ok(tagService.get(id));
   }

   @PatchMapping("{id}")
   public ResponseEntity<Tag> update(@PathVariable("id") int id, @ModelAttribute TagDto tagDto) {
      return ResponseEntity.ok(tagService.update(id, tagDto));
   }

   @DeleteMapping("{id}")
   public ResponseEntity<String> drop(@PathVariable("id") int id) {
      return ResponseEntity.ok(tagService.drop(id));
   }

}
