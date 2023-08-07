// Handler Interface
interface Handler {
    void handleRequest(int amount);
}

// Concrete Handlers
class Manager implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(int amount) {
        if (amount <= 1000) {
            System.out.println("Manager handles the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}

class Director implements Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(int amount) {
        if (amount <= 5000) {
            System.out.println("Director handles the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}

class CEO implements Handler {
    public void handleRequest(int amount) {
        System.out.println("CEO handles the request.");
    }
}

public class Main {
    public static void main(String[] args) {
        Handler manager = new Manager();
        Handler director = new Director();
        Handler ceo = new CEO();

        manager.setNextHandler(director);
        director.setNextHandler(ceo);

        // Client sends a request to the chain
        int amount = 3000;
        manager.handleRequest(amount);
    }
}
