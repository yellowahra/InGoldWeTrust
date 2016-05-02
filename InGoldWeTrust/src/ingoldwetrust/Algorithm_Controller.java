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
public class Algorithm_Controller {
    Statement st = null;
    ResultSet rs = null;
    double Alpha_A = 6.0;
    double Alpha_B = 2.0;
    
    public Algorithm_Controller(Connection conn, String item, JTable table)
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
        ResultSet tables = dbm.getTables(null, null, "item" + id, null);
        if (tables.next()) {
            st = conn.createStatement();
            rs = st.executeQuery("select * from item" + id);
            table.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        else { 
            JOptionPane.showMessageDialog(null,"Item is not Auctionable in World of Warcraft.");
        }
    }
    public double ApplyA(int i,String item, double alpha) throws FileNotFoundException, IOException
    {
    	return Estimate(i, item, alpha);
    }
    public double Estimate(int i, String item, double alpha)
    {
    	//need to make burst(index) call the price history of the item. i should be the index of the price
    	//we are attempting to predict, in which the algorithm will recursively go down the price history starting
    	//with the most recent till zero
    	if(i != 0){
    	return alpha * burst[ i -1 ] + ( 1.0 - alpha ) * Estimate( i -1, item, alpha );
    	}
    	if (i == 0)
    	{
    		return 0;
    	}
    	
    }
}

