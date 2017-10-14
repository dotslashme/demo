package com.dotslashme.demo.rest.singlewriteoperations.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dotslashme.demo.rest.singlewriteoperations.dtos.ProfileDto;

@Entity
@Table(name = "profile")
public class ProfileEntity implements Serializable {

  private static final Long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private UUID identifier = UUID.randomUUID();

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String surname;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String phone;

  public ProfileEntity() {}

  public ProfileEntity(ProfileDto dto) {
    this.identifier = dto.getIdentifier();
    this.firstName = dto.getFirstName();
    this.surname = dto.getSurname();
    this.address = dto.getAddress();
    this.phone = dto.getPhone();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UUID getIdentifier() {
    return identifier;
  }

  public void setIdentifier(UUID identifier) {
    this.identifier = identifier;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
