package com.dotslashme.demo.rest.singlewriteoperations.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dotslashme.demo.rest.singlewriteoperations.dtos.ProfileDto;
import com.dotslashme.demo.rest.singlewriteoperations.entities.ProfileEntity;
import com.dotslashme.demo.rest.singlewriteoperations.repositories.ProfileRepository;

@Service
public class ProfileService {

  @Autowired
  private ProfileRepository repository;

  public ProfileEntity create(ProfileEntity profile) {
    return this.repository.save(profile);
  }

  public ProfileDto create(ProfileDto profile) {
    ProfileEntity entityToSave = new ProfileEntity(profile);
    ProfileEntity savedEntityToConvert = this.repository.save(entityToSave);
    return new ProfileDto(savedEntityToConvert);
  }

  public ProfileEntity getById(Long id) {
    return this.repository.getOne(id);
  }

  public ProfileDto getById(UUID id) {
    ProfileEntity entityFromDb = this.repository.getOneByIdentifier(id);
    return new ProfileDto(entityFromDb);
  }

  public ProfileEntity updateProfile(Long id, ProfileEntity profile) {
    ProfileEntity entityFromDb = this.repository.getOne(id);
    entityFromDb.setFirstName(profile.getFirstName());
    entityFromDb.setSurname(profile.getSurname());
    entityFromDb.setAddress(profile.getAddress());
    entityFromDb.setPhone(profile.getPhone());
    entityFromDb.setIdentifier(profile.getIdentifier());
    return this.repository.save(entityFromDb);
  }

  public ProfileDto updateProfile(UUID id, ProfileDto profile) {

    ProfileEntity entityFromDb = this.repository.getOneByIdentifier(id);
    entityFromDb.setFirstName(profile.getFirstName());
    entityFromDb.setSurname(profile.getSurname());
    entityFromDb.setAddress(profile.getAddress());
    entityFromDb.setPhone(profile.getPhone());
    entityFromDb.setIdentifier(UUID.randomUUID());

    ProfileDto dtoToReturn = new ProfileDto(this.repository.save(entityFromDb));

    return dtoToReturn;
  }
}
