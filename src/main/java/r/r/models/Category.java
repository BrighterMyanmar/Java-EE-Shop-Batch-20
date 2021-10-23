package r.r.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Category {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;
   String name;
   String image;

   @JsonManagedReference
   @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   @JoinColumn(name = "category_id")
   List<Subcat> subcats;

   public Category() {
   }

   public Category(String name, String image) {
      this.name = name;
      this.image = image;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getImage() {
      return this.image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public List<Subcat> getSubcats() {
      return this.subcats;
   }

   public void setSubcats(List<Subcat> subcats) {
      this.subcats = subcats;
   }

   public String toString() {
      return "Id is : " + this.id + "\nName is : " + this.name + "\nImage is : " + this.image;
   }

}
