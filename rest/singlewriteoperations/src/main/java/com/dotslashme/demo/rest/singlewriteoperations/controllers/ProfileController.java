package com.dotslashme.demo.rest.singlewriteoperations.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dotslashme.demo.rest.singlewriteoperations.dtos.ProfileDto;
import com.dotslashme.demo.rest.singlewriteoperations.entities.ProfileEntity;
import com.dotslashme.demo.rest.singlewriteoperations.services.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

  @Autowired
  private ProfileService service;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity create(@RequestBody ProfileEntity profile) {
    return new ResponseEntity<>(this.service.create(profile), HttpStatus.CREATED);
  }

  @RequestMapping(path = "/swo", method = RequestMethod.POST)
  public ResponseEntity createSwo(@RequestBody ProfileDto profile) {
    return new ResponseEntity<>(this.service.create(profile), HttpStatus.CREATED);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)
  public ResponseEntity getById(@PathVariable Long id) {
    return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/swo/{id}", method = RequestMethod.GET)
  public ResponseEntity getSwoById(@PathVariable UUID id) {
    return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity update(@PathVariable Long id, @RequestBody ProfileEntity profile) {
    return new ResponseEntity<>(this.service.updateProfile(id, profile), HttpStatus.ACCEPTED);
  }

  @RequestMapping(path = "/swo/{id}", method = RequestMethod.PUT)
  public ResponseEntity updateSwo(@PathVariable UUID id, @RequestBody ProfileDto profile) {
    return new ResponseEntity<>(this.service.updateProfile(id, profile), HttpStatus.ACCEPTED);
  }

}
