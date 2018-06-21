package controllers.modelFx;

import com.j256.ormlite.stmt.query.In;
import javafx.beans.property.*;

public class CarFX  {

    private IntegerProperty id=new SimpleIntegerProperty();
    private DoubleProperty mpg=new SimpleDoubleProperty();
    private IntegerProperty cylinders=new SimpleIntegerProperty();
    private DoubleProperty displacements=new SimpleDoubleProperty();
    private IntegerProperty horsepower=new SimpleIntegerProperty();
    private IntegerProperty weight=new SimpleIntegerProperty();
    private DoubleProperty acceleration=new SimpleDoubleProperty();
    private IntegerProperty year=new SimpleIntegerProperty();
    private IntegerProperty origin=new SimpleIntegerProperty();
    private SimpleStringProperty brand=new SimpleStringProperty();
    private SimpleStringProperty name=new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getMpg() {
        return mpg.get();
    }

    public DoubleProperty mpgProperty() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg.set(mpg);
    }

    public void setMpg(int mpg) {
        this.mpg.set(mpg);
    }

    public int getCylinders() {
        return cylinders.get();
    }

    public IntegerProperty cylindersProperty() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders.set(cylinders);
    }

    public double getDisplacements() {
        return displacements.get();
    }

    public DoubleProperty displacementsProperty() {
        return displacements;
    }

    public void setDisplacements(double displacements) {
        this.displacements.set(displacements);
    }

    public int getHorsepower() {
        return horsepower.get();
    }

    public IntegerProperty horsepowerProperty() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower.set(horsepower);
    }

    public int getWeight() {
        return weight.get();
    }

    public IntegerProperty weightProperty() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight.set(weight);
    }

    public double getAcceleration() {
        return acceleration.get();
    }

    public DoubleProperty accelerationProperty() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration.set(acceleration);
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public int getOrigin() {
        return origin.get();
    }

    public IntegerProperty originProperty() {
        return origin;
    }

    public void setOrigin(int origin) {
        this.origin.set(origin);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
