package com.donyfutura.graphql.repository;

import com.donyfutura.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {



}
