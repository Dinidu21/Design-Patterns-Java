package smartHomeAutomationSystem.devices;

public class Thermostats {
    public void setTemperature(int temperature) {
        System.out.println("Nest - Setting temperature to " + temperature);
    }

    public void setMode(String mode) {
        System.out.println("Nest - Setting mode to " + mode);
    }

    public void scheduleTemperature(int temperature, String time) {
        System.out.println("Nest - Scheduling temperature " + temperature + " at " + time);
    }
}
