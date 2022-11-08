package com.davedev.menta.plantcards;

import java.io.Serializable;

public class ListElementPlant implements Serializable {
    public int imagePlant;
    public String namePlant;
    public String descriptionPlant;
    public String supportPlant;
    public String heightPlant;
    public String humidityPlant;
    public String temperaturePlant;

    public ListElementPlant(int imagePlant, String namePlant, String descriptionPlant, String supportPlant, String heightPlant, String humidityPlant, String temperaturePlant) {
        this.imagePlant = imagePlant;
        this.namePlant = namePlant;
        this.descriptionPlant = descriptionPlant;
        this.supportPlant = supportPlant;
        this.heightPlant = heightPlant;
        this.humidityPlant = humidityPlant;
        this.temperaturePlant = temperaturePlant;
    }

    public void setImagePlant(int imagePlant) {
        this.imagePlant = imagePlant;
    }

    public void setNamePlant(String namePlant) {
        this.namePlant = namePlant;
    }

    public void setDescriptionPlant(String descriptionPlant) { this.descriptionPlant = descriptionPlant; }

    public void setSupportPlant(String supportPlant) {
        this.supportPlant = supportPlant;
    }

    public void setHeightPlant(String heightPlant) {
        this.heightPlant = heightPlant;
    }

    public void setHumidityPlant(String humidityPlant) {
        this.humidityPlant = humidityPlant;
    }

    public void setTemperaturePlant(String temperaturePlant) { this.temperaturePlant = temperaturePlant; }

    public int getImagePlant() {return  imagePlant;}

    public String getNamePlant() {
        return namePlant;
    }

    public String getDescriptionPlant() {
        return descriptionPlant;
    }

    public String getSupportPlant() {
        return supportPlant;
    }

    public String getHeightPlant() {
        return heightPlant;
    }

    public String getHumidityPlant() {
        return humidityPlant;
    }

    public String getTemperaturePlant() {
        return temperaturePlant;
    }

}
