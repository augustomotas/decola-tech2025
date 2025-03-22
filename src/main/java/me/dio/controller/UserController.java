package me.dio.controller;
import me.dio.domain.model.User;
import me.dio.service.UserService;
import me.dio.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){//eh bom ter um DTO especifico pra expor o dados especificos do usuario
    var user = userService.findById(id);
    return ResponseEntity.ok(user);
    }


    @PostMapping()
    public ResponseEntity<User> create(@RequestBody User userToCreate){//eh bom ter um DTO especifico pra expor o dados especificos do usuario
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);//manda a localizacao do usuário
    }
}
