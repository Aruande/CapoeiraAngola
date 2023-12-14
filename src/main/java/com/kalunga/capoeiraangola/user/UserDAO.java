package com.kalunga.capoeiraangola.user;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

}
