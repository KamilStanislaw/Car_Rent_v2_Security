package pl.kamil.rentcars.dao;

import pl.kamil.rentcars.entity.Role;

public interface RoleDao {

    Role findRoleByName (String roleName);

}
