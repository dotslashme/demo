package com.dotslashme.demo.sbts.controllers;

import com.dotslashme.demo.sbts.services.AccessKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/key")
public class AccessKeyController {

  private final AccessKeyService service;

  @Autowired
  public AccessKeyController(AccessKeyService service) {
    this.service = service;
  }

  @PostMapping(path = "/create")
  public void createAccessKey() {
    this.service.createAccessKey();
  }

  @PutMapping(path = "/refresh/{safeId}")
  public void refreshAccessKey(@PathVariable UUID safeId) {
    this.service.refreshAccessKey(safeId);
  }

  @PutMapping(path = "/revoke/{safeId}")
  public void revokeAccessKey(@PathVariable UUID safeId) {
    this.service.revokeAccessKey(safeId);
  }
}
