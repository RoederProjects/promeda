package ui.controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import core.entities.bricks.Article;
import core.entities.bricks.GrpArticle;
import core.entities.facilities.mysql.MySqlHandler;

public class MainViewController extends ViewController {

	private MySqlHandler mySqlHandler;
	
	public MainViewController() {
		this.mySqlHandler = new MySqlHandler();
		initArticleTree();
	}
	
	public void initArticleTree() {
	
	}
	
	/**
	 * search for results in database
	 * @param searchQuery
	 * @return
	 */
	public GrpArticle search(String searchQuery) {
	
		String[] searchResultArticles;
		GrpArticle searchResult = null;
		
		
		if (!searchQuery.matches("[0-9]{7}+")) {
			System.out.println("not a articlenumber");
		} else {
			
			//System.out.println(this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE child_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);
			
			searchResult = new GrpArticle(this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE child_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);

				searchResultArticles = this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT child_id FROM pro_product_relation WHERE parent_id = '"+searchResult.getNr()+"' ORDER BY child_id ASC;"));
				
				Article[] subSearchResult = new Article[searchResultArticles.length];
				for( int count = 0; count < searchResultArticles.length; count++ ) {
					subSearchResult[count] = new Article(searchResultArticles[count]);
				}
				searchResult.setArticles(subSearchResult);
		}
		return searchResult;
	}
	
	
	/**
	 * Generate new DefaultTreeModel
	 * @param searchResult
	 * @return
	 */
	public DefaultTreeModel updateTree( GrpArticle searchResult) {
		
		DefaultMutableTreeNode treeNode;

		DefaultMutableTreeNode treeSubNode;
		treeNode = new DefaultMutableTreeNode("Results");
		
        		treeSubNode = new DefaultMutableTreeNode(searchResult.getNr());
        		
        		for(int x = 0; x < searchResult.getArticles().length; x++) {
	        		treeSubNode.add(new DefaultMutableTreeNode(searchResult.getArticles()[x].getNr()));
        		}
        		
				treeNode.add(treeSubNode);
        	
        	DefaultTreeModel resultModel = new DefaultTreeModel(treeNode);
        	
        return resultModel;
    }
}
