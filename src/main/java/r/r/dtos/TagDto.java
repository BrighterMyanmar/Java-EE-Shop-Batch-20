package r.r.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class TagDto {
   @NotBlank(message = "Name is Required")
   String name;
   @NotNull(message = "Image is Required")
   MultipartFile file;

   public TagDto(String name, MultipartFile file) {

      this.name = name;
      this.file = file;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public MultipartFile getFile() {
      return this.file;
   }

   public void setFile(MultipartFile file) {
      this.file = file;
   }

}
