package com.cg.dto;

public class CabDto {
    private int cabId;
    private String carType;
    private float perKmRate;
    /*private boolean booked;*/

    public CabDto() {
    }


    public CabDto(int cabId, String carType, float perKmRate) {
        super();
        this.cabId = cabId;
        this.carType = carType;
        this.perKmRate = perKmRate;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
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
        if (!(o instanceof CabDto)) return false;

        CabDto cabDto = (CabDto) o;

        if (getCabId() != cabDto.getCabId()) return false;
        if (Float.compare(cabDto.getPerKmRate(), getPerKmRate()) != 0) return false;
        return getCarType() != null ? getCarType().equals(cabDto.getCarType()) : cabDto.getCarType() == null;
    }

    @Override
    public int hashCode() {
        int result = getCabId();
        result = 31 * result + (getCarType() != null ? getCarType().hashCode() : 0);
        result = 31 * result + (getPerKmRate() != +0.0f ? Float.floatToIntBits(getPerKmRate()) : 0);
        return result;
    }
}
