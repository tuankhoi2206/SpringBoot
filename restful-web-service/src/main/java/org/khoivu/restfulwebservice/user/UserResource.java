package org.khoivu.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserResource {

  @Autowired
  UserDaoService userDaoService;

  //retrieveAllUsers
  @GetMapping(path = "/users")
  public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
  }

  //retrieveUserById(int id)
  @GetMapping(path = "/users/{id}")
  public User retrieveUserById(@PathVariable int id) {

    System.out.println("This is my test " + id);
    User user = userDaoService.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
    return user;
  }

  //
  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userDaoService.save(user);
    URI location = ServletUriComponentsBuilder//
        .fromCurrentRequest()//
        .path("/{id}")//
        .buildAndExpand(savedUser.getId())//
        .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User delUser = userDaoService.deleteById(id);
    if (delUser == null) {
      throw new UserNotFoundException("id-" + id);
    }
  }
}
