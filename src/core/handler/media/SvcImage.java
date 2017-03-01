package core.handler.media;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;

import core.bricks.Article;
import psd.base.PsdImage;
import psd.layer.PsdLayer;
import ui.renderer.ArticleImagesListRenderer;

public class SvcImage {

	private PsdImage psdFile;
	private Object layers;
	private Object origRenderer;

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
	
	
	/**
	 * 
	 * @param psdFile
	 */
	public void setPsdFile(PsdImage psdFile) {
		this.psdFile = psdFile;
		
	}
}
