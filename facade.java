// Subsystem: CPU
class CPU {
    public void start() {
        System.out.println("CPU is starting...");
    }

    public void shutdown() {
        System.out.println("CPU is shutting down...");
    }
}

// Subsystem: Memory
class Memory {
    public void start() {
        System.out.println("Memory is starting...");
    }

    public void shutdown() {
        System.out.println("Memory is shutting down...");
    }
}

// Subsystem: HardDisk
class HardDisk {
    public void start() {
        System.out.println("Hard Disk is starting...");
    }

    public void shutdown() {
        System.out.println("Hard Disk is shutting down...");
    }
}

// Subsystem: PowerSupply
class PowerSupply {
    public void start() {
        System.out.println("Power Supply is starting...");
    }

    public void shutdown() {
        System.out.println("Power Supply is shutting down...");
    }
}

// Facade: ComputerFacade
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDisk hardDisk;
    private PowerSupply powerSupply;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDisk = new HardDisk();
        powerSupply = new PowerSupply();
    }

    public void startComputer() {
        powerSupply.start();
        hardDisk.start();
        memory.start();
        cpu.start();
        System.out.println("Computer is now started and ready to use.");
    }

    public void shutdownComputer() {
        cpu.shutdown();
        memory.shutdown();
        hardDisk.shutdown();
        powerSupply.shutdown();
        System.out.println("Computer is now shut down.");
    }
}

public class Main {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade();

        computerFacade.startComputer(); // Output: Power Supply is starting... Hard Disk is starting... Memory is starting... CPU is starting... Computer is now started and ready to use.

        computerFacade.shutdownComputer(); // Output: CPU is shutting down... Memory is shutting down... Hard Disk is shutting down... Power Supply is shutting down... Computer is now shut down.
    }
}
