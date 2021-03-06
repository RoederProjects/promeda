package core.service;

import javax.swing.DefaultListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import core.bricks.Article;
import core.bricks.Brand;
import core.bricks.GrpArticle;
import core.handler.MySQLHandler;
import ui.renderer.BrandsListRenderer;

public class SearchService {
	
	private boolean searchMatch;
	private String searchQuery;
	private GrpArticle searchResult;
	private MySQLHandler mySQLHandler;
	
	public SearchService() {
		searchMatch = false;
		searchQuery = "";
		searchResult = null;
		mySQLHandler = new MySQLHandler();
	}
	/************************************************************************************
	 * search for results in database													*
	 * @param searchQuery																*
	 * @return																			*
	 ************************************************************************************/
	public GrpArticle articleSearch(String searchQuery) {
	
		String[] searchResultArticles;
		GrpArticle searchResult = null;
		mySQLHandler.conCheck();
		
	// SEARCHQUERY CONTAINS 00-ARTICLE-NR
		if (searchQuery.matches("[0-9]{5}+"))
		{
			searchQuery = "00"+searchQuery;
			searchResult = new GrpArticle(this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE child_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);
			searchResultArticles = this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery("SELECT child_id FROM pro_product_relation WHERE parent_id = '"+searchResult.getNr()+"' ORDER BY child_id ASC;"));
			Article[] subSearchResult = new Article[searchResultArticles.length];
			for( int count = 0; count < searchResultArticles.length; count++ )
			{
				subSearchResult[count] = new Article(searchResultArticles[count]);
			}
			searchResult.setArticles(subSearchResult);
			this.searchMatch = true;
			this.searchQuery = searchQuery;
			this.searchResult = searchResult;
			return searchResult;
		}
		
	// SEARCHQUERY CONTAINS 0G-ARTICLE-NR
		else if(searchQuery.matches("([0-9]{5}(G|g){1})+"))
		{
			searchQuery = "0G"+searchQuery;
			searchResult = new GrpArticle(this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE parent_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);
			searchResultArticles = this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery("SELECT child_id FROM pro_product_relation WHERE parent_id = '"+searchResult.getNr()+"' ORDER BY child_id ASC;"));
			Article[] subSearchResult = new Article[searchResultArticles.length];
			for( int count = 0; count < searchResultArticles.length; count++ )
			{
				subSearchResult[count] = new Article(searchResultArticles[count]);
			}
			searchResult.setArticles(subSearchResult);
			this.searchMatch = true;
			this.searchQuery = searchQuery;
			return searchResult;
		}
		
	// SEARCHQUERY INVALID
		else
		{
			System.out.println("not a articlenumber");
			this.searchMatch = false;
			return null;
		}
	}

	/**************************************************************************************
	 * Generate new DefaultTreeModel
	 * @param (GrpArticle) searchResult
	 * @return DefaultTreeModel
	 *************************************************************************************/
	public DefaultTreeModel updateArticleTreeModel( GrpArticle searchResult) {
		
		DefaultMutableTreeNode treeNode;

		DefaultMutableTreeNode treeSubNode;
		DefaultMutableTreeNode treeSubSubNode;
		treeNode = new DefaultMutableTreeNode("Results");
		
        		treeSubNode = new DefaultMutableTreeNode(searchResult.getNr());
        		
        		for(int x = 0; x < searchResult.getArticles().length; x++) {
        			treeSubSubNode = new DefaultMutableTreeNode(searchResult.getArticles()[x].getNr());
	        		treeSubNode.add(treeSubSubNode);
        		}
        		
				treeNode.add(treeSubNode);
        	
        	DefaultTreeModel resultModel = new DefaultTreeModel(treeNode);
        	
        return resultModel;
    }


	/************************************************************************************
	 * Update ModuleTabs
	 * @return 
	 ************************************************************************************/
	public DefaultListModel<Brand> updateListBrands(String searchQuery) {
		mySQLHandler.conCheck();
		DefaultListModel<Brand> model = new DefaultListModel<Brand>();
		String sqlQuery = "SELECT brands_name FROM pro_brands WHERE brands_name LIKE '%"+ searchQuery +"%' ORDER BY brands_name ASC;";
		for (String brandName: this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery(sqlQuery)))
		{
			model.addElement(new Brand(brandName));
		}
		return model;
	}
}
