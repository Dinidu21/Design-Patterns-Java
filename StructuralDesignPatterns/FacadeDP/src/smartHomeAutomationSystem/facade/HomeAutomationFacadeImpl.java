package smartHomeAutomationSystem.facade;

import smartHomeAutomationSystem.devices.SecurityCameras;
import smartHomeAutomationSystem.devices.Lights;
import smartHomeAutomationSystem.devices.SmartLocks;
import smartHomeAutomationSystem.devices.Thermostats;


public class HomeAutomationFacadeImpl implements HomeAutomationFacade {
    private final Lights lights;
    private final SecurityCameras securityCameras;
    private final SmartLocks smartLocks;
    private final Thermostats thermostats;

    public HomeAutomationFacadeImpl() {
        this.securityCameras = new SecurityCameras();
        this.smartLocks = new SmartLocks();
        this.thermostats = new Thermostats();
        this.lights = new Lights();
    }

    @Override
    public void turnOnLights() {
        lights.powerOn();
        lights.setBrightness(30);
        lights.setColor("white");
    }

    @Override
    public void turnOffLights() {
        lights.powerOff();
    }

    @Override
    public void setEveningMode() {
        System.out.println("Setting Evening Mode...");
        lights.powerOn();
        lights.setBrightness(100);
        lights.setColor("warm white");
        thermostats.setTemperature(70);
        securityCameras.startRecording();
        securityCameras.enableMotionDetection();
        smartLocks.lock();
    }

    @Override
    public void setAwayMode() {
        System.out.println("Setting Away Mode...");
        lights.powerOff();
        thermostats.setMode("eco");
        securityCameras.enableMotionDetection();
        securityCameras.startRecording();
        smartLocks.getStatus();
        smartLocks.lock();
        thermostats.scheduleTemperature(80, "10:00");
    }

    @Override
    public void setHomeMode() {
        System.out.println("Setting Home Mode...");
        lights.powerOn();
        thermostats.setMode("eco");
        thermostats.setTemperature(40);
        securityCameras.disableMotionDetection();
        securityCameras.stopRecording();
        smartLocks.unlock();
    }
}
