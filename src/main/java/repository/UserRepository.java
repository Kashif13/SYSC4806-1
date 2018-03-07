package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.User;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);}