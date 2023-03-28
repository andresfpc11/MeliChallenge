package com.meli.controller;

import java.util.Scanner;

public class ControllerMenu {
    Scanner sn = new Scanner(System.in);
    ControllerSatellite controllerSatellite = new ControllerSatellite();

    public ControllerMenu() {
        paintLocationMenu();
        paintMessageMenu();
    }

    public void paintLocationMenu() {
        double distanceKenobi = -1;
        double distanceSkyWalker = -1;
        double distanceSato = -1;
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("-------------------------------   MELI CHALLENGE   -----------------------------------");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Una nave perdida en el espacio requiere de su ayuda para regresar a salvo ");
        System.out.println("Usted como controlador del espacio, debera ingresar la distancia de la nave con respecto a los tres satelites disponibles");
        System.out.println("Estos satelites son: Kenobi, Skywalker y Sato");
        System.out.println("Estos satelites no solo se encargan de controlar la distancia de las naves");
        System.out.println("Tambien se encargan de las comunicaciones, por lo que debe registrar el mensaje que llega encriptado a cada uno de ellos");
        System.out.println("¡Mucha suerte en su misión y que la fueza lo acompañe!");
        System.out.println("");
        System.out.println("Ingrese la distancia al satelite Kenobi: ");
        while(distanceKenobi<=0) {
            distanceKenobi = validateDouble();
        }
        System.out.println("Ingrese la distancia al satelite Skywalker: ");
        while(distanceSkyWalker<=0) {
            distanceSkyWalker = validateDouble();
        }
        System.out.println("Ingrese la distancia al satelite Sato: ");
        while(distanceSato<=0) {
            distanceSato = validateDouble();
        }
        controllerSatellite.getLocation(distanceKenobi, distanceSkyWalker, distanceSato);
    }

    public void paintMessageMenu() {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("¡Excelente! ya sabemos la posición de la nave, ahora descifremos el mensaje");
        System.out.println("Ingrese el mensaje al satelite Kenobi: ");
        String messageKenobi = sn.next();
        System.out.println("Ingrese el mensaje al satelite SkyWalker: ");
        String messageSkyWalker = sn.next();
        System.out.println("Ingrese el mensaje al satelite Sato: ");
        String messageSato = sn.next();
        controllerSatellite.getMessage(messageKenobi,messageSkyWalker,messageSato);
        System.out.println("Lo lograste terminaste la misión  ¡Gracias!");
    }

    private double validateDouble() {
        double distance=0;
        try {
            distance = sn.nextDouble();
        } catch (Exception e) {
            System.out.println("Ingrese un valor valido: ");
        } finally {
            sn.nextLine();
        }
        return distance;
    }
}
