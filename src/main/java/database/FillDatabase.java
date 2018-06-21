package database;

import com.j256.ormlite.stmt.query.In;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FillDatabase {
    private static ArrayList<Double> mpg=new ArrayList<>();
    private static ArrayList<Integer> cylinders=new ArrayList<>();
    private static ArrayList<Double> displacement=new ArrayList<>();
    private static ArrayList<Integer> horsepower=new ArrayList<>();
    private static ArrayList<Integer> weight=new ArrayList<>();
    private static ArrayList<Double> acceleration=new ArrayList<>();
    private static ArrayList<Integer> year=new ArrayList<>();
    private static ArrayList<Integer> origin=new ArrayList<>();
    private static ArrayList<String> brand=new ArrayList<>();
    private static ArrayList<String> name=new ArrayList<>();
    private static ArrayList<Car> cars=new ArrayList<>();

    public static void fillDatabase() throws IOException {

        readData();
        fillCars();
        CarDao carDao=new CarDao();

        for(int i=0;i<cars.size();i++){
            carDao.createOrUpdate(cars.get(i));
        }

        DbManager.closeConnectionSource();
        }

    private static void fillCars() {
        for(int i=0;i<name.size();i++){
            Car car=new Car();
            car.setMpg(mpg.get(i));
            car.setCylinders(cylinders.get(i));
            car.setDisplacement(displacement.get(i));
            car.setHorsepower(horsepower.get(i));
            car.setWeight(weight.get(i));
            car.setAcceleration(acceleration.get(i));
            car.setYear(year.get(i));
            car.setOrigin(origin.get(i));
            car.setBrand(brand.get(i));
            car.setName(name.get(i));
            cars.add(car);
        }
    }

    private static void readData() throws IOException {
        FileReader fr=null;
        String line="";
        try {
            fr=new FileReader("cars.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br=new BufferedReader(fr);
        while ((line=br.readLine())!=null){
            String[] tokens=line.split(",");
            String mpg1=tokens[0];
            String cylinder1=tokens[1];
            String displacement1=tokens[2];
            String horsepower1=tokens[3];
            String weight1=tokens[4];
            String acceleration1=tokens[5];
            String year1=tokens[6];
            String origin1=tokens[7];
            String[] bnames=tokens[8].split(" ");
            String brand1=bnames[0];
            StringBuilder sb=new StringBuilder();
            sb.append(tokens[8].substring(bnames[0].length()));
            String name1=sb.toString();
            mpg.add(Double.parseDouble(mpg1));
            cylinders.add(Integer.parseInt(cylinder1));
            displacement.add(Double.parseDouble(displacement1));
            horsepower.add(Integer.parseInt(horsepower1));
            weight.add(Integer.parseInt(weight1));
            acceleration.add(Double.parseDouble(acceleration1));
            year.add(Integer.parseInt(year1));
            origin.add(Integer.parseInt(origin1));
            brand.add(brand1);
            name.add(name1);

        }
        br.close();
        fr.close();

    }


}



