package r.r.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.ProductDto;
import r.r.models.Product;
import r.r.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/products")
public class ProductController {

   private ProductService service;

   public ProductController(ProductService service) {
      this.service = service;
   }

   @PostMapping
   public ResponseEntity<String> save(@ModelAttribute ProductDto productDto) {
      return ResponseEntity.ok(service.save(productDto));
   }

   @GetMapping
   public ResponseEntity<List<Product>> all() {
      return ResponseEntity.ok(service.all());
   }

   @GetMapping("{id}")
   public ResponseEntity<Product> get(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.get(id));
   }

   @PutMapping("{id}")
   public ResponseEntity<String> update(@PathVariable("id") int id, @ModelAttribute ProductDto productDto) {
      return ResponseEntity.ok(service.update(id, productDto));
   }

   @DeleteMapping("{id}")
   public ResponseEntity<String> drop(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.drop(id));
   }

   @GetMapping("cat/{id}")
   public ResponseEntity<List<Product>> catProducts(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.byCatId(id));
   }

   @GetMapping("sub/{id}")
   public ResponseEntity<List<Product>> subcatProducts(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.bySubcatId(id));
   }

   @GetMapping("child/{id}")
   public ResponseEntity<List<Product>> childcatProducts(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.byChildcatId(id));
   }

   @GetMapping("tag/{id}")
   public ResponseEntity<List<Product>> tagProducts(@PathVariable("id") int id) {
      return ResponseEntity.ok(service.byTagId(id));
   }

}
