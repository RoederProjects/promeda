package ui.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeCellRenderer;

import ui.frames.MainView;

public class ViewController {

	private int screenWidth;
	private int screenHeight;
	
	public ViewController() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = dim.width;
		this.screenHeight = dim.height;
	}
	
    public File[] openFile() {
    	File[] files = null;
    	
    	JFileChooser fileChooser = new JFileChooser();
    	{
    		
			fileChooser.setDialogType(1);
			fileChooser.setDialogTitle("Select .psd-files to be cast");
			fileChooser.setMultiSelectionEnabled(true);
			fileChooser.setLocation(screenWidth, screenHeight);
    	}
		
    	int returnVal = fileChooser.showOpenDialog(fileChooser);
    	
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
            files = fileChooser.getSelectedFiles();
    	}
    	return files;
    } 
}