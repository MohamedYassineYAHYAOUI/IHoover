package yanport.controller;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IHoover {
    static private final Logger logger = Logger.getLogger(IHoover.class.getName());

    public static void main(String[] args) {
        var config = new HooverConfig("resources/config.properties");
        config.loadConfig();
        JFrame frame = new JFrame(config.getAppName());
        var mainFrame = new MainFrame(config);
        mainFrame.initFrame(frame);

    }
}
