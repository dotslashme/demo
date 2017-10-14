package com.dotslashme.demo.rest.singlewriteoperations.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dotslashme.demo.rest.singlewriteoperations.entities.ProfileEntity;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

  ProfileEntity getOneByIdentifier(UUID identifier);
}
