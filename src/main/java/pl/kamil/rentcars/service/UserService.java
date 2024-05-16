package pl.kamil.rentcars.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.kamil.rentcars.entity.User;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

}
