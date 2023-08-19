package org.example;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class CarShop {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner input = new Scanner(System.in);

        List<Vehicle> database = new ArrayList<>();
        Hashtable<Character, Grade> grades = new Hashtable<>();
        Hashtable<String, BrandTotal> stocks = new Hashtable<>();



        Grade A = new Grade("Excellent", "Very slightly used, virtually as good as new.");
        Grade B = new Grade( "Good", "Good condition but with visible flaws.");
        Grade C = new Grade("Average", "Average condition, with minor damage.");
        Grade D = new Grade( "Poor", "Poor condition with significant damage, but the car is functional.");
        grades.put('A', A);
        grades.put('B', B);
        grades.put('C', C);
        grades.put('D', D);
        int carCount = 0;

        boolean quit = false;
        do {
            System.out.println( "  " );
            System.out.println("Welcome. What would you like to do?");
            System.out.println("1. Input a car");
            System.out.println("2. See all cars, sorted by model(alphabetically)");
            System.out.println("3. See all cars, sorted by price(low to high");
            System.out.println("4. Find the car with the lowest mileage");
            System.out.println("5. Find the car with the lowest price");
            System.out.println("6. Find car by ID");
            System.out.println("7. See all manufacturers and their total cars and total price");
            System.out.println("8. Quit");
            int id;
            int choice=0;
//            if (!input.hasNextInt()) {
//                System.out.println("try again");
//                continue;
//            } else {
//                int here = input.nextInt();
//                if (here>0 && here<9){
//                    choice = here;
//                } else {
//                    continue;
//                }
//            }
            boolean flag = false;
//            do {
//                flag = false;
//                if (!input.hasNextInt()) {
//                    System.out.println("try again");
//                    continue;
//                } else {
//                    int here = input.nextInt();
//                    if (here>0 && here<9){
//                        choice = here;
//                        flag = true;
//                        break;
//                    } else {
//                        System.out.println("Please choose a valid choice");
//                        continue;
//                    }
//                }
//            } while (!flag);


            do {
                String here1 = input.next();
                try {
                    int x = Integer.parseInt(here1);
                    if (x > 0 && x < 10){
                        choice = x;
                        flag = true;
                        break;
                    }
                } catch (IllegalArgumentException e){
                    System.out.println("invalid choice");
//                    input.next();
                }
            } while (!flag);

            switch (choice) {
                case 1:
                    Vehicle car = new Vehicle();

                    String manufacturer;
                    String model;
                    int year;
                    double mileage;
                    double size;
                    char grade;
                    double price;

                    boolean dataValidation = false;
//                    System.out.println("Please input the id of the car");
//                    do {
//                        if (input.hasNextInt()) {
//                            id = input.nextInt();
//                            dataValidation = true;
//                        } else {
//                            System.out.println("Please give a valid id number");
//                            dataValidation = false;
//                            input.next();
//                        }
//                    } while (!dataValidation);
                    carCount++;
                    car.setId(carCount);

                    System.out.println("Please input the manufacturer of the car");
                    while (true) {
                        String input3 = input.next();
                        if (!input.hasNextLine()) {
                            System.out.println("Input something");
                            continue;
                        } else {
                            car.setManufacturer(input3);
                            break;
                        }
                    }


                    System.out.println("What is the model?");
                    while (true) {
                        String input3 = input.next();
                        if (!input.hasNextLine()) {
                            System.out.println("Input something");
                            continue;
                        } else {
                            car.setModel(input3);
                            break;
                        }
                    }


                    System.out.println("What is the year?");
                    boolean yearBol = false;
                    do {
                        String here1 = input.next();
                        try {
                            int x = Integer.parseInt(here1);
                            if (x > 0){
                                car.setYear(x);
                                yearBol = true;
                                break;
                            } else {
                                System.out.println("invalid year");
                                continue;
                            }
                        } catch (IllegalArgumentException e){
                            System.out.println("invalid year");
                        }
                    } while (!yearBol);

                    System.out.println("What is the mileage?");
                    boolean mileageBol = false;
                    do {
                        String here1 = input.next();
                        try {
                            Float x = Float.parseFloat(here1);
                            if (x >= 0){
                                car.setMileage(x);
                                mileageBol = true;
                                break;
                            } else {
                                System.out.println("invalid year");
                                continue;
                            }
                        } catch (IllegalArgumentException e){
                            System.out.println("invalid mileage");
                        }
                    } while (!mileageBol);

                    System.out.println("What is the engine size in liters");
                    boolean litersBol = false;
                    do {
                        String here1 = input.next();
                        try {
                            Float x = Float.parseFloat(here1);
                            if (x >= 0){
                                car.setMileage(x);
                                litersBol = true;
                                break;
                            } else {
                                System.out.println("invalid liters");
                                continue;
                            }
                        } catch (IllegalArgumentException e){
                            System.out.println("invalid liters");
                        }
                    } while (!litersBol);

                    System.out.println("What is the grade?");
                    boolean gradeBol = false;
                    do {
                        String here1 = input.next();
                        try {
                            if (here1.length()==1){
                                char gradeChar = here1.charAt(0);
                                if ((gradeChar >= 'a' && gradeChar <= 'd') || (gradeChar >= 'A' && gradeChar <= 'D')){
                                    car.setGrade(Character.toUpperCase(gradeChar));
                                    gradeBol = true;
                                    break;
                                }
                            } else {
                                System.out.println("invalid grade");
                                continue;
                            }
                        } catch (IllegalArgumentException e){
                            System.out.println("invalid grade");
                        }
                    } while (!gradeBol);

                    System.out.println("What is the price?");
                    boolean priceBol = false;
                    do {
                        String here1 = input.next();
                        try {
                            Float x = Float.parseFloat(here1);
                            if (x >= 0){
                                car.setPrice(x);
                                litersBol = true;
                                break;
                            } else {
                                System.out.println("invalid price");
                                continue;
                            }
                        } catch (IllegalArgumentException e){
                            System.out.println("invalid price");
                        }
                    } while (!priceBol);


                    System.out.println("Car manufacturer is " + car.getManufacturer());
                    System.out.println("Car model is " + car.getModel());
                    System.out.println("Car year is " + car.getYear());
                    System.out.println("Car mileage is " + car.getMileage());
                    System.out.println("Car engine size is " + car.getEngineSize());
                    System.out.println("Car grade is " + car.getGrade());
                    System.out.println("Car price is " + car.getPrice());

                    database.add(car);

                    break;

                case 2:
                    System.out.println("Option 2 called");
                    Collections.sort(database);

                    System.out.println("ID   Manufacturer   Model   Year   Mileage    EngineSize   Grade    Price");
                    for (Vehicle something : database) {
                        System.out.println(something.toString());
                    }
                    break;

                case 3:
                    System.out.println("Option 3 called");
                    System.out.println("ID   Manufacturer   Model   Year   Mileage    EngineSize   Grade    Price");
                    Collections.sort(database, new VehiclePriceComparator());
                    for (Vehicle something : database) {
                        System.out.println(something.toString());
                    }
                    break;

                case 4:
                    Collections.sort(database, new EngineComparator());
                    System.out.println(database.get(0));
                    break;

                case 5:
                    Collections.sort(database, new VehiclePriceComparator());
                    System.out.println(database.get(0));
                    break;

                case 6:
                    System.out.println("Please provide ID");
                    boolean dataValidation2 = false;
                    int givenID = 0;
                    do {
                        if (input.hasNextInt()) {
                            givenID = input.nextInt();
                            dataValidation2 = true;
                        } else {
                            System.out.println("Please give a valid id number");
                            dataValidation2 = false;
                            input.next();
                        }
                    } while (!dataValidation2);
                    Vehicle foundCar = database.get(givenID-1);
                    char foundGrade = foundCar.getGrade();
                    String found3 = grades.get(foundGrade).getCondition();
                    System.out.println("ID   Manufacturer   Model   Year   Mileage    EngineSize   Grade    Price");
                    System.out.println(foundCar.getId() + "      " + foundCar.getManufacturer()  + "          " +  foundCar.getModel() + "      " +  foundCar.getYear()  + "   " +  foundCar.getMileage()  + "      " +  foundCar.getEngineSize()  + "      " +  found3  + "  " +  foundCar.getPrice());
//                    System.out.println(foundCondition);
                    break;

                case 7:
                    for (Vehicle carIter:database){
                        if (!stocks.containsKey(carIter.getManufacturer())){
                            BrandTotal brand = new BrandTotal(carIter.getManufacturer(), 1,carIter.getPrice());
                            stocks.put(carIter.getManufacturer(), brand);
                        } else {
                            stocks.get(carIter.getManufacturer()).addQuantity(1);
                            stocks.get(carIter.getManufacturer()).addStock(carIter.getPrice());
                        }
                    }

                    Set<String> setOfKeys = stocks.keySet();
                    int count = 1;
                    System.out.println("ID          Manufacturer           Total number of vehicles available for sale        Stock Price");
//                    stocks.forEach((key, value)
//                            -> System.out.println(
//                              key
//                                     + value));

                    for (String manufact: setOfKeys){
                        String here = stocks.get(manufact).toString();
//                        System.out.println(here);
                        System.out.println(" "+ count + "  " +  here);
                        count++;
                    }
                    break;


                case 8:
                    System.out.println("Pleasure working with you");
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid, please try again");
                    input.next();

            }

        } while (!quit) ;
    }

    public static class BrandTotal {
        private String name;
        private double quantity;
        private double stocktotal;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getQuantity() {
            return quantity;
        }

        public void addQuantity(double quantity){
            this.quantity = this.quantity + quantity;
        }

        public void addStock(double stock){
            this.stocktotal = this.stocktotal + stock;
        }


        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public double getStocktotal() {
            return stocktotal;
        }

        public void setStocktotal(double stocktotal) {
            this.stocktotal = stocktotal;
        }

        public BrandTotal(String name, double quantity, double stocktotal) {
            this.name = name;
            this.quantity = quantity;
            this.stocktotal = stocktotal;
        }

        @Override
        public String toString(){
//            System.out.print(this.getName()+ "  " + this.getQuantity() + "   " + this.getStocktotal());
            return "           " + this.getName()+ "                                  " + this.getQuantity() + "                                 " + this.getStocktotal();
        }
    }

    public static class Grade {

        private String condition;
        private String description;



        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Grade( String condition, String description) {

            this.condition = condition;
            this.description = description;
        }

        //        public String getConditionFromGrade(char grade){ return }
    }

    public static class Vehicle implements Comparable<Vehicle> {

        private int id;
        private String manufacturer;
        private String model;

        private int year;
        private double mileage;
        private double engineSize;
        private char grade;
        private double price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public double getMileage() {
            return mileage;
        }

        public void setMileage(double mileage) {
            this.mileage = mileage;
        }

        public double getEngineSize() {
            return engineSize;
        }

        public void setEngineSize(double engineSize) {
            this.engineSize = engineSize;
        }

        public char getGrade() {
            return grade;
        }

        public void setGrade(char grade) {
            this.grade = grade;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public Vehicle() {
        }

        public Vehicle(int id, String manufacturer, String model, int year, double mileage, double engineSize, char grade, double price) {
            this.id = id;
            this.manufacturer = manufacturer;
            this.model = model;
            this.year = year;
            this.mileage = mileage;
            this.engineSize = engineSize;
            this.grade = grade;
            this.price = price;
        }

        @Override
        public String toString() {
            return this.id + "        " + this.manufacturer + "         " + this.model + "      " + this.year + "   " + this.mileage + "     " + this.engineSize+"L" + "     " + this.grade + "   " + "$"+this.price;
        }

        @Override
        public int compareTo(Vehicle car) {
            return model.compareTo(car.manufacturer);
        }


//        public int compareToPrice(Vehicle car, Vehicle car2) { return car.getModel().compareTo(car2.getPrice())}
    }

    public static class VehiclePriceComparator implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle car1, Vehicle car2) {
            return (int) (car1.getPrice() - car2.getPrice());
        }
    }

    public static class EngineComparator implements Comparator<Vehicle> {
        @Override
        public int compare(Vehicle car1, Vehicle car2) {
            return (int) (car1.getEngineSize() - car2.getEngineSize());
        }
    }

}
