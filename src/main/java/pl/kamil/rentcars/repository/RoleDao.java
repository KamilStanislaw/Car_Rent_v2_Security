package pl.kamil.rentcars.repository;

import pl.kamil.rentcars.entity.Role;

public interface RoleDao {

    Role findRoleByName (String roleName);

}
