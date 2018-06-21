package database;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "CARS")
public class Car  {
    public Car() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "MPG" )
    private double mpg;

    @DatabaseField(columnName = "CYLINDERS")
    private int cylinders;

    @DatabaseField(columnName = "DISPLACEMENT")
    private double displacement;

    @DatabaseField(columnName = "HORSEPOWER")
    private int horsepower;

    @DatabaseField(columnName = "WEIGHT")
    private int weight;

    @DatabaseField(columnName = "ACCELERATION")
    private double acceleration;

    @DatabaseField(columnName = "YEAR")
    private int year;

    @DatabaseField(columnName = "ORIGIN")
    private int origin;

    @DatabaseField(columnName = "BRAND", canBeNull = false)
    private String brand;

    @DatabaseField(columnName = "NAME",canBeNull = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOrigin() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
