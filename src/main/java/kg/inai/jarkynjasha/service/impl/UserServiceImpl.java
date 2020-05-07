package kg.inai.jarkynjasha.service.impl;

import kg.inai.jarkynjasha.entity.User;
import kg.inai.jarkynjasha.exception.RecordNotFoundException;
import kg.inai.jarkynjasha.repository.UserRepository;
import kg.inai.jarkynjasha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RecordNotFoundException("Record not found with id:" + id));
    }
    @Override
    public void create(User user) {
        User organization = new User();
        organization.setLogin(user.getLogin());
        organization.setPassword(user.getPassword());
        userRepository.save(organization);
    }
}
