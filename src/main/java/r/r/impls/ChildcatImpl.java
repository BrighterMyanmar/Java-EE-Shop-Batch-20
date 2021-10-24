package r.r.impls;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import r.r.dtos.ChildcatDto;
import r.r.models.Childcat;
import r.r.repos.ChildcatRepo;
import r.r.repos.SubcatRepo;
import r.r.services.ChildcatService;
import r.r.services.ImageUploadService;

@Service
public class ChildcatImpl implements ChildcatService {

   private ImageUploadService imageUploadService;
   private SubcatRepo subcatRepo;
   private ChildcatRepo childcatRepo;

   private ChildcatImpl(ImageUploadService imageUploadService, SubcatRepo subcatRepo, ChildcatRepo childcatRepo) {
      this.imageUploadService = imageUploadService;
      this.subcatRepo = subcatRepo;
      this.childcatRepo = childcatRepo;
   }

   @Override
   public Childcat save(ChildcatDto childcatDto) {
      Childcat childcat = new Childcat();
      childcat.setName(childcatDto.getName());
      childcat.setImage(imageUploadService.saveFile(childcatDto.getFile()));
      childcat.setSubcat(subcatRepo.findById(childcatDto.getSubcatId()).orElse(null));
      return childcatRepo.save(childcat);
   }

   @Override
   public List<Childcat> all() {
      return childcatRepo.findAll();
   }

   @Override
   public Childcat get(int id) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         return opChildcat.get();
      } else
         throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

   @Override
   public Childcat update(int id, ChildcatDto childcatDto) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcat.setName(childcatDto.getName());
         childcat.setImage(imageUploadService.saveFile(childcatDto.getFile()));
         childcat.setSubcat(subcatRepo.findById(childcat.getId()).orElse(null));
         return childcatRepo.save(childcat);
      } else
         throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

   @Override
   public Childcat nameChange(int id, ChildcatDto childcatDto) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcat.setName(childcatDto.getName());
         return childcatRepo.save(childcat);
      } else
         throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

   @Override
   public Childcat imageChange(int id, ChildcatDto childcatDto) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcat.setImage(imageUploadService.saveFile(childcatDto.getFile()));
         return childcatRepo.save(childcat);
      } else
         throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

   @Override
   public String drop(int id) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {
         Childcat childcat = opChildcat.get();
         childcatRepo.delete(childcat);
         return "Success";
      } else
         throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

   @Override
   public Childcat subcatChange(int id, ChildcatDto childcatDto) {
      Optional<Childcat> opChildcat = childcatRepo.findById(id);
      if (opChildcat.isPresent()) {

         Childcat childcat = opChildcat.get();
         childcat.setSubcat(subcatRepo.findById(childcatDto.getSubcatId()).orElse(null));
         return childcatRepo.save(childcat);

      }
      throw new EntityNotFoundException("No Child Category with that id of " + id);
   }

}
