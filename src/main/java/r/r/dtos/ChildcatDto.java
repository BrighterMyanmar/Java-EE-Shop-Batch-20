package r.r.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ChildcatDto {
   int subcatId;
   String name;
   MultipartFile file;

   public ChildcatDto() {
   }

   public ChildcatDto(int subcatId, String name, MultipartFile file) {
      this.subcatId = subcatId;
      this.name = name;
      this.file = file;
   }

   public int getSubcatId() {
      return this.subcatId;
   }

   public void setSubcatId(int subcatId) {
      this.subcatId = subcatId;
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
