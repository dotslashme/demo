package com.dotslashme.demo.restyourmind.controllers;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/vehicle")
public class VehicleControllerV1 {

  @PostMapping(consumes = "application/vehicle.v1+json")
  public void createVehicle() {
    throw new NotYetImplementedException();
  }

  @GetMapping(path = "/{vehicleId}", produces = "application/vehicle.v1+json")
  public void readVehicle() {
    throw new NotYetImplementedException();
  }

  @PutMapping(consumes = "application/vehicle.v1+json")
  public void updateVehicle() {
    throw new NotYetImplementedException();
  }

  @DeleteMapping(path = "/{vehicleId}")
  public void deleteVehicle() {
    throw new NotYetImplementedException();
  }
}
