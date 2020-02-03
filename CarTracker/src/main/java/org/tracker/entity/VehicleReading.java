package org.tracker.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class VehicleReading {


    @Id
    private String id;

    @Column(unique = true)
    private String vin;
    private int latitude;
    private int longitude;
    private Date timestamp;
    private int fuelVolume;
    private int speed;
    private int engine;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlO;
    private int engineRpm;

    @OneToOne(cascade = CascadeType.ALL)
    private Tires tires;

    public VehicleReading(){
        this.id= UUID.randomUUID().toString();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlO() {
        return cruiseControlO;
    }

    public void setCruiseControlO(boolean cruiseControlO) {
        this.cruiseControlO = cruiseControlO;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "vehicleReading{" +
                "vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engine=" + engine +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlO=" + cruiseControlO +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }
}
