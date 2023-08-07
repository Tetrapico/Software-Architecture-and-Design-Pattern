// State Interface
interface PowerState {
    void pressPowerButton();
}

// ConcreteState: OnState
class OnState implements PowerState {
    public void pressPowerButton() {
        System.out.println("Computer is turning off.");
    }
}

// ConcreteState: OffState
class OffState implements PowerState {
    public void pressPowerButton() {
        System.out.println("Computer is turning on.");
    }
}

// ConcreteState: SleepState
class SleepState implements PowerState {
    public void pressPowerButton() {
        System.out.println("Computer is waking up.");
    }
}

// Context: Computer
class Computer {
    private PowerState state;

    public Computer() {
        state = new OffState();
    }

    public void setState(PowerState state) {
        this.state = state;
    }

    public void pressPowerButton() {
        state.pressPowerButton();
    }
}

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();

        computer.pressPowerButton(); // Output: Computer is turning on.
        computer.pressPowerButton(); // Output: Computer is waking up.

        computer.setState(new SleepState());
        computer.pressPowerButton(); // Output: Computer is turning off.
    }
}
