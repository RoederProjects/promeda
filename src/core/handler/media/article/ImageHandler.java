package core.handler.media.article;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.ResampleOp;

import core.bricks.Article;
import core.handler.PSDHandler;
import ui.renderer.ArticleImagesListRenderer;

public class ImageHandler {
	/**
	 * Sets the actual ArticleImage to ImageViewport
	 * @param selectedNode
	 * @param lbl_imgViewport
	 */
	public void fillImgViewport(DefaultMutableTreeNode selectedNode, JLabel lbl_imgViewport) {
		if (selectedNode == null) return;

		Object nodeInfo = selectedNode.getUserObject();
        String selectedArticleNr = nodeInfo.toString();
       
        URL url = null;
        
		try {
			url = new URL("http://www.promondo.de/$WS/promondo/websale8_shop-promondo/produkte/medien/bilder/378px/"+selectedArticleNr.substring(2)+".jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        lbl_imgViewport.setIcon(new ImageIcon(url));
	}
	
	/**
	 * 
	 * @param selectedNode
	 * @param list_articleThumbs
	 */
	public void fillArticleThumbsList(DefaultMutableTreeNode selectedNode, JList list_articleThumbs) {
		final DefaultListModel model = new DefaultListModel();
		if (selectedNode == null) return;

		Object nodeInfo = selectedNode.getUserObject();
        String selectedArticleNr = nodeInfo.toString();
        
        
        File imgFile = new File(".\\produkte\\medien\\bilder\\100px\\" + selectedArticleNr.substring(2) + ".jpg");
        int imgCount = 1;
        do {
        	model.addElement(imgFile.getName());
            String imgNr = selectedArticleNr.substring(2) + "_" + (imgCount);
            imgFile = new File(".\\produkte\\medien\\bilder\\100px\\" + imgNr + ".jpg" );
            imgCount++;   
        } while(imgFile.exists() && !imgFile.isDirectory());
        
        list_articleThumbs.setModel(model);
        list_articleThumbs.setCellRenderer(new ArticleImagesListRenderer());
        
	}
	
	public void generateJpgFromPsd(File[] psdFiles, ArrayList<int[]> imgSizes, JLabel progressLabel) {
		
		PSDHandler psdHandler = new PSDHandler();
		int stepSize = (int) psdFiles.length * imgSizes.size();
		int progressState = 0;
		for (File file:psdFiles) {
		   	psdHandler.read("D:\\Benutzer\\Dokumente\\"+file.getName());
		   	System.out.println(file.getPath());
		   	int n = psdHandler.getFrameCount();
		   	System.out.println(n);
	   	    BufferedImage image = psdHandler.getLayer(n-1);
	   	    BufferedImage image2 = psdHandler.getImage();
	   	 
	   	    for(int sizeIndex = 0; sizeIndex < imgSizes.size(); sizeIndex++) {
	   	    	progressLabel.repaint();
	   	    	System.out.println(imgSizes.size());
	   	    	System.out.println(imgSizes.get(sizeIndex)[0] + imgSizes.get(sizeIndex)[1]);
	   	    	ResampleOp resampleOp = new ResampleOp (imgSizes.get(sizeIndex)[0],imgSizes.get(sizeIndex)[1]);
	   	    	resampleOp.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Soft);
	   	    	//System.out.println(image2.getWidth());
	   	    	int type = image2.getType() == 0? BufferedImage.TYPE_INT_ARGB : image2.getType();
	   	    	
	   	    	//BufferedImage rescaledTomato = resampleOp.filter(image, new BufferedImage(imgSizes.get(sizeIndex)[0], imgSizes.get(sizeIndex)[1], type));
	   	    	BufferedImage rescaledTomato2 = resampleOp.filter(image2, new BufferedImage(imgSizes.get(sizeIndex)[0], imgSizes.get(sizeIndex)[1], type));
	   	    	progressState+=stepSize;
	   	    	progressLabel.setText(progressState+" %");
   	    	
	   	    	try {
					//ImageIO.write(rescaledTomato, "png", new File("D:\\Benutzer\\Dokumente\\Bilder_"+sizeIndex+".jpg"));
					ImageIO.write(rescaledTomato2, "png", new File("J:\\Individuelles\\Timo\\Bilder_"+sizeIndex+".jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
	   	     	
		   	}
		}
       
	}
}
