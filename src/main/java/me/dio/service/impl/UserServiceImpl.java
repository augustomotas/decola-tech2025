package me.dio.service.impl;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) { //essa exceção do java ja tem uma semantic legal pro que precisamos
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getCpf() != null && userRepository.existsByCpf(userToCreate.getCpf()))
            throw new IllegalArgumentException("This user already exists.");

        return userRepository.save(userToCreate);

    }

}
