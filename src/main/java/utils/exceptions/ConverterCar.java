package utils.exceptions;

import controllers.modelFx.CarFX;
import database.Car;

public class ConverterCar {

    public static Car convertToCar(CarFX carFX){
        Car car=new Car();
        car.setId(carFX.getId());
        car.setMpg(carFX.getMpg());
        car.setCylinders(carFX.getCylinders());
        car.setDisplacement(carFX.getDisplacements());
        car.setHorsepower(carFX.getHorsepower());
        car.setWeight(carFX.getWeight());
        car.setAcceleration(carFX.getAcceleration());
        car.setYear(carFX.getYear());
        car.setOrigin(carFX.getOrigin());
        car.setBrand(carFX.getBrand());
        car.setName(carFX.getName());
        return car;
    }

    public static CarFX convertToCarFX(Car car){
        CarFX carFX=new CarFX();
        carFX.setId(car.getId());
        carFX.setMpg(car.getMpg());
        carFX.setCylinders(car.getCylinders());
        carFX.setDisplacements(car.getDisplacement());
        carFX.setHorsepower(car.getHorsepower());
        carFX.setWeight(car.getWeight());
        carFX.setAcceleration(car.getAcceleration());
        carFX.setYear(car.getYear());
        carFX.setOrigin(car.getOrigin());
        carFX.setBrand(car.getBrand());
        carFX.setName(car.getName());
        return carFX;

    }

}
