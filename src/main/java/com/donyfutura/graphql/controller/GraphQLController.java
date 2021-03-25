package com.donyfutura.graphql.controller;

import com.donyfutura.graphql.entity.Vehicle;
import com.donyfutura.graphql.mutation.VehicleMutation;
import com.donyfutura.graphql.query.VehicleQuery;
import com.donyfutura.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/rest")
public class GraphQLController {

    private final VehicleQuery vehicleQuery;
    private final VehicleMutation vehicleMutation;

    @Autowired
    public GraphQLController(VehicleQuery vehicleQuery, VehicleMutation vehicleMutation) {
        this.vehicleQuery = vehicleQuery;
        this.vehicleMutation = vehicleMutation;
    }

    @PostMapping("/veh")
    public Vehicle createVehicle(Vehicle vehicle) {

        return vehicleMutation.createVehicle(vehicle.getType(),
                vehicle.getModelCode(),
                vehicle.getBrandName(),
                vehicle.getFormattedDate());

    }

    @GetMapping("/vehs")
    public List<Vehicle> getVehicles(@RequestParam int count){
        return vehicleQuery.getVehicles(count);
    }

    @GetMapping("/veh")
    public Optional<Vehicle> getVehicle(@RequestParam int id){
        return vehicleQuery.getVehicle(id);
    }


}
