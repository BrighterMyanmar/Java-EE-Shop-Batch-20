package r.r.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import r.r.dtos.UserDto;

@Service
public interface UserService extends UserDetailsService {
   String register(UserDto userDto);
}
