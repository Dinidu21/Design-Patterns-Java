package smartHomeAutomationSystem;

import smartHomeAutomationSystem.facade.HomeAutomationFacade;
import smartHomeAutomationSystem.facade.HomeAutomationFacadeImpl;

public class MobileApp {
    public static void main(String[] args) {
        HomeAutomationFacade facade = new HomeAutomationFacadeImpl();
        facade.turnOnLights();
        facade.setEveningMode();
        facade.turnOffLights();
        facade.setAwayMode();
        facade.turnOnLights();
        facade.setHomeMode();
        facade.turnOffLights();
    }
}
