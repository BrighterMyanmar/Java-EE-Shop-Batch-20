package r.r.impls;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import r.r.dtos.TagDto;
import r.r.models.Tag;
import r.r.repos.TagRepo;
import r.r.services.ImageUploadService;
import r.r.services.TagService;

@Service
public class TagImple implements TagService {

   private ImageUploadService imageUploadService;
   private TagRepo tagRepo;

   private TagImple(ImageUploadService imageUploadService, TagRepo tagRepo) {
      this.imageUploadService = imageUploadService;
      this.tagRepo = tagRepo;
   }

   @Override
   public String save(TagDto tagDto) {
      Tag tag = new Tag();
      System.out.println("We are here!");
      System.out.println(tagDto.getName());
      tag.setName(tagDto.getName());
      tag.setImage(imageUploadService.saveFile(tagDto.getFile()));
      tagRepo.save(tag);
      return "Tag Save Success";
   }

   @Override
   public Tag get(int id) {
      Optional<Tag> opTag = tagRepo.findById(id);
      if (opTag.isPresent()) {
         return opTag.get();
      } else
         throw new EntityNotFoundException("No Tag with that id of " + id);
   }

   @Override
   public List<Tag> all() {
      return tagRepo.findAll();
   }

   @Override
   public Tag update(int id, TagDto tagDto) {
      Optional<Tag> opTag = tagRepo.findById(id);
      if (opTag.isPresent()) {
         Tag tag = opTag.get();
         tag.setName(tagDto.getName());
         tag.setImage(imageUploadService.saveFile(tagDto.getFile()));
         return tagRepo.save(tag);
      } else
         throw new EntityNotFoundException("No Tag with that id of " + id);
   }

   @Override
   public String drop(int id) {
      Optional<Tag> opTag = tagRepo.findById(id);
      if (opTag.isPresent()) {
         tagRepo.delete(opTag.get());
         return "Success";
      } else
         throw new EntityNotFoundException("No Tag with that id of " + id);
   }

}
