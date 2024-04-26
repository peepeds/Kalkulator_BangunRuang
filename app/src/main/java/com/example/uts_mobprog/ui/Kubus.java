package com.example.uts_mobprog.ui;

public class Kubus extends Geometry {
    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double calculateVolume() {
        return Math.pow(sisi, 3);
    }
}
