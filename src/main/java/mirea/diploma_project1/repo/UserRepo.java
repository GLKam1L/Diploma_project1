package mirea.diploma_project1.repo;

import org.springframework.data.repository.CrudRepository;
import mirea.diploma_project1.domain.User;

public interface UserRepo extends CrudRepository<User,Long> {
    User findByUsername(String name);
}
