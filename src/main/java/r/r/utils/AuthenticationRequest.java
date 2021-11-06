package r.r.utils;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

   private String name;
   private String password;

   public AuthenticationRequest() {
   }

   public AuthenticationRequest(String name, String password) {
      this.name = name;
      this.password = password;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

}
