A// Existing Legacy Printer
class LegacyPrinter {
    public void printOld() {
        System.out.println("Printing using old method");
    }
}

// New Modern Printer
class ModernPrinter {
    public void printNew() {
        System.out.println("Printing using new method");
    }
}

// Adapter to make ModernPrinter compatible with LegacyPrinter
class PrinterAdapter extends LegacyPrinter {
    private ModernPrinter modernPrinter;

    public PrinterAdapter(ModernPrinter modernPrinter) {
        this.modernPrinter = modernPrinter;
    }

    @Override
    public void printOld() {
        modernPrinter.printNew();
    }
}

public class Main {
    public static void main(String[] args) {
        // Existing Legacy Printer
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        legacyPrinter.printOld(); // Output: "Printing using old method"

        // New Modern Printer
        ModernPrinter modernPrinter = new ModernPrinter();
        modernPrinter.printNew(); // Output: "Printing using new method"

        // Adapter to make Modern Printer compatible with Legacy Printer
        PrinterAdapter printerAdapter = new PrinterAdapter(modernPrinter);
        printerAdapter.printOld(); // Output: "Printing using new method"
    }
}
