package r.r.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.RoleDto;
import r.r.models.Role;
import r.r.services.RoleService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/roles")
public class RoleController {

   @Autowired
   RoleService roleService;

   @PostMapping
   public ResponseEntity<String> save(@ModelAttribute RoleDto roleDto) {
      return ResponseEntity.ok(roleService.save(roleDto));
   }

   @GetMapping
   public ResponseEntity<List<Role>> all() {
      return ResponseEntity.ok(roleService.all());
   }

   @GetMapping("{id}")
   public ResponseEntity<Role> get(@PathVariable("id") int id) {
      return ResponseEntity.ok(roleService.get(id));
   }

   @PatchMapping("{id}")
   public ResponseEntity<String> update(@PathVariable("id") int id, @ModelAttribute RoleDto roleDto) {
      return ResponseEntity.ok(roleService.update(id, roleDto));
   }

   @DeleteMapping("{id}")
   public ResponseEntity<String> drop(@PathVariable("id") int id) {
      return ResponseEntity.ok(roleService.drop(id));
   }

}
