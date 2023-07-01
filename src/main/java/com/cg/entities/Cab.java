package com.cg.entities;

import javax.persistence.*;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cabId;

    @Column(name = "car_type", nullable = false)
    private String carType;

    @Column(name = "per_km_rate", nullable = false)
    private float perKmRate;

    public Cab() {}

    public Cab(Integer cabId, String carType, float perKmRate) {
        super();
        this.cabId = cabId;
        this.carType = carType;
        this.perKmRate = perKmRate;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public float getPerKmRate() {
        return perKmRate;
    }

    public void setPerKmRate(float perKmRate) {
        this.perKmRate = perKmRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cab)) return false;
        Cab cab = (Cab) o;
        return Float.compare(cab.getPerKmRate(), getPerKmRate()) == 0 && getCabId().equals(cab.getCabId()) && getCarType().equals(cab.getCarType());
    }

    @Override
    public int hashCode() {
        int result = getCabId().hashCode();
        result = 31 * result + getCarType().hashCode();
        result = 31 * result + (perKmRate != +0.0f ? Float.floatToIntBits(perKmRate) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabId=" + cabId +
                ", carType='" + carType + '\'' +
                ", perKmRate=" + perKmRate +
                '}';
    }
}
