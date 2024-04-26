package com.example.uts_mobprog.ui;

public class Bola extends Geometry {
    private double diameter;

    public Bola(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double calculateVolume() {
        double radius = diameter / 2.0;
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }
}
