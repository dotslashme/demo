package com.dotslashme.demo.restyourmind.repositories;

import com.dotslashme.demo.restyourmind.entities.VehicleV1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleV1, UUID> {
}
