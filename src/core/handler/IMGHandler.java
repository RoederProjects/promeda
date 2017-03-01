package core.handler;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import core.config.StaticConfig;

public class IMGHandler {
	    
	    public IMGHandler() {
	    }
	    
		public void createImages(String givenImageName, String givenImagePath, int size) {
			
	            try{
			
			BufferedImage originalImage = ImageIO.read(new File(givenImagePath));
			int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
	                
			BufferedImage resizeImageJpg = resizeImage(originalImage, type, size);
			ImageIO.write(resizeImageJpg, "jpg", new File(StaticConfig.LOCAL_MEDIA_PATH + "live\\img_products\\"+size+"px\\" + givenImageName));
				
			BufferedImage resizeImagePng = resizeImage(originalImage, type, size);
			ImageIO.write(resizeImagePng, "png", new File(StaticConfig.LOCAL_MEDIA_PATH + "live\\img_products\\"+size+"px\\" + givenImageName));
			/*	
			BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type, size);
			ImageIO.write(resizeImageHintJpg, "jpg", new File(LOCAL_MEDIA_PATH + "live\\images\\"+size+"px\\3" + givenImageName));
				
			BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type, size);
			ImageIO.write(resizeImageHintPng, "png", new File(LOCAL_MEDIA_PATH + "live\\images\\"+size+"px\\4" + givenImageName));
			*/	
	            }catch(IOException e){
			System.out.println(e.getMessage());
		}
	    }
		
	    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int size){
		BufferedImage resizedImage = new BufferedImage(size, size, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, size, size, null);
		g.dispose();
			
		return resizedImage;
	    }
		
	    private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type, int size){
			
		BufferedImage resizedImage = new BufferedImage(size, size, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, size, size, null);
		g.dispose();	
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
		RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		
		return resizedImage;
	    }	
	

}
