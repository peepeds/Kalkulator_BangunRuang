package com.example.uts_mobprog.ui;

public class Piramida extends Geometry {
    private double sisi;
    private double tinggi;

    public Piramida(double sisi, double tinggi) {
        this.sisi = sisi;
        this.tinggi = tinggi;
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * sisi *sisi * tinggi;
    }
}
