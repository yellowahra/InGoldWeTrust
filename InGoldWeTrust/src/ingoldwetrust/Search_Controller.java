/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingoldwetrust;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.Callback;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import com.teamdev.jxbrowser.chromium.swing.internal.LightWeightWidget;
 
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;

/**
 *
 * @author Racco
 */
public class Search_Controller {
    Statement st = null;
    ResultSet rs = null;
    
    public Search_Controller(Connection conn, String item, JTable table, JLabel imgLabel, JLabel itemPicInfo)
    {
        String id;
        try {
            item = item.replace(" ", "+");
            id = checkItem(item);
            if (id.matches("xxx"))
                JOptionPane.showMessageDialog(null,"Item does not exist in World of Warcraft.");
            else
            {
                fillTable(conn, id, table, imgLabel);
                getInfo(id, itemPicInfo);
            }
                
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
        String itemid = null;
        Document doc = Jsoup.connect("http://www.wowdb.com/items?filter-search=" + item).timeout(30000).userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").get();
        
        for (Element m : doc.getElementsByTag("a")) {
            if ("listing-icon".equals(m.attr("class")))
                itemid = m.attr("href");
        }
        
        if (itemid == null)
            return "xxx";
        
        itemid = itemid.replaceAll("http://www.wowdb.com/items/", "");
        int index = itemid.indexOf("-");
        itemid = itemid.substring(0, index);

        return itemid;
    }
    
    public void fillTable(Connection conn, String id, JTable table, JLabel iconLabel) throws SQLException
    {
        DatabaseMetaData dbm = conn.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "item" + id, null);
        if (tables.next()) {
            st = conn.createStatement();
            rs = st.executeQuery("select * from item" + id);
            table.setModel(DbUtils.resultSetToTableModel(rs));  
        }
        else { 
            JOptionPane.showMessageDialog(null, "Item is not Auctionable in World of Warcraft.");
            return;
        }
        showImage(id, iconLabel);
    }
    
    public void showImage(String itemID, JLabel iconLabel) {
        try {
            Document doc = Jsoup.connect("http://www.wowhead.com/item=" + itemID).userAgent("Mozilla").get();
            String path = null;
            
            for (Element m : doc.getElementsByTag("meta")) {
                if ("og:image".equals(m.attr("property")))
                    path = "http:" + m.attr("content");
            }

            System.out.println("Get Image from " + path);
            URL url = new URL(path);
            BufferedImage image = ImageIO.read(url);
            iconLabel.setIcon(new ImageIcon(image));
            
            
        } catch (IOException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getInfo(String itemID, JLabel itemPicInfo) {
        try {
            Browser browser = new Browser(BrowserType.LIGHTWEIGHT);
            BrowserView view = new BrowserView(browser);

            browser.setSize(1280, 1024);

            Thread.sleep(500);

            Browser.invokeAndWaitFinishLoadingMainFrame(browser, new Callback<Browser>() {
                @Override
                public void invoke(Browser browser) {
                    browser.loadURL("http://www.wowhead.com/item=" + itemID);
                }
            });

            Thread.sleep(500);

            LightWeightWidget lightWeightWidget = (LightWeightWidget) view.getComponent(0);
            Image webimage = lightWeightWidget.getImage();
            ImageIO.write((RenderedImage) webimage, "PNG", new File("info.png"));

            browser.dispose();
            
            Process p = Runtime.getRuntime().exec("python immark.py");
            Thread.sleep(500);
            
            BufferedImage img = ImageIO.read(new File("crop.png"));
            itemPicInfo.setIcon(new ImageIcon(img));
            itemPicInfo.setHorizontalAlignment(JLabel.CENTER);
            itemPicInfo.setHorizontalTextPosition(JLabel.LEFT);
            
            p.destroy();
        } catch (InterruptedException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Search_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

