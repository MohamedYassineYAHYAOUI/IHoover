package yanport.controller;

import javax.swing.*;

public class IHoover {

    /***
     * Main function, application access point
     * load application config from "resources/config.properties" and initialize the main window Frame
     * @param args
     */
    public static void main(String[] args) {
        var config = new HooverConfig("resources/config.properties");
        config.loadConfig();
        JFrame frame = new JFrame(config.getAppName());
        var mainFrame = new MainFrame(config);
        mainFrame.initFrame(frame);
    }
}
