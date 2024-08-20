package commandDP;

public class Oven {
    private String name;

    public Oven(String name) {
        this.name = name;
    }
    
    public void on() {
        System.out.println(name + " Switch on ");
    }
    
    public void off() {
        System.out.println(name + " Switch off ");
    }
}

class GarageGate {
    private String description;

    public GarageGate(String description) {
        this.description = description;
    }
    
    public void open() {
        System.out.println(description + " Gate is Open ");
    }
    
    public void close() {
        System.out.println(description + " Gate is Close ");
    }
}

interface Command {
    public void execute();
}

class OvenOn implements Command {
    private Oven oven;

    public OvenOn(Oven oven) {
        super();
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.on();
    }       
}

class OvenOff implements Command {
    private Oven oven;

    public OvenOff(Oven oven) {
        super();
        this.oven = oven;
    }

    @Override
    public void execute() {
        oven.off();
    }
}

class GarageGateOpen implements Command {
    private GarageGate g;

    public GarageGateOpen(GarageGate g) {
        super();
        this.g = g;
    }

    @Override
    public void execute() {
        g.open(); 
    }    
}

class GarageGateClose implements Command {
    private GarageGate g;

    public GarageGateClose(GarageGate g) {
        super();
        this.g = g;
    }

    @Override
    public void execute() {
        g.close(); 
    }    
}

class MobileUI {
    private Command[] cmd;

    public MobileUI() {
      cmd = new Command[6];
    }

    public void setCommand(int index, Command cmdobj) {
        cmd[index] = cmdobj;
    }

    public void commandPressed(int index) {
        cmd[index].execute();
    }
}

class MainApp {
    public static void main(String[] args) {
        MobileUI mobile = new MobileUI();
        Oven mainOven = new Oven("Main Oven");
        GarageGate garageGate = new GarageGate("My new Garage");

        Command c1 = new OvenOn(mainOven);
        Command c2 = new OvenOff(mainOven);
        Command c3 = new GarageGateOpen(garageGate);
        Command c4 = new GarageGateClose(garageGate);

        mobile.setCommand(0, c1);
        mobile.setCommand(1, c2);
        mobile.setCommand(2, c3);
        mobile.setCommand(3, c4);

        mobile.commandPressed(0);
        mobile.commandPressed(1);
        mobile.commandPressed(2);
        mobile.commandPressed(3);
    }
}