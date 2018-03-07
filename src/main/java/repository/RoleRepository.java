package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Role;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRole(String role);
}