package com.dotslashme.demo.sbts.repositories;

import com.dotslashme.demo.sbts.entities.AccessKey;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessKeyRepository extends JpaRepository<AccessKey, Long> {}
