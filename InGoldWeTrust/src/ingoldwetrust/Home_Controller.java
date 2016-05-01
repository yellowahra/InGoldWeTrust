/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingoldwetrust;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Racco
 */
public class Home_Controller {
    Connection db;
    String item_name;
    ResultSet rs = null, rs1 = null, rs2 = null;
    PreparedStatement ps = null, ps1 = null, ps2 = null; 
    
    public Home_Controller(Connection conn, int choice,JTable table)
    {
        DecimalFormat df = new DecimalFormat("0.000");
        try {
            db = conn;
            if (choice == 1)
            {
                try {
                    ps = db.prepareStatement("SELECT itemid FROM a_rise_fall ORDER BY diff DESC LIMIT 10");
                    rs = ps.executeQuery();
                    
                    ps1 = db.prepareStatement("SELECT diff FROM a_rise_fall ORDER BY diff DESC LIMIT 10");
                    rs1 = ps1.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(Home_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (choice == 2)
            {
                try {
                    ps = db.prepareStatement("SELECT itemid FROM a_rise_fall ORDER BY diff ASC LIMIT 10");
                    rs = ps.executeQuery();
                    
                    ps1 = db.prepareStatement("SELECT diff FROM a_rise_fall ORDER BY diff ASC LIMIT 10");
                    rs1 = ps1.executeQuery();
                } catch (SQLException ex) {
                    Logger.getLogger(Home_Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                return;
            
            int r = 0;
            while(rs.next() && rs1.next()) {
                int item_id = rs.getInt("itemid");
                item_name = "Newer WoW Item";
                
                try {
                    Document doc = Jsoup.connect("http://www.wowhead.com/item=" + item_id).get();
                    for (Element m : doc.getElementsByTag("meta")) {
                        if ("og:title".equals(m.attr("property")))
                            item_name = m.attr("content");
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
                
                int diff = rs1.getInt("diff");
                
                ps2 = db.prepareStatement("SELECT bid FROM a_cmp0 WHERE itemid = " + item_id);
                rs2 = ps2.executeQuery();
                rs2.next();
                
                double price = rs2.getInt("bid");
                
                String x = df.format(diff/price);
                System.out.println(diff + " " + price);
                
                table.setValueAt(item_name, r, 0);
                table.setValueAt(diff, r, 1);
                table.setValueAt(x, r, 2);
                r++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
