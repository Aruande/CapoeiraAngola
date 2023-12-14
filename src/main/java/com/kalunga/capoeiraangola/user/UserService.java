package com.kalunga.capoeiraangola.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserDAO userDAO;

    public List<User> listAll() {
        return (List<User>) userDAO.findAll();
    }

    public void save(User user) {
        userDAO.save(user);

    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = userDAO.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = userDAO.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with ID " + id);
        }
        userDAO.deleteById(id);
    }
}






