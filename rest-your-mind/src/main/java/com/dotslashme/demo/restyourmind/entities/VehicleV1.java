package com.dotslashme.demo.restyourmind.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "vehicle")
public class VehicleV1 {

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private UUID vehicleId;

  private String vinNumber;

  public String getVinNumber() {
    return vinNumber;
  }

  public void setVinNumber(String vinNumber) {
    this.vinNumber = vinNumber;
  }
}
