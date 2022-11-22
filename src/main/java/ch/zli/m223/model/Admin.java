package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  public Admin(Long id, String name, Set<Member> members) {
    this.id = id;
    this.name = name;
    this.members = members;
  }

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "admin")
  private Set<Member> members;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
