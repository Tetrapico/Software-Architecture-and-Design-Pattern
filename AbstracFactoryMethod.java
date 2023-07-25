// Abstract Product A
interface ProductA {
    void operationA();
}

// Concrete Product A1
class ConcreteProductA1 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("ConcreteProductA1 operation");
    }
}

// Concrete Product A2
class ConcreteProductA2 implements ProductA {
    @Override
    public void operationA() {
        System.out.println("ConcreteProductA2 operation");
    }
}

// Abstract Product B
interface ProductB {
    void operationB();
}

// Concrete Product B1
class ConcreteProductB1 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("ConcreteProductB1 operation");
    }
}

// Concrete Product B2
class ConcreteProductB2 implements ProductB {
    @Override
    public void operationB() {
        System.out.println("ConcreteProductB2 operation");
    }
}

// Abstract Factory
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create Concrete Factory 1
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();

        productA1.operationA(); // Output: "ConcreteProductA1 operation"
        productB1.operationB(); // Output: "ConcreteProductB1 operation"

        // Create Concrete Factory 2
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();

        productA2.operationA(); // Output: "ConcreteProductA2 operation"
        productB2.operationB(); // Output: "ConcreteProductB2 operation"
    }
}
