package yanport.controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class for loading the application config
 */
public class HooverConfig {
    static private final Logger logger = Logger.getLogger(HooverConfig.class.getName());
    private Dimension appDimension; // application dimensions Width x Height in pixel
    private String appName; // main frame window name
    private final String configPath; // configuration file path
    private int gridMargin; // application margin


    /**
     * constructor for the HooverConfig class
     * @param configPath String of the configuration file path
     */
    public HooverConfig(String configPath){
        this.configPath = Objects.requireNonNull(configPath);
    }

    /**
     * load the application configuration from the configPath
     * parameters to be parsed : windowHeight - WindowWidth - GridMargin - windowName
     */
    public void loadConfig(){
        if(appDimension != null && appName != null){
            throw new IllegalStateException("Config already loaded");
        }
        try (var input = new FileInputStream(configPath)) {
            Properties prop = new Properties();
            prop.load(input);
            var windowHeight = Integer.parseInt(prop.getProperty("windowHeight"));
            var windowWidth =  Integer.parseInt(prop.getProperty("WindowWidth"));
            gridMargin =  Integer.parseInt(prop.getProperty("GridMargin"));
            appDimension = new Dimension(windowWidth, windowHeight);
            appName = prop.getProperty("windowName");
        } catch (IOException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            return;
        }
    }

    /**
     * getter the application Dimensions,
     * if the methode loadConfig() wasn't called before, this methode throws an ISE
     * @return Dimension of the application from the configuration file
     */
    public Dimension getAppDimension() {
        if(appDimension == null){
            throw new IllegalStateException("didn't load config");
        }
        return appDimension;
    }

    /**
     * getter the application window name,
     * if the methode loadConfig() wasn't called before, this methode throws an ISE
     * @return String of the name of the application as in the configuration file
     */
    public String getAppName() {
        if(appName == null){
            throw new IllegalStateException("didn't load config");
        }
        return appName;
    }

    /**
     * getter the application grid margin
     * @return int the grid margin
     */
    public int gridMargin(){ return gridMargin;}

}
