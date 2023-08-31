package com.cg.entities;

import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;

/*
 *Entity Class Cab
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Cab.countByCarTypeLikeIgnoreCase", query = "select count(c) from Cab c where upper(c.carType) like upper(:carType)"),
        @NamedQuery(name = "Cab.findByCabId", query = "select c from Cab c where c.cabId = :cabId"),
        @NamedQuery(name = "Cab.deleteByCabId", query = "delete from Cab c where c.cabId = :cabId")
})
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    @Column(name = "cabId")
    private Integer cabId;

    @Column(name = "carType", nullable = false)
    private String carType;

    @Column(name = "perKmRate", nullable = false)
    private float perKmRate;
/*
*No Parameterized Constructor
 */
    public Cab() {}
/*
*Parameterized Constructor
 */
    public Cab(Integer cabId, String carType, float perKmRate) {
        super();
        this.cabId = cabId;
        this.carType = carType;
        this.perKmRate = perKmRate;
    }
/*
*Getter and Setter
 */
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
