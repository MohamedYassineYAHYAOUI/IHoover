package yanport.controller;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HooverConfig {
    static private final Logger logger = Logger.getLogger(HooverConfig.class.getName());
    private Dimension appDimension;
    private String appName;
    private final String configPath;
    private int gridMargin;


    public HooverConfig(String configPath){
        this.configPath = Objects.requireNonNull(configPath);
    }

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

    public Dimension getAppDimension() {
        if(appDimension == null){
            throw new IllegalStateException("didn't load config");
        }
        return appDimension;
    }

    public String getAppName() {
        if(appName == null){
            throw new IllegalStateException("didn't load config");
        }
        return appName;
    }

    public int gridMargin(){ return gridMargin;}

}
