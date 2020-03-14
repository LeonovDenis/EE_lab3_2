/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;


/**
 *
 * @author ann
 */
@Stateful
public class EJB implements EJBDemo {

    private static boolean isregistred = false;
    private static int count = 0;
    private Properties properties;

    @Override
    public boolean login(String login, String psw) {
        return false;
    }

    @Override
    public String getMessage(String login) {
        return "Test";
    }

    @PostConstruct
    private void init() {
        try (InputStream is
                = getClass().getClassLoader()
                        .getResourceAsStream("prop/properties.properties");) {
                    properties.load(is);
                    System.out.println("!!!!!!!!!!!!!!\n");
                    System.out.println(properties.toString());
                    System.out.println("!!!!!!!!!!!!!!\n");
                } catch (IOException ex) {
                    Logger.getLogger(EJB.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    }
