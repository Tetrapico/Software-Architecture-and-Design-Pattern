// Product (Complex object)
class Car {
    private String brand;
    private String model;
    private int year;
    private String color;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    // Getters and setters for the attributes (omitted for brevity)
}

// Builder (Interface for building a Car)
interface CarBuilder {
    void setBrand(String brand);
    void setModel(String model);
    void setYear(int year);
    void setColor(String color);
    Car build();
}

// ConcreteBuilder (Implements the CarBuilder interface)
class CarBuilderImpl implements CarBuilder {
    private String brand;
    private String model;
    private int year;
    private String color;

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public Car build() {
        return new Car(brand, model, year, color);
    }
}

// Director (Controls the construction process)

public class Main {
    public static void main(String[] args) {
        // Create a CarBuilder
        CarBuilder carBuilder = new CarBuilderImpl();
        carBuilder.setBrand("Toyota");
        carBuilder.setColor("red");
        carBuilder.setYear(2023);
        carBuilder.build();


        // Create a CarManufacturer with the CarBuilder



    }
}
