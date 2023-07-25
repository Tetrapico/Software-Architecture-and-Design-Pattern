// Product Interface
interface Product {
    void operation();
}

// Concrete Product A
class ConcreteProductA implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductA operation");
    }
}

// Concrete Product B
class ConcreteProductB implements Product {
    @Override
    public void operation() {
        System.out.println("ConcreteProductB operation");
    }
}

// Factory Interface
interface Factory {
    Product createProduct();
}

// Concrete Factory A
class ConcreteFactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

// Concrete Factory B
class ConcreteFactoryB implements Factory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

public class Main {
    public static void clientCode(Factory factory) {
        Product product = factory.createProduct();
        product.operation();
    }

    public static void main(String[] args) {
        Factory factoryA = new ConcreteFactoryA();
        Factory factoryB = new ConcreteFactoryB();

        clientCode(factoryA); // Output: "ConcreteProductA operation"
        clientCode(factoryB); // Output: "ConcreteProductB operation"
    }
}
