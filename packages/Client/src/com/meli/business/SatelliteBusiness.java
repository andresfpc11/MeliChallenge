package com.meli.business;

import com.meli.utils.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SatelliteBusiness {

    Parameters parameters = new Parameters();

    public SatelliteBusiness() {
        this.calculateConstants();
    }

    /**
     * teniendo en cuenta la ecuación descrita en la documentación (readme.md)
     * procedemos a crear las constantes para hallar las coodernadas "X" y "Y"
     */
    private double constJ;
    private double constK;
    private double constL;
    private double constN;
    private double constM;
    private double constO;
    private double constX;
    private double constY;

    public double getConstJ() {
        return constJ;
    }

    public void setConstJ(double constJ) {
        this.constJ = constJ;
    }

    public double getConstL() {
        return constL;
    }

    public void setConstL(double constL) {
        this.constL = constL;
    }

    public double getConstN() {
        return constN;
    }

    public void setConstN(double constN) {
        this.constN = constN;
    }

    public double getConstM() {
        return constM;
    }

    public void setConstM(double constM) {
        this.constM = constM;
    }

    public double getConstO() {
        return constO;
    }

    public void setConstO(double constO) {
        this.constO = constO;
    }

    public double getConstK() {
        return constK;
    }

    public void setConstK(double constK) {
        this.constK = constK;
    }

    public double getConstX() {
        return constX;
    }

    public void setConstX(double constX) {
        this.constX = constX;
    }

    public double getConstY() {
        return constY;
    }

    public void setConstY(double constY) {
        this.constY = constY;
    }

    private void calculateConstants() {
        this.setConstJ(-2 * (parameters.positionKenobi[0]) + 2 * (parameters.positionSkyWalker[0]));
        this.setConstK(-2 * (parameters.positionKenobi[1]) + 2 * (parameters.positionSkyWalker[1]));
        this.setConstL(-Math.pow(parameters.positionKenobi[0], 2) + Math.pow(parameters.positionSkyWalker[0], 2)
                - Math.pow(parameters.positionKenobi[1], 2) + Math.pow(parameters.positionSkyWalker[1], 2));
        this.setConstM(-2 * (parameters.positionSkyWalker[0]) + 2 * (parameters.positionSato[0]));
        this.setConstN(-2 * (parameters.positionSkyWalker[1]) + 2 * (parameters.positionSato[1]));
        this.setConstO(-Math.pow(parameters.positionSkyWalker[0], 2) + Math.pow(parameters.positionSato[0], 2)
                - Math.pow(parameters.positionSkyWalker[1], 2) + Math.pow(parameters.positionSato[1], 2));
    }

    public void calculateDistance(double distanceKenobi, double distanceSkyWalker, double distanceSato) {
        this.setConstX(this.getConstL() + Math.pow(distanceKenobi, 2)
                - Math.pow(distanceSkyWalker, 2));
        this.setConstY(this.getConstO() + Math.pow(distanceSkyWalker, 2)
                - Math.pow(distanceSato, 2));
    }

    public double getPositionX() {
        double numeratorX = (this.getConstX() * this.getConstN()) - (this.getConstY() * this.getConstK());
        double denominatorX = (this.getConstN() * this.getConstJ()) - (this.getConstK() * this.getConstM());
        return numeratorX / denominatorX;
    }

    public double getPositionY() {
        double numeratorY = (this.getConstX() * this.getConstM()) - (this.getConstJ() * this.getConstY());
        double denominatorY = (this.getConstK() * this.getConstM()) - (this.getConstJ() * this.getConstN());
        return numeratorY / denominatorY;
    }

    public void getMessage(List<String> messageKenobi, List<String> messageSkyWalker, List<String> messageSato) {
        int auxSize = getBiggerSize(messageKenobi.size(), messageSkyWalker.size(), messageSato.size());
        List<String> wordList = new ArrayList<>();
        for (int i = auxSize - 1; i >= 0; i--) {
            if (i < messageKenobi.size()) {
                if (!messageKenobi.get(i).equals("")) {
                    wordList.add(messageKenobi.get(i));
                }
            }
            if (i < messageSkyWalker.size()) {
                if (!messageSkyWalker.get(i).equals("")) {
                    wordList.add(messageSkyWalker.get(i));
                }
            }
            if (i < messageSato.size()) {
                if (!messageSato.get(i).equals("")) {
                    wordList.add(messageSato.get(i));
                }
            }
            wordList = wordList.stream().distinct().collect(Collectors.toList());
        }
        String message = "";
        for (String word : wordList) {
            message = word + " " + message;
        }
        System.out.println("El mensaje es: " + message.trim());
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
}
