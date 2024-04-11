package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidCapacityException;
import pl.kurs.watercontainers.exceptions.InvalidLevelException;
import pl.kurs.watercontainers.exceptions.InvalidWaterAmountException;

import java.io.InvalidClassException;
import java.io.Serializable;
import java.util.Objects;


public class WaterContainer implements Serializable {
    static final long serialVersionUID = 1L;

    private final String name;
    private final double maxCapacity;
    private double waterLevel;

    private WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public static WaterContainer create(String name, double maxCapacity, double waterLevel) {
        if (maxCapacity <= 0) {
            throw new InvalidCapacityException("Max Capacity should be more than 0!");
        }
        if (waterLevel < 0 || waterLevel > maxCapacity) {
            throw new InvalidLevelException("Invalid water level value!");
        }
        return new WaterContainer(name, maxCapacity, waterLevel);
    }

    public void addWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should be more than 0!!");
        }
        if ((waterLevel + value) > maxCapacity) {
            throw new InvalidWaterAmountException("Too much water to add to " + name + "!!");
        }
        waterLevel += value;

    }

    public void pourOutWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should be more than 0!!");
        }
        if ((waterLevel - value) < 0) {
            throw new InvalidWaterAmountException("Too much water to pur out from " + name + "!");
        }
        waterLevel -= value;
    }

    public void pourWater(WaterContainer destinationContainer, double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should be more than 0!!");
        }
        this.pourOutWater(value);
        destinationContainer.addWater(value);
    }

    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(that.maxCapacity, maxCapacity) == 0 && Double.compare(that.waterLevel, waterLevel) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }
}
