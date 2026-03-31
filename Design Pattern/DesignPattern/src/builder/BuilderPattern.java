package builder;

// Computer Class - Want to Build to Computer with Different Specs
class Computer {
    private final String Cpu;
    private final String Bluetooth;
    private final String GPU;
    private final int ROM;
    private final int Ram;

    // Private Constructor only Builder class can call
    private Computer(Builder builder) {
        this.Cpu = builder.Cpu;
        this.ROM = builder.ROM;
        this.Bluetooth = builder.Bluetooth;
        this.GPU = builder.GPU;
        this.Ram = builder.Ram;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Cpu='" + Cpu + '\'' +
                ", Bluetooth='" + Bluetooth + '\'' +
                ", GPU='" + GPU + '\'' +
                ", ROM=" + ROM +
                ", Ram=" + Ram +
                '}';
    }

    //  Static class as the Builder
    static class Builder {
        private String Cpu;
        private String Bluetooth;
        private String GPU;
        private int ROM;
        private int Ram;

        // Each method for different type of specs
        public Builder cpu(String cpu) {
            this.Cpu = cpu;
            return this;
        }

        public Builder gpu(String gpu) {
            this.GPU = gpu;
            return this;
        }

        public Builder bluetooth(String bluetooth) {
            this.Bluetooth = bluetooth;
            return this;
        }

        public Builder Ram(int ram) {
            this.Ram = ram;
            return this;
        }

        public Builder Rom(int rom) {
            this.ROM = rom;
            return this;
        }

        // Method to Build the computer with all the specs set
        public Computer build() {
            return new Computer(this);
        }
    }
}


public class BuilderPattern {
    public static void main(String[] args) {
        // Build different types of computer
        Computer gaming = new Computer.Builder()
                .Ram(12)
                .cpu("i9")
                .gpu("RTX 5090")
                .Rom(1)
                .bluetooth("v7")
                .build();

        System.out.println(gaming);

        // Computer without Graphics card
        Computer office = new Computer.Builder()
                .cpu("i5")
                .Ram(8)
                .Rom(512)
                .bluetooth("v5")
                .build();
        System.out.println(office);
    }
}
