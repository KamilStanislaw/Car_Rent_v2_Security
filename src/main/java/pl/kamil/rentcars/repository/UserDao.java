package pl.kamil.rentcars.repository;

import pl.kamil.rentcars.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}
