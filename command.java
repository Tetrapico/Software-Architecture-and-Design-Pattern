// Command Interface
interface Command {
    void execute();
}

// Concrete Command
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Receiver
class Light {
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println(location + " light is ON");
    }

    public void turnOff() {
        System.out.println(location + " light is OFF");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        // Create the Receiver (Light)
        Light livingRoomLight = new Light("Living Room");

        // Create the Concrete Command (LightOnCommand) with the Receiver
        Command livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);

        // Create the Invoker (RemoteControl) and set the Command
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(livingRoomLightOnCommand);

        // Client presses the button to execute the Command
        remoteControl.pressButton(); // Output: "Living Room light is ON"
    }
}
