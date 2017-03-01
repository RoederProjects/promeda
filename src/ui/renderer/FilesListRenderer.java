package ui.renderer;

import java.awt.Component;
import java.awt.Font;
import java.io.File;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import core.bricks.Brand;

/**
 *
 * @author troeder
 */
public class FilesListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 12);
        
        public static final String HTML_OPEN = "<html><body>";
        public static final String HTML_CLOSE = "</body></html>";
   
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        	File element = (File) value;
        	String listElement = element.getName();
        	
            return super.getListCellRendererComponent(list, listElement, index, isSelected, cellHasFocus);
        }
    }
