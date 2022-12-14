package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "BOOKING")
public class Booking implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(name = "date", nullable = false)
  private Date date;

  @Enumerated(EnumType.STRING)
  @Column(name = "time", nullable = false)
  private BookingTime time;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private BookingStatus status;

  @ManyToOne(optional = false)
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @ManyToOne(optional = false)
  @JoinColumn(name = "workspace_id", nullable = false)
  private Workspace workspaces;

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public BookingTime getTime() {
    return time;
  }

  public void setTime(BookingTime time) {
    this.time = time;
  }

  public BookingStatus getStatus() {
    return status;
  }

  public void setStatus(BookingStatus status) {
    this.status = status;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }

  public Workspace getWorkspaces() {
    return this.workspaces;
  }

  public void setWorkspaces(Workspace workspaces) {
    this.workspaces = workspaces;
  }

}