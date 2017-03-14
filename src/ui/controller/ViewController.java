package ui.controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultTreeCellRenderer;

import org.apache.commons.io.FileUtils;

import ui.frames.MainView;

public class ViewController {

	private int screenWidth;
	private int screenHeight;
	
	public ViewController() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.screenWidth = dim.width;
		this.screenHeight = dim.height;
	}
	
    public File[] openFiles() {
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
    
    public File openDirectory() {
    	File file = null;
    	
    	JFileChooser fileChooser = new JFileChooser();
    	{
    		
			fileChooser.setDialogType(1);
			fileChooser.setDialogTitle("Select .psd-files to be cast");
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setLocation(screenWidth, screenHeight);
    	}
		
    	int returnVal = fileChooser.showOpenDialog(fileChooser);
    	
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
    	}
    	return file;
    }
    
    public void copyFile(File srcFile, File destFile) {
    	 try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}