package com.MeLi.controller;

import com.MeLi.bussines.SatelliteBusiness;
import com.MeLi.model.Position;
import com.MeLi.model.ResponsePosition;
import com.MeLi.model.Satellite;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("MeliTest")
public class ControllerSatellite {

    SatelliteBusiness satelliteBusiness = new SatelliteBusiness();

    @PostMapping  ("/topsecret/")

    public ResponsePosition topSecret(@RequestBody ArrayList<Satellite> satellites) {
        satelliteBusiness.calculateDistance(satellites.get(0).getDistance(),satellites.get(1).getDistance(),
                satellites.get(2).getDistance());
        Position position = new Position(satelliteBusiness.getPositionX(), satelliteBusiness.getPositionY());
        ResponsePosition response = new ResponsePosition(position, satelliteBusiness.getMessage
                (satellites.get(0).getMessage(),satellites.get(1).getMessage(), satellites.get(2).getMessage()));
        return response;
    }
}
