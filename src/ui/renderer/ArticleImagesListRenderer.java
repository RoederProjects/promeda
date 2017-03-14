/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author troeder
 */
public class ArticleImagesListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 12);
       
        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            Object emptyString = "";
            JLabel label = (JLabel) super.getListCellRendererComponent(
                            list, emptyString, index, isSelected, cellHasFocus);
            
            label.setBorder(new TitledBorder(null, value.toString(), TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(102, 102, 102)));
            //TitledBorder title;
            //title = BorderFactory.createTitledBorder(value.toString());
            //label.setBorder(title);
            
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setIcon(new javax.swing.ImageIcon(".\\produkte\\medien\\bilder\\100px\\" + value));
            //label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/promeda/resource/39172.jpg")));
            //label.setBackground(new java.awt.Color(102, 102, 102));
            //label.setForeground(new java.awt.Color(255, 255, 255));
            
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            
            return label;
        }
    }