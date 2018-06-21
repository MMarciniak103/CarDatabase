package controllers.modelFx;

import database.Car;
import database.CarDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.exceptions.ConverterCar;

import java.util.List;

public class CarModel {

    private ObjectProperty<CarFX> carFXObjectProperty=new SimpleObjectProperty<CarFX>(new CarFX());
    private ObservableList<String> names= FXCollections.observableArrayList();
    private ObservableList<String> brands=FXCollections.observableArrayList();



    public void init(){
        CarDao carDao=new CarDao();
        List<Car> carList=carDao.queryForAll(Car.class);
        names.clear();
        brands.clear();
        carList.forEach(car -> {
            CarFX carFX=ConverterCar.convertToCarFX(car);
            names.add(carFX.getName());
            brands.add(carFX.getBrand());
        });
    }

    public void saveCarInDatabase(){
        Car car= ConverterCar.convertToCar(this.getCarFXObjectProperty());
        CarDao carDao=new CarDao();

        carDao.createOrUpdate(car);
    }

    public CarFX getCarFXObjectProperty() {
        return carFXObjectProperty.get();
    }

    public ObservableList<String> getNames() {
        return names;
    }

    public void setNames(ObservableList<String> names) {
        this.names = names;
    }

    public ObservableList<String> getBrands() {
        return brands;
    }

    public void setBrands(ObservableList<String> brands) {
        this.brands = brands;
    }

    public ObjectProperty<CarFX> carFXObjectPropertyProperty() {
        return carFXObjectProperty;
    }

    public void setCarFXObjectProperty(CarFX carFXObjectProperty) {
        this.carFXObjectProperty.set(carFXObjectProperty);
    }
}
