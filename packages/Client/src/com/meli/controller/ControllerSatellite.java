package com.meli.controller;

import com.meli.business.SatelliteBusiness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerSatellite {

    SatelliteBusiness satelliteBusiness = new SatelliteBusiness();

    public void getLocation(double distanceKenobi, double distanceSkyWalker, double distanceSato) {
        satelliteBusiness.calculateDistance(distanceKenobi, distanceSkyWalker, distanceSato);
        satelliteBusiness.getPositionX();
        satelliteBusiness.getPositionY();
        System.out.println("La posición del emisor es: " + satelliteBusiness.getPositionX() + " X, "
                + satelliteBusiness.getPositionY() + " en Y");
    }
    public void getMessage(String messageKenobi, String messageSkyWalker,
                           String messageSato) {
        List<String> ListKenobi = transformStringToList(messageKenobi);
        List<String> ListSkyWalker = transformStringToList(messageSkyWalker);
        List<String> ListSato = transformStringToList(messageSkyWalker);
        satelliteBusiness.getMessage(ListKenobi,ListSkyWalker, ListSato);
    }

    private int getBiggerSize(int sizeMessageKenobi, int sizeMessageSkyWalker, int sizeMessageSato) {
        int biggerSize = 0;
        if (sizeMessageKenobi >= sizeMessageSkyWalker && sizeMessageKenobi >= sizeMessageSato) {
            biggerSize = sizeMessageKenobi;
        } else if (sizeMessageSkyWalker >= sizeMessageSato) {
            biggerSize = sizeMessageSkyWalker;
        } else {
            biggerSize = sizeMessageSato;
        }
        return biggerSize;
    }

    public List<String> transformStringToList(String message){
        List<String> ListMessage = new ArrayList<String>(Arrays.asList(message.
                replaceAll("\"","").replaceAll("\\[","").replaceAll("\\]","")
                .split(",")));
        return ListMessage;
    }

}
