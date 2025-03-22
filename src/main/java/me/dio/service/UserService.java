package me.dio.service;

import me.dio.domain.model.Account;
import me.dio.domain.model.User;

//encapsulamento
public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
