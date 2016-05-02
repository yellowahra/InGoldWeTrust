/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingoldwetrust;

import javax.swing.JTextArea;

/**
 *
 * @author Racco
 */
public class Help_Controller {
    public Help_Controller(JTextArea panel, int choice)
    {
        if (choice == 1)
        {
            panel.setText("The Home button gives you four options to view ten items under the most\npopular settings." 
                + "\n\nRising: View which items are currently rising in price."
                + "\nFalling: View which items are currently falling in price."
                + "\nMost Sold: View which items are being sold the most."
                + "\nLeast Sold: View which items are being sold the least." );
        }
        else if (choice == 2)
        {
            panel.setText("The Search button lets the user look up items in out database. If the item does"
                + "\nnot show up, then that means the item either doesn't exist or hasn't been sold"
                + "\nin the auction house for that server within 24 hours. You can choose to look"
                + "\nup the item through the combo box or through the search bar. The information"
                + "\nfor the item will show up in the table." );
        }
        else if (choice == 3)
        {
            panel.setText("Under construction.");
        }
        else
        {
            panel.setText("Under construction.");
        }
    }
}
