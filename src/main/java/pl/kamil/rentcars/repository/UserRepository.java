package pl.kamil.rentcars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamil.rentcars.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUserName(String userName);
    User findByUserName(String userName);

}
