package r.r.impls;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import r.r.dtos.RoleDto;
import r.r.models.Role;
import r.r.repos.RoleRepo;
import r.r.services.RoleService;

@Service
public class RoleImpl implements RoleService {

   private RoleRepo roleRepo;

   public RoleImpl(RoleRepo roleRepo) {
      this.roleRepo = roleRepo;
   }

   @Override
   public String save(RoleDto roleDto) {
      Role role = new Role();
      role.setName(roleDto.getName());
      roleRepo.save(role);
      return "Role Successfully Saved!";
   }

   @Override
   public Role get(int id) {
      Optional<Role> opRole = roleRepo.findById(id);
      if (opRole.isPresent()) {
         return opRole.get();
      } else
         throw new EntityNotFoundException("No role with that id of " + id);
   }

   @Override
   public List<Role> all() {
      return roleRepo.findAll();
   }

   @Override
   public String update(int id, RoleDto roleDto) {
      Optional<Role> opRole = roleRepo.findById(id);
      if (opRole.isPresent()) {
         Role role = opRole.get();
         role.setName(roleDto.getName());
         roleRepo.save(role);
         return "Role Updated";
      } else
         throw new EntityNotFoundException("No role with that id of " + id);
   }

   @Override
   public String drop(int id) {
      Optional<Role> opRole = roleRepo.findById(id);
      if (opRole.isPresent()) {
         Role role = opRole.get();
         roleRepo.delete(role);
         return "Role Deleted";
      } else
         throw new EntityNotFoundException("No role with that id of " + id);
   }

}
