package kg.inai.jarkynjasha.repository;

import kg.inai.jarkynjasha.entity.News;
import kg.inai.jarkynjasha.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
