package r.r.services;

import java.util.List;

import org.springframework.stereotype.Service;

import r.r.dtos.RoleDto;
import r.r.models.Role;

@Service
public interface RoleService {
   String save(RoleDto roleDto);

   Role get(int id);

   List<Role> all();

   String update(int id, RoleDto roleDto);

   String drop(int id);

}
