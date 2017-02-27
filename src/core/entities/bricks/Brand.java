package core.entities.bricks;

import java.io.File;

public class Brand {
	
	private String name;
	private File logoFile;
	
	public Brand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(File logoFile) {
		this.logoFile = logoFile;
	}

}
