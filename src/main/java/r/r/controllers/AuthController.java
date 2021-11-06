package r.r.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import r.r.dtos.UserDto;
import r.r.services.UserService;
import r.r.utils.AuthenticationRequest;
import r.r.utils.AuthenticationResponse;
import r.r.utils.JwtUtil;

@RestController
public class AuthController {
   @Autowired
   AuthenticationManager authenticationManager;

   @Autowired
   UserService userService;

   @Autowired
   JwtUtil jwtUtil;

   @PostMapping("/login")
   public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
      System.out.println(authenticationRequest.getName());
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getName(),
            authenticationRequest.getPassword()));

      final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getName());
      final String jwt = jwtUtil.genToken(userDetails);
      return ResponseEntity.ok(new AuthenticationResponse(jwt));

   }

   @PostMapping("/register")
   public ResponseEntity<String> save(@ModelAttribute UserDto userDto) {
      return ResponseEntity.ok(userService.register(userDto));
   }

}
