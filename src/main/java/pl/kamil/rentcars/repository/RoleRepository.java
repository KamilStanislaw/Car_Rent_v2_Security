package pl.kamil.rentcars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kamil.rentcars.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

//    Role findRoleByName (String roleName);
    Role findByName (String roleName);

}
