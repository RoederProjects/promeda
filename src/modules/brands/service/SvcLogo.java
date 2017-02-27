package modules.brands.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import core.entities.bricks.Brand;

public class SvcLogo {

	/**
	 * Sets the actual ArticleImage to ImageViewport
	 * @param selectedNode
	 * @param lbl_imgViewport
	 */
	public void fillLogoViewport(Object selectedBrand, JLabel lbl_logoViewport) {
		if (selectedBrand == null) return;
		
		
		Brand brand = (Brand) selectedBrand;
        URL url = null;
        
		try {
			url = new URL("http://www.promondo.de/$WS/promondo/websale8_shop-promondo/produkte/medien/bilder/logos/"+brand.getName()+".jpg");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        lbl_logoViewport.setIcon(new ImageIcon(url));
	}
}
