package com.github.andylke.demo.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserRestController {

  @Autowired private UserRepository repository;

  @GetMapping
  public Optional<User> findUser(
      @RequestParam String title,
      @RequestParam String firstName,
      @RequestParam String lastName,
      @RequestParam String gender) {
    return repository.findBy(title, firstName, lastName, gender);
  }
}
