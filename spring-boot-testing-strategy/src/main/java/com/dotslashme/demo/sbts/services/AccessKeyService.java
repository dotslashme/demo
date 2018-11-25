package com.dotslashme.demo.sbts.services;

import com.dotslashme.demo.sbts.dtos.AccessKeyDto;
import com.dotslashme.demo.sbts.entities.AccessKey;
import com.dotslashme.demo.sbts.repositories.AccessKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccessKeyService {

  private final AccessKeyRepository repository;

  @Autowired
  public AccessKeyService(AccessKeyRepository repository) {
    this.repository = repository;
  }

  public AccessKeyDto createAccessKey() {
    AccessKey ak = new AccessKey();
    return new AccessKeyDto();
  }

  public AccessKeyDto refreshAccessKey(UUID safeId) {
    return new AccessKeyDto();
  }

  public AccessKeyDto revokeAccessKey(UUID safeId) {
    return new AccessKeyDto();
  }
}
