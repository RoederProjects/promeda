package ui.controller;

import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

import core.handler.PSDHandler;
import core.handler.media.article.ImageHandler;
import psd.base.PsdImage;
import ui.frames.ImgWzrdView;
import ui.renderer.FilesListRenderer;

public class ImgWzrdController extends ViewController {

	private ImgWzrdView view;
	private PSDHandler psdHandler;
	
	private File[] psdFiles;
	private ArrayList<int[]> imgSizes;
	
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
		
// CARD
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
		
	// CARD 2
		view.getBtn_card2Next().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card3");
				getImgOptions();
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
		view.getBtn_card3BrowseBackupLocation().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				view.getTxtF_backupLocationPath().setText(openDirectory().getAbsolutePath());
			}
		});
		
	// CARD 4
		view.getBtn_card4Start().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card5");
			}
		});
		
		view.getBtn_card4Back().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) view.getContentPane().getLayout();
				cardLayout.show(view.getContentPane(), "card3");
			}
		});
		view.getPnl_card5().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				process();
			}
		});
	
	}
	
	public void addFiles() {
		psdFiles = openFiles();
		
		DefaultListModel<File> model;
		model = (DefaultListModel<File>) view.getList_files().getModel();
		
		for (int i=0;i<psdFiles.length;i++) {
			model.addElement(psdFiles[i]);
			try {
				PsdImage psdFiles2 = new PsdImage(psdFiles[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public void getImgOptions() {
		imgSizes = new ArrayList<int[]>();
		int[] dim;
		if (view.getChckbx_imgSizeThumb().isSelected()) {
			dim = new int[2];
			dim[0] = 100; dim[1] = 100;
			imgSizes.add(dim);
		}
		
		if (view.getChckbx_imgSizeMedium().isSelected()) {
			dim = new int[2];
			dim[0] = 378; dim[1] = 378;
			imgSizes.add(dim);
		}
		if (view.getChckbx_imgSizeLarge().isSelected()) {
			dim = new int[2];
			dim[0] = 1280; dim[1] = 1280;
			imgSizes.add(dim);
		}
	}
	
	public void process() {
		int fileCount = 0;
		for(File psdFile:psdFiles) {
			fileCount++;
			//copyFile(psdFile, new File(".\\produkte\\tmpPsdFile_"+fileCount+".psd"));
			copyFile(psdFile, new File(view.getTxtF_backupLocationPath().getText()+"\\"+psdFile.getName()));
		}
		ImageHandler imgService = new ImageHandler();
		imgService.generateJpgFromPsd(psdFiles, imgSizes, view.getLbl_test());
	}
}
