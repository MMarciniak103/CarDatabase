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



    public void init(){
        CarDao carDao=new CarDao();
        List<Car> carList=carDao.queryForAll(Car.class);
        carList.forEach(car -> {
            CarFX carFX=ConverterCar.convertToCarFX(car);
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

    public ObjectProperty<CarFX> carFXObjectPropertyProperty() {
        return carFXObjectProperty;
    }

    public void setCarFXObjectProperty(CarFX carFXObjectProperty) {
        this.carFXObjectProperty.set(carFXObjectProperty);
    }
}
