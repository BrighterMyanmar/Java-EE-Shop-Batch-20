package r.r.impls;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import r.r.dtos.SubcatDto;
import r.r.models.Category;
import r.r.models.Subcat;
import r.r.repos.CategoryRepo;
import r.r.repos.SubcatRepo;
import r.r.services.ImageUploadService;
import r.r.services.SubcatService;

@Service
public class SubcatImple implements SubcatService {

   private ImageUploadService imageUploadService;
   private SubcatRepo subcatRepo;
   private CategoryRepo categoryRepo;

   private SubcatImple(ImageUploadService imageUploadService, SubcatRepo subcatRepo, CategoryRepo categoryRepo) {
      this.imageUploadService = imageUploadService;
      this.subcatRepo = subcatRepo;
      this.categoryRepo = categoryRepo;
   }

   @Override
   public Subcat save(SubcatDto subcatDto) {
      Subcat subcat = new Subcat();
      subcat.setName(subcatDto.getName());
      subcat.setImage(imageUploadService.saveFile(subcatDto.getFile()));

      Optional<Category> opCategory = categoryRepo.findById(subcatDto.getCatId());
      if (opCategory.isPresent()) {
         Category category = opCategory.get();
         subcat.setCategory(category);
         return subcatRepo.save(subcat);
      } else
         throw new EntityNotFoundException("No Category with that id of " + subcatDto.getCatId());

   }

   @Override
   public Subcat get(int id) {
      Optional<Subcat> opSubcat = subcatRepo.findById(id);
      if (opSubcat.isPresent()) {
         return opSubcat.get();
      } else
         throw new EntityNotFoundException("No Sub Category with that is of " + id);
   }

   @Override
   public List<Subcat> all() {
      return subcatRepo.findAll();
   }

   @Override
   public Subcat update(int id, SubcatDto subcatDto) {
      Optional<Subcat> opSubcat = subcatRepo.findById(id);
      if (opSubcat.isPresent()) {

         Subcat subcat = opSubcat.get();
         subcat.setName(subcatDto.getName());
         subcat.setCategory(categoryRepo.findById(subcatDto.getCatId()).orElse(null));
         subcat.setImage(imageUploadService.saveFile(subcatDto.getFile()));

         return subcatRepo.save(subcat);

      } else
         throw new EntityNotFoundException("No Sub Category with that is of " + id);
   }

   @Override
   public Subcat nameChange(int id, SubcatDto subcatDto) {

      Optional<Subcat> opSubject = subcatRepo.findById(id);
      if (opSubject.isPresent()) {
         Subcat subcat = opSubject.get();
         subcat.setName(subcatDto.getName());
         return subcatRepo.save(subcat);
      } else
         throw new EntityNotFoundException("No Sub Category with that is of " + id);

   }

   @Override
   public Subcat imageChange(int id, SubcatDto subcatDto) {
      Optional<Subcat> opSubject = subcatRepo.findById(id);
      if (opSubject.isPresent()) {
         Subcat subcat = opSubject.get();
         subcat.setImage(imageUploadService.saveFile(subcatDto.getFile()));
         return subcatRepo.save(subcat);
      } else
         throw new EntityNotFoundException("No Sub Category with that is of " + id);
   }

   @Override
   public String drop(int id) {
      Optional<Subcat> opSubcat = subcatRepo.findById(id);
      if (opSubcat.isPresent()) {
         Subcat subcat = opSubcat.get();
         subcatRepo.delete(subcat);
         return "Sub Category Deleted!";
      } else
         throw new EntityNotFoundException("No Sub Category with that is of " + id);
   }

}
