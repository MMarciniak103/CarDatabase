package controllers.modelFx;

import database.Car;
import database.CarDao;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import utils.exceptions.ConverterCar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarListModel {

    private ObservableList<CarFX> carFXObservableList= FXCollections.observableArrayList();
    private ObservableList<String> carName=FXCollections.observableArrayList();
    private ObservableList<String> carBrand=FXCollections.observableArrayList();
    private ObservableList<Number> carMpg=FXCollections.observableArrayList();
    private ObservableList<Number> carCylinders= FXCollections.observableArrayList();
    private ObservableList<Number> carHorsepower=FXCollections.observableArrayList();
    private ObservableList<Number> carWeight=FXCollections.observableArrayList();
    private ObservableList<Number> carAcceleration=FXCollections.observableArrayList();
    private ObservableList<Number> carYear=FXCollections.observableArrayList();
    private ObservableList<Number> carOrigin= FXCollections.observableArrayList();

    private ObjectProperty<String> carNameObject =new SimpleObjectProperty<>();
    private ObjectProperty<String> carBrandObject =new SimpleObjectProperty<>();
    private ObjectProperty<Number> carMpgObjet =new SimpleObjectProperty<>();
    private ObjectProperty<Number> carCylindersObject =new SimpleObjectProperty<>();
    private ObjectProperty<Number> carHorsepowerObject=new SimpleObjectProperty<>();
    private ObjectProperty<Number> carWeightObject=new SimpleObjectProperty<>();
    private ObjectProperty<Number> carAccelerationObject=new SimpleObjectProperty<>();
    private ObjectProperty<Number> carYearObject=new SimpleObjectProperty<>();
    private ObjectProperty<Number> carOriginObject=new SimpleObjectProperty<>();

    private List<CarFX> carFXList=new ArrayList<>();
    private List<Predicate<CarFX>> predicates=new ArrayList<>();

    public void init(){
        CarDao carDao=new CarDao();
        List<Car> cars=carDao.queryForAll(Car.class);
        carFXList.clear();
        cars.forEach(c->{
            this.carFXList.add(ConverterCar.convertToCarFX(c));
        });

        this.carFXObservableList.setAll(carFXList);
        initParameters();
    }


    private void initParameters(){
        CarDao carDao=new CarDao();
        List<Car> carList=carDao.queryForAll(Car.class);
        clearLists();
        fillCarLists(carList);
        sortCarLists();
    }

    private void sortCarLists() {
        this.carName.sort(null);
        this.carBrand.sort(null);
        this.carMpg.sort(null);
        this.carCylinders.sort(null);
        this.carHorsepower.sort(null);
        this.carWeight.sort(null);
        this.carAcceleration.sort(null);
        this.carYear.sort(null);
        this.carOrigin.sort(null);
    }

    private void fillCarLists(List<Car> carList) {
        carList.forEach(car -> {
            if(!carName.contains(ConverterCar.convertToCarFX(car).getName())){
            this.carName.add(ConverterCar.convertToCarFX(car).getName() );}
            if(!carBrand.contains(ConverterCar.convertToCarFX(car ).getBrand())){
            this.carBrand.add(ConverterCar.convertToCarFX(car ).getBrand());}
            if(!carMpg.contains(ConverterCar.convertToCarFX(car).getMpg())){
            this.carMpg.add(ConverterCar.convertToCarFX(car).getMpg() );
            }
            if(!carCylinders.contains(ConverterCar.convertToCarFX(car).getCylinders())){
                this.carCylinders.add(ConverterCar.convertToCarFX(car).getCylinders() );
            }
            if(!carHorsepower.contains(ConverterCar.convertToCarFX(car).getHorsepower())){
                this.carHorsepower.add(ConverterCar.convertToCarFX(car).getHorsepower() );
            }
            if(!carWeight.contains(ConverterCar.convertToCarFX(car).getWeight())){
                this.carWeight.add(ConverterCar.convertToCarFX(car).getWeight() );
            }
            if(!carAcceleration.contains(ConverterCar.convertToCarFX(car).getAcceleration())){
                this.carAcceleration.add(ConverterCar.convertToCarFX(car).getAcceleration() );
            }
            if(!carYear.contains(ConverterCar.convertToCarFX(car).getYear())){
                this.carYear.add(ConverterCar.convertToCarFX(car).getYear() );
            }
            if(!carOrigin.contains(ConverterCar.convertToCarFX(car).getOrigin())){
                this.carOrigin.add(ConverterCar.convertToCarFX(car).getOrigin() );
            }

        });
    }

    private void clearLists() {
        this.carName.clear();
        this.carBrand.clear();
        this.carMpg.clear();
        this.carCylinders.clear();
        this.carHorsepower.clear();
        this.carWeight.clear();
        this.carAcceleration.clear();
        this.carYear.clear();
        this.carOrigin.clear();
    }

    public void filterCarList(){
        predicates.clear();
        fillPredicates();
        if(predicates.size()!=0){
            if(predicates.size()==1){
                filterPredicate(predicates.get(0));
            }
            else if(predicates.size()==2){
                filterPredicate(predicates.get(0).and(predicates.get(1)));
            }
            else if(predicates.size()==3){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2))));
            }
            else if(predicates.size()==4){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3))));
            }
            else if(predicates.size()==5){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3)))
                .and(predicates.get(4)));
            }
            else if(predicates.size()==6){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3)))
                        .and(predicates.get(4)).and(predicates.get(5)));
            }
            else if(predicates.size()==7){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3)))
                        .and(predicates.get(4)).and(predicates.get(5)).and(predicates.get(6)));
            }
            else if(predicates.size()==8){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3)))
                        .and(predicates.get(4)).and(predicates.get(5)).and(predicates.get(6)).and(predicates.get(7)));
            }
            else if(predicates.size()==9){
                filterPredicate(predicates.get(0).and(predicates.get(1).and(predicates.get(2)).and(predicates.get(3)))
                        .and(predicates.get(4)).and(predicates.get(5)).and(predicates.get(6)).and(predicates.get(7))
                .and(predicates.get(8)));
            }
        }else{
            this.carFXObservableList.setAll(this.carFXList);
        }

    }
    private void fillPredicates(){
        if(getCarNameObject()!=null){
            predicates.add(predicateName());
        }
        if(getCarBrandObject()!=null){
            predicates.add(predicateBrand());
        }
        if(getCarMpgObjet()!=null){
            predicates.add(predicateMpg());
        }
        if(getCarCylindersObject()!=null){
            predicates.add(predicateCylinders());
        }
        if(getCarHorsepowerObject()!=null){
            predicates.add(predicateHorsepower());
        }
        if(getCarWeightObject()!=null){
            predicates.add(predicateWeight());
        }
        if(getCarAccelerationObject()!=null){
            predicates.add(predicateAcceleration());
        }
        if(getCarYearObject()!=null){
            predicates.add(predicateYear());
        }
        if(getCarOriginObject()!=null){
            predicates.add(predicateOrigin());
        }

    }

    public void deleteCar(CarFX carFX)  {
        CarDao carDao=new CarDao();
        carDao.deleteById(Car.class,carFX.getId() );
        init();
    }


    public void filterPredicate(Predicate<CarFX>predicate){
        List<CarFX> newList=carFXList.stream().filter(predicate).collect(Collectors.toList());
        this.carFXObservableList.setAll(newList);
    }

    private Predicate<CarFX> predicateOrigin(){
        return carFX -> carFX.getOrigin()==getCarOriginObject().intValue();
    }

    private Predicate<CarFX> predicateYear(){
        return carFX -> carFX.getYear()==getCarYearObject().intValue();
    }

    private Predicate<CarFX> predicateAcceleration(){
        return carFX -> carFX.getAcceleration()==getCarAccelerationObject().doubleValue();
    }

    private Predicate<CarFX> predicateWeight(){
        return carFX -> carFX.getWeight()==getCarWeightObject().intValue();
    }

    private Predicate<CarFX> predicateHorsepower(){
        return carFX -> carFX.getHorsepower()==getCarHorsepowerObject().intValue();
    }

    private Predicate<CarFX> predicateCylinders(){
        return carFX -> carFX.getCylinders()==getCarCylindersObject().intValue();
    }

    private Predicate<CarFX> predicateMpg(){
        return carFX -> carFX.getMpg()== getCarMpgObjet().doubleValue();
    }

    private Predicate<CarFX> predicateBrand(){
        return carFX -> carFX.getBrand().equals(getCarBrandObject());
    }

    private Predicate<CarFX> predicateName(){
        return carFX -> carFX.getName().equals(getCarNameObject());
    }

    public ObservableList<CarFX> getCarFXObservableList() {
        return carFXObservableList;
    }

    public void setCarFXObservableList(ObservableList<CarFX> carFXObservableList) {
        this.carFXObservableList = carFXObservableList;
    }

    public List<CarFX> getCarFXList() {
        return carFXList;
    }

    public ObservableList<Number> getCarOrigin() {
        return carOrigin;
    }

    public void setCarOrigin(ObservableList<Number> carOrigin) {
        this.carOrigin = carOrigin;
    }

    public Number getCarOriginObject() {
        return carOriginObject.get();
    }

    public ObjectProperty<Number> carOriginObjectProperty() {
        return carOriginObject;
    }

    public void setCarOriginObject(Number carOriginObject) {
        this.carOriginObject.set(carOriginObject);
    }

    public String getCarNameObject() {
        return carNameObject.get();
    }

    public ObjectProperty<String> carNameObjectProperty() {
        return carNameObject;
    }

    public void setCarNameObject(String carNameObject) {
        this.carNameObject.set(carNameObject);
    }

    public void setCarFXList(List<CarFX> carFXList) {
        this.carFXList = carFXList;
    }


    public ObservableList<String> getCarName() {
        return carName;
    }

    public void setCarName(ObservableList<String> carName) {
        this.carName = carName;
    }

    public ObservableList<String> getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(ObservableList<String> carBrand) {
        this.carBrand = carBrand;
    }

    public ObservableList<Number> getCarCylinders() {
        return carCylinders;
    }

    public Number getCarCylindersObject() {
        return carCylindersObject.get();
    }

    public void setCarCylinders(ObservableList<Number> carCylinders) {
        this.carCylinders = carCylinders;
    }

    public ObjectProperty<Number> carCylindersObjectProperty() {
        return carCylindersObject;
    }

    public void setCarCylindersObject(Number carCylindersObject) {
        this.carCylindersObject.set(carCylindersObject);
    }



    public List<Predicate<CarFX>> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<Predicate<CarFX>> predicates) {
        this.predicates = predicates;
    }

    public String getCarBrandObject() {
        return carBrandObject.get();
    }

    public ObjectProperty<String> carBrandObjectProperty() {
        return carBrandObject;
    }

    public void setCarBrandObject(String carBrandObject) {
        this.carBrandObject.set(carBrandObject);
    }

    public ObservableList<Number> getCarMpg() {
        return carMpg;
    }

    public ObservableList<Number> getCarAcceleration() {
        return carAcceleration;
    }

    public void setCarAcceleration(ObservableList<Number> carAcceleration) {
        this.carAcceleration = carAcceleration;
    }

    public Number getCarAccelerationObject() {
        return carAccelerationObject.get();
    }

    public ObjectProperty<Number> carAccelerationObjectProperty() {
        return carAccelerationObject;
    }

    public void setCarAccelerationObject(Number carAccelerationObject) {
        this.carAccelerationObject.set(carAccelerationObject);
    }

    public ObservableList<Number> getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(ObservableList<Number> carWeight) {
        this.carWeight = carWeight;
    }

    public Number getCarWeightObject() {
        return carWeightObject.get();
    }

    public ObjectProperty<Number> carWeightObjectProperty() {
        return carWeightObject;
    }

    public void setCarWeightObject(Number carWeightObject) {
        this.carWeightObject.set(carWeightObject);
    }

    public void setCarMpg(ObservableList<Number> carMpg) {
        this.carMpg = carMpg;
    }

    public Number getCarMpgObjet() {
        return carMpgObjet.get();
    }

    public ObjectProperty<Number> carMpgObjetProperty() {
        return carMpgObjet;
    }

    public void setCarMpgObjet(Number carMpgObjet) {
        this.carMpgObjet.set(carMpgObjet);
    }

    public ObservableList<Number> getCarHorsepower() {
        return carHorsepower;
    }

    public void setCarHorsepower(ObservableList<Number> carHorsepower) {
        this.carHorsepower = carHorsepower;
    }

    public Number getCarHorsepowerObject() {
        return carHorsepowerObject.get();
    }

    public ObjectProperty<Number> carHorsepowerObjectProperty() {
        return carHorsepowerObject;
    }

    public void setCarHorsepowerObject(Number carHorsepowerObject) {
        this.carHorsepowerObject.set(carHorsepowerObject);
    }

    public ObservableList<Number> getCarYear() {
        return carYear;
    }

    public void setCarYear(ObservableList<Number> carYear) {
        this.carYear = carYear;
    }

    public Number getCarYearObject() {
        return carYearObject.get();
    }

    public ObjectProperty<Number> carYearObjectProperty() {
        return carYearObject;
    }

    public void setCarYearObject(Number carYearObject) {
        this.carYearObject.set(carYearObject);
    }
}
