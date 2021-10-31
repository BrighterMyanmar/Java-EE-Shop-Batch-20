package r.r.dtos;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
   String name;
   String brand;
   int price;
   MultipartFile[] files;
   int catId;
   int subcatId;
   int childcatId;
   int tagId;

   public ProductDto() {
   }

   public ProductDto(String name, String brand, int price, MultipartFile[] files, int catId, int subcatId,
         int childcatId, int tagId) {
      this.name = name;
      this.brand = brand;
      this.price = price;
      this.files = files;
      this.catId = catId;
      this.subcatId = subcatId;
      this.childcatId = childcatId;
      this.tagId = tagId;

   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public int getPrice() {
      return this.price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public MultipartFile[] getFiles() {
      return this.files;
   }

   public void setFiles(MultipartFile[] files) {
      this.files = files;
   }

   public int getCatId() {
      return this.catId;
   }

   public void setCatId(int catId) {
      this.catId = catId;
   }

   public int getSubcatId() {
      return this.subcatId;
   }

   public void setSubcatId(int subcatId) {
      this.subcatId = subcatId;
   }

   public int getChildcatId() {
      return this.childcatId;
   }

   public void setChildcatId(int childcatId) {
      this.childcatId = childcatId;
   }

   public int getTagId() {
      return this.tagId;
   }

   public void setTagId(int tagId) {
      this.tagId = tagId;
   }

}
