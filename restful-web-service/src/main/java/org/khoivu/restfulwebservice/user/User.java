package org.khoivu.restfulwebservice.user;

import java.sql.Date;


/**
 * @author KhoiVu
 *
 */
public class User {
  private Integer id;
  private String name;
  private Date birthDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
  }
}
