package pl.kamil.rentcars.dao;

import pl.kamil.rentcars.entity.User;

public interface UserDao {

    User findByUserName(String userName);

}
