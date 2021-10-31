package r.r.impls;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.expression.spel.ast.OpPlus;
import org.springframework.stereotype.Service;

import r.r.dtos.ProductDto;
import r.r.models.Product;
import r.r.repos.CategoryRepo;
import r.r.repos.ChildcatRepo;
import r.r.repos.ProductRepo;
import r.r.repos.SubcatRepo;
import r.r.repos.TagRepo;
import r.r.services.ImageUploadService;
import r.r.services.ProductService;

@Service
public class ProductImpl implements ProductService {

   private ImageUploadService imageUploadService;
   private ProductRepo productRepo;
   private CategoryRepo categoryRepo;
   private SubcatRepo subcatRepo;
   private ChildcatRepo childcatRepo;
   private TagRepo tagRepo;

   private ProductImpl(ImageUploadService imageUploadService, ProductRepo productRepo, CategoryRepo categoryRepo,
         SubcatRepo subcatRepo, ChildcatRepo childcatRepo, TagRepo tagRepo) {
      this.imageUploadService = imageUploadService;
      this.productRepo = productRepo;
      this.categoryRepo = categoryRepo;
      this.subcatRepo = subcatRepo;
      this.childcatRepo = childcatRepo;
      this.tagRepo = tagRepo;
   }

   @Override
   public String save(ProductDto productDto) {
      Product product = new Product();
      product.setName(productDto.getName());
      product.setBrand(productDto.getBrand());
      product.setPrice(productDto.getPrice());
      product.setImages(imageUploadService.saveFiles(productDto.getFiles()));
      product.setCategory(categoryRepo.findById(productDto.getCatId()).orElse(null));
      product.setSubcat(subcatRepo.findById(productDto.getSubcatId()).orElse(null));
      product.setChildcat(childcatRepo.findById(productDto.getChildcatId()).orElse(null));
      product.setTag(tagRepo.findById(productDto.getTagId()).orElse(null));
      productRepo.save(product);
      return "Success";
   }

   @Override
   public Product get(int id) {
      Optional<Product> opProduct = productRepo.findById(id);
      if (opProduct.isPresent()) {
         return opProduct.get();
      } else
         throw new EntityNotFoundException("No Product with that id of " + id);
   }

   @Override
   public List<Product> all() {
      return productRepo.findAll();
   }

   @Override
   public String update(int id, ProductDto productDto) {
      Optional<Product> opProduct = productRepo.findById(id);
      if (opProduct.isPresent()) {
         Product product = opProduct.get();
         product.setName(productDto.getName());
         product.setBrand(productDto.getBrand());
         product.setPrice(productDto.getPrice());
         product.setImages(imageUploadService.saveFiles(productDto.getFiles()));
         product.setCategory(categoryRepo.findById(productDto.getCatId()).orElse(null));
         product.setSubcat(subcatRepo.findById(productDto.getSubcatId()).orElse(null));
         product.setChildcat(childcatRepo.findById(productDto.getChildcatId()).orElse(null));
         product.setTag(tagRepo.findById(productDto.getTagId()).orElse(null));
         productRepo.save(product);
         return "Success";
      } else
         throw new EntityNotFoundException("No Product with that id of " + id);
   }

   @Override
   public String drop(int id) {
      Optional<Product> opProduct = productRepo.findById(id);
      if (opProduct.isPresent()) {
         productRepo.delete(opProduct.get());
         return "Product Deleted";
      } else
         throw new EntityNotFoundException("No Product with that id of " + id);
   }

   @Override
   public List<Product> byCatId(int id) {
      return productRepo.findByCategoryId(id);
   }

   @Override
   public List<Product> bySubcatId(int id) {
      return productRepo.findBySubcatId(id);
   }

   @Override
   public List<Product> byChildcatId(int id) {
      return productRepo.findByChildcatId(id);
   }

   @Override
   public List<Product> byTagId(int id) {
      return productRepo.findBytagId(id);
   }

}
