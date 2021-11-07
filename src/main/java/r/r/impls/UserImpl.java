package r.r.impls;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import r.r.dtos.UserDto;
import r.r.models.Role;
import r.r.models.User;
import r.r.repos.RoleRepo;
import r.r.repos.UserRepo;
import r.r.services.UserService;

@Service
public class UserImpl implements UserService {

   private UserRepo userRepo;
   private RoleRepo roleRepo;

   private UserImpl(UserRepo userRepo, RoleRepo roleRepo) {
      this.userRepo = userRepo;
      this.roleRepo = roleRepo;
   }

   @Override
   public String register(UserDto userDto) {
      User user = new User();
      user.setName(userDto.getName());
      user.setPhone(userDto.getPhone());
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      user.setPassword(encoder.encode(userDto.getPassword()));
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
      return new MyUserDetail(user);

      // return new org.springframework.security.core.userdetails.User(user.getName(),
      // user.getPassword(),
      // new ArrayList<>());
   }

   @Override
   public String addRole(int userId, int roleId) {
      Optional<User> opUser = userRepo.findById(userId);
      Optional<Role> opRole = roleRepo.findById(roleId);

      if (opUser.isPresent()) {
         if (opRole.isPresent()) {
            User user = opUser.get();
            Role role = opRole.get();
            Set<Role> roles = user.getRoles();
            roles.add(role);
            user.setRoles(roles);
            userRepo.save(user);
            return "Role Added to User";
         } else
            throw new EntityNotFoundException("No Role with that id");
      } else
         throw new EntityNotFoundException("No User with that id");
   }

}
