package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
   User getUserById(Long id);
    void create(User user);
}
