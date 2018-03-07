package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel="users", path ="users")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);}