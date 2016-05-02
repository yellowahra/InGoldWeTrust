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
                + "\n\nIf there are less than 10 items that are rising or falling in price,\nonly the"
                + "items affected will appear in the table.");
        }
        else if (choice == 2)
        {
            panel.setText("The Search button lets the user look up items in out database. If the item does"
                + "\nnot show up, then that means the item either doesn't exist or hasn't been sold"
                + "\nin the auction house for that server within the 2 weeks. You can choose to"
                + "\nlook up the item through the search bar. The prices for the item will show"
                + "\nup in the table. Additional item information is included via the WoWHead"
                + "\nwebsite.");
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
