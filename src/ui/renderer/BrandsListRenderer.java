package ui.renderer;

import java.awt.Component;
import java.awt.Font;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import core.entities.bricks.Brand;

/**
 *
 * @author troeder
 */
public class BrandsListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 12);
        
        public static final String HTML_OPEN = "<html><body>";
        public static final String HTML_CLOSE = "</body></html>";
   
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        	Brand brand = (Brand)value;
        	String listElement;
        	
        	File imgFile = new File(".\\produkte\\medien\\bilder\\logos\\" + brand.getName() + ".jpg");
        	
        	if (imgFile.exists() && !imgFile.isDirectory())
        	{
        		listElement = HTML_OPEN + brand.getName() + HTML_CLOSE;
        	}
        	else
        	{
        		listElement = HTML_OPEN + "<span color='#ff0000'>" + brand.getName() + "</span>" + HTML_CLOSE;
        	}
        	
            return super.getListCellRendererComponent(list, listElement, index, isSelected, cellHasFocus);
        }
    }
