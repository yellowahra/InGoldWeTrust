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
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Racco
 */
public class Search_Controller {
    Statement st = null;
    ResultSet rs = null;
    
    public Search_Controller(Connection conn, String item, JTable table)
    {
        String id;
        try {
            id = checkItem(item);
            if (id.matches("xxx"))
                JOptionPane.showMessageDialog(null,"Item does not exist in World of Warcraft.");
            else
                fillTable(conn, id, table);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String checkItem(String item) throws FileNotFoundException, IOException
    {
        String splitBy = ",";
        BufferedReader br = new BufferedReader(new FileReader("Items.csv"));
        String line;
        while((line = br.readLine()) != null){
            String[] itemDetails = line.split(splitBy);
            if (itemDetails[4].equalsIgnoreCase(item))
            {
                br.close();
                return itemDetails[0];
            }
        }
        br.close();
        return "xxx";
    }
    
    public void fillTable(Connection conn, String id, JTable table) throws SQLException
    {
        DatabaseMetaData dbm = conn.getMetaData();
        // check if "employee" table is there
        ResultSet tables = dbm.getTables(null, null, "item" + id, null);
        if (tables.next()) {
            st = conn.createStatement();
            rs = st.executeQuery("select * from item" + id);
            table.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        else { //Stormcloth Pants
            JOptionPane.showMessageDialog(null,"Item is not Auctionable in World of Warcraft.");
        }
        
        
    }
}

