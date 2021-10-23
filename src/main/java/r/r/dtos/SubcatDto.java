package r.r.dtos;

import org.springframework.web.multipart.MultipartFile;

public class SubcatDto {
   int catId;
   String name;
   MultipartFile file;

   public SubcatDto(int catId, String name, MultipartFile file) {
      this.catId = catId;
      this.name = name;
      this.file = file;
   }

   public int getCatId() {
      return this.catId;
   }

   public void setCatId(int catId) {
      this.catId = catId;
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

   public SubcatDto() {
   }
}
