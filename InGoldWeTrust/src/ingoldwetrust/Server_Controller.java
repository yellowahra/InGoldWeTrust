/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingoldwetrust;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Racco
 */
public class Server_Controller {
    public Server_Controller(Connection conn, String server, MusketeersGUI gui)
    {
        try {
            conn.close();
            System.out.println("Database: Disconnected from " + server);
        } catch (SQLException ex) {
            Logger.getLogger(MusketeersGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gui.dispose();
        startUI newstart = new startUI();
        newstart.setVisible(true);
    }
}
