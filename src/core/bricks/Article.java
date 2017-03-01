package core.bricks;

import core.handler.MySQLHandler;

public class Article {
	private String nr;
	private String name;
	
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

	public String interrogateArticleName() {
		MySQLHandler dbHandler = new MySQLHandler();
		String sqlQuery = "SELECT attribute_value FROM pro_attribute_value WHERE product_id = "+this.nr+" AND attribute_value = 10;";
		String[] name = dbHandler.sqlArrayListToStringArray(dbHandler.sqlExecuteQuery(sqlQuery));
		setName(name[0]);
		return name[0];
	}
}
