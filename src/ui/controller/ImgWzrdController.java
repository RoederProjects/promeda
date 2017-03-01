package ui.controller;

import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import core.config.StaticConfig;
import core.handler.PSDHandler;
import ui.frames.ImgWzrdView;
import ui.renderer.FilesListRenderer;

public class ImgWzrdController extends ViewController {

	private ImgWzrdView view;
	private PSDHandler psdHandler;
	public ImgWzrdController() {
		view = new ImgWzrdView();
		view.setVisible(true);
		compCustomSetup();
		addActions();
	}
	
	public void compCustomSetup() {
		DefaultListModel<File> model = new DefaultListModel<File>();
		view.getList_files().setModel(model);
		view.getList_files().setCellRenderer(new FilesListRenderer());
	}
	
	public void addActions() {
		
		view.getBtn_selectFiles().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addFiles();
			}
		});
		view.getBtn_removeFiles().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeFiles();
			}
		});
		view.getBtn_clearFilesList().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearList();
			}
		});
		
// CARD - STEPPING
	// CARD 1
		view.getBtn_card1Next().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card2");
			}
		});
		view.getBtn_card1Cancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.dispose();
			}
		});
	// CARD 2
		view.getBtn_card2Next().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card3");
			}
		});
		view.getBtn_card2Back().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card1");
			}
		});
	// CARD 3
		view.getBtn_card3Next().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card4");
			}
		});
		view.getBtn_card3Back().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card2");
			}
		});
	// CARD 4
		view.getBtn_card4Start().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card5");
				//ProcessBuilder pb = new ProcessBuilder("converted", "-format ", "jpg ", psdafterconvpath, psdpath + "\\" + "*.psd");
				//ProcessBuilder pb = new ProcessBuilder("convert", "-format", "-jpg", "D:\\Benutzer\\Bilder\\","D:\\Benutzer\\Dokumente" + "\\" + "64033_20140808.psd");
				//ProcessBuilder pb = new ProcessBuilder("convert", " -format ", "jpg ",".\\produkte\\Bilder\\"," .\\produkte\\64033_20140808.psd");
				ProcessBuilder pb = new ProcessBuilder("converted", "-format ", "jpg ", ".\\produkte\\Bilder\\", ".\\produkte\\64033_20140808.psd");
		        pb.redirectErrorStream(true);
		        try {
					Process p = pb.start();
				} catch (IOException e) {
					e.printStackTrace();
				}
		        
		        psdHandler = new PSDHandler();
			   	psdHandler.read("D:\\Benutzer\\Dokumente" + "\\" + "64033_20140808.psd");
			   	int n = psdHandler.getFrameCount();
			   	for (int i = 0; i < n; i++) {
		   	    BufferedImage image = psdHandler.getLayer(i);
		   	    Point offset = psdHandler.getLayerOffset(i);
		   	    // do something with image
		   	    view.getLbl_test().setIcon(new ImageIcon(image));
		   	    try {
		   	    	
		   			int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
		   			BufferedImage resizedImage = new BufferedImage(300, 300, type);
		   			Graphics2D g = resizedImage.createGraphics();
		   			g.drawImage(image, 0, 0, 300, 300, null);
		   			g.dispose();
					//ImageIO.write(image, "jpg", new File(".\\produkte\\Bilder\\"));
		   	    	ImageIO.write(resizedImage, "jpg", new File(".\\produkte\\Bilder2\\"));
		   	    	
				} catch (IOException e) {
					e.printStackTrace();
				}
		   	  }
		       
			}
		});
		view.getBtn_card4Back().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card3");
			}
		});
	
	}
	
	public void addFiles() {
		File[] psdFiles = openFile();
		
		//DefaultListModel<File> model = new DefaultListModel<File>();
		DefaultListModel<File> model;
		model = (DefaultListModel<File>) view.getList_files().getModel();
		
		for (int i=0;i<psdFiles.length;i++) {
			model.addElement(psdFiles[i]);
		}
		
		
		
		
	}
	
	public void removeFiles() {
		DefaultListModel<File> model = (DefaultListModel<File>) view.getList_files().getModel();
		model.removeElementAt(view.getList_files().getSelectedIndex());
	}
	
	public void clearList() {
		DefaultListModel<File> model = (DefaultListModel<File>) view.getList_files().getModel();
		model.clear();
	}
}
