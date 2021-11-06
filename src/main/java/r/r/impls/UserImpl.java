package r.r.impls;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import r.r.dtos.UserDto;
import r.r.models.User;
import r.r.repos.UserRepo;
import r.r.services.UserService;

@Service
public class UserImpl implements UserService {

   private UserRepo userRepo;

   private UserImpl(UserRepo userRepo) {
      this.userRepo = userRepo;
   }

   @Override
   public String register(UserDto userDto) {
      User user = new User();
      user.setName(userDto.getName());
      user.setPhone(userDto.getPhone());
      user.setPassword(userDto.getPassword());
      User dbUser = userRepo.save(user);
      if (dbUser.getName().isEmpty()) {
         return "User Registration Fail";
      } else {
         return "User Registration Success!";
      }
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = userRepo.findByName(username);
      return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
            new ArrayList<>());
   }

}
