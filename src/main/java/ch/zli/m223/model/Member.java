package ch.zli.m223.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Entity(name = "MEMBER")
public class Member implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;



  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "firstname", nullable = false)
  String firstname;

  @Column(name = "lastname", nullable = false)
  String lastname;

  @Column(name = "password", nullable = false)
  String password;

  @Column(name = "is_admin", nullable = false)
  Boolean isAdmin = false;


  @Override
  public int hashCode() {
    return getClass().hashCode();
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }
}
