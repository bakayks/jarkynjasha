package kg.inai.jarkynjasha.service;

import kg.inai.jarkynjasha.entity.User;
import kg.inai.jarkynjasha.model.NewsModel;

import java.util.List;

public interface UserService {
    List<User> findAll();
   User getUserById(Long id);
    void create(User user);
}
