package com.dotslashme.demo.rest.singlewriteoperations.dtos;

import java.io.Serializable;
import java.util.UUID;

import com.dotslashme.demo.rest.singlewriteoperations.entities.ProfileEntity;

public class ProfileDto implements Dto, Serializable {

  private static final Long serialVersionUID = 1L;

  private UUID identifier = UUID.randomUUID();
  private String firstName;
  private String surname;
  private String address;
  private String phone;

  public ProfileDto() {}

  public ProfileDto(ProfileEntity entity) {
    this.identifier = entity.getIdentifier();
    this.firstName = entity.getFirstName();
    this.surname = entity.getSurname();
    this.address = entity.getAddress();
    this.phone = entity.getPhone();
  }

  @Override
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
