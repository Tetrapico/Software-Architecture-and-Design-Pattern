// Memento: Represents the state to be stored
class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Originator: Object whose state needs to be saved and restored
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    // Create a memento to save the current state
    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    // Restore the state from a memento
    public void restoreStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// CareTaker: Manages the Memento objects
class CareTaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }
}

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        // Set and save the initial state
        originator.setState("State 1");
        careTaker.saveMemento(originator.saveStateToMemento());

        // Change the state and save again
        originator.setState("State 2");
        careTaker.saveMemento(originator.saveStateToMemento());

        // Change the state again, but this time we can restore the previous state
        originator.setState("State 3");
        System.out.println("Current State: " + originator.getState());

        // Restore to the previous state
        originator.restoreStateFromMemento(careTaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}
