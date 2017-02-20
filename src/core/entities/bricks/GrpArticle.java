package core.entities.bricks;

public class GrpArticle {
	
	private String nr;
	private String name;
	private Article[] articles;
	
	public GrpArticle(String nr) {
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

	public Article[] getArticles() {
		return articles;
	}

	public void setArticles(Article[] articles) {
		this.articles = articles;
	}
}
