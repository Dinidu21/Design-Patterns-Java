package smartHomeAutomationSystem.devices;

public class Lights {
    public void powerOn() {
        System.out.println("Phillips Light - Turning on");
    }

    public void powerOff() {
        System.out.println("Phillips Light - Turning off");
    }

    public void setBrightness(int level) {
        System.out.println("Phillips Light - Setting brightness to " + level);
    }

    public void setColor(String color) {
        System.out.println("Phillips Light - Setting color to " + color);
    }
}
