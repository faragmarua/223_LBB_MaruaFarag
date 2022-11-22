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
public class Workspace {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String description;

  @Column(name = "has_beamer", nullable = false)
  Boolean beamer = false;

  @Column(name = "has_whiteboard", nullable = false)
  Boolean whiteboard = false;

  @OneToMany(mappedBy = "workspace")
  private Set<Booking> bookings;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getBeamer() {
    return beamer;
  }

  public void setBeamer(Boolean beamer) {
    this.beamer = beamer;
  }

  public Boolean getWhiteboard() {
    return whiteboard;
  }

  public void setWhiteboard(Boolean whiteboard) {
    this.whiteboard = whiteboard;
  }

}
