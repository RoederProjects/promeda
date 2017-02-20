package core.entities.bricks;

public class Article {

	public String nr;
	public String name;
	
	public Article(String nr) {
		this.nr = nr;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
