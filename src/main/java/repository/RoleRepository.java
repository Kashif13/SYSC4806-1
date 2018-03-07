package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel="roles", path ="roles")
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}