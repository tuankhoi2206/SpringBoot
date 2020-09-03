package org.khoivu.restfulwebservice.user;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {
  private static List<User> lstUsers = new ArrayList<User>();
  int usersCount = 3;
  static {
    lstUsers.add(new User(1, "Adam", new Date()));
    lstUsers.add(new User(2, "Eve", new Date()));
    lstUsers.add(new User(3, "Jack", new Date()));
  }

  public List<User> findAll() {
    return lstUsers;
  }

  public User save(User user) {
    if (user.getId() == null) {
      user.setId(++usersCount);
    }
    lstUsers.add(user);
    return user;
  }

  public User findOne(int id) {
    int index = lstUsers.indexOf(new User(new Integer(id)));
    if (index > -1) {
      return lstUsers.get(index);
    }
    return null;
  }

  public User deleteById(int id) {
    int index = lstUsers.indexOf(new User(id));
    if (index > -1) {
      return lstUsers.remove(index);
    }
    return null;
  }
}
