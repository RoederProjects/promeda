package ui.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import core.entities.bricks.Article;
import core.entities.bricks.Brand;
import core.entities.bricks.GrpArticle;
import core.entities.facilities.mysql.MySqlHandler;
import modules.brands.service.SvcLogo;
import modules.products.service.*;
import ui.frames.MainView;
import ui.frames.MainView2;
import ui.renderer.ArticleImagesListRenderer;
import ui.renderer.BrandsListRenderer;

public class MainController extends ViewController {

// GENERAL OBJECTS
	// GUI
	private MainView2 mainView;
	// DB
	private MySqlHandler mySqlHandler;
	// MEDIA-SERVICES
	private SvcImage svcImage;
	private SvcVideo svcVideo;
	private SvcLabel svcLabel;
	private SvcAttachment svcAttachment;
	private SvcLogo svcLogo;
	
// SEARCH-FIELDS
	private boolean searchMatch;
	private String searchQuery;
	private GrpArticle searchResult;
	private DefaultMutableTreeNode selectedTreeNode;
	private SvcSearch svcSearch;

// BOARDS-FIELDS
	private String activePanel;
	
	
	
	/************************************************************************************
	 * Constructor - Inits the media-services of products-module 						*
	 ************************************************************************************/
	public MainController() {
		this.mySqlHandler = new MySqlHandler();
		this.mainView = new MainView2();
		mainView.setVisible(true);
		svcImage = new SvcImage();
		svcVideo = new SvcVideo();
		svcLabel = new SvcLabel();
		svcAttachment = new SvcAttachment();
		svcLogo = new SvcLogo();
		
		svcSearch = new SvcSearch();
		this.searchMatch = false;
		this.searchQuery = "";
		
		this.activePanel = "articles";
		compCustomSetup();
		addActions();
	}
	
	/************************************************************************************
	 * Customize JComponents, which cannot be made with WindowBuilder					*
	 ************************************************************************************/
	public void compCustomSetup() {
		DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) mainView.getTree_entities().getCellRenderer();
		render.setOpenIcon(new ImageIcon("./src/res/icons/v2/icon_0G.png"));
		render.setClosedIcon(new ImageIcon("./src/res/icons/v2/icon_0G.png"));
		render.setLeafIcon(new ImageIcon("./src/res/icons/v2/icon_00.png"));
		mainView.getTree_entities().setCellRenderer(render);
		
		mainView.getBtnGrp_adminpanels().add(mainView.getRdbtnmntm_adminpanelArticles());
		mainView.getBtnGrp_adminpanels().add(mainView.getRdbtnmntm_adminpanelBrands());
	}
	
	/**
	 * Adds any Action-/Selectionlistener to gui-components of initialized JFrame 'mainView'
	 */
	public void addActions() {
		
		/** SEARCH via ButtonClick
		 * case "articles"
		 * case "brands"
		 */
		mainView.getBtnNewButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(activePanel) {
				case "articles":
					updateArticleTree(mainView.getTree_entities(), mainView.getTxtf_searchField().getText());
					mainView.getTabbedPane_treeNodeMediaModules().setEnabled(false);
					break;
				case "brands":
					updateBrandList(mainView.getTxtf_searchField().getText());
					break;
				}
			}
		});
		
		/** SEARCH via EnterKey
		 * case "articles"
		 * case "brands"
		 */
		mainView.getTxtf_searchField().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(activePanel) {
				case "articles":
					updateArticleTree(mainView.getTree_entities(), mainView.getTxtf_searchField().getText());
					mainView.getTabbedPane_treeNodeMediaModules().setEnabled(false);
					break;
				case "brands":
					svcSearch.updateListBrands(mainView.getTxtf_searchField().getText());
					break;
				}
			}
		});
		mainView.getRdbtnmntm_adminpanelBrands().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) mainView.getPnl_contentWrap().getLayout();
				cardLayout.show(mainView.getPnl_contentWrap(), "card_brandsBoard");
				activePanel = "brands";
				mainView.getTxtf_searchField().setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(44, 124, 90), 2)));
				initListBrands();
			}
		});
		mainView.getRdbtnmntm_adminpanelArticles().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cardLayout = (CardLayout) mainView.getPnl_contentWrap().getLayout();
				cardLayout.show(mainView.getPnl_contentWrap(), "card_articlesBoard");
				activePanel = "articles";
				mainView.getTxtf_searchField().setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(51, 204, 255), 2)));
			}
		});
		mainView.getTree_entities().addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent arg0) {
				updateProductService((DefaultMutableTreeNode) mainView.getTree_entities().getLastSelectedPathComponent());
				mainView.getTabbedPane_treeNodeMediaModules().setEnabled(true);
			}
		});
		
		mainView.getList_brands().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateBrandService(mainView.getList_brands().getSelectedValue());
			}
		});
	}
	
	public boolean isSearchMatch() {
		return searchMatch;
	}

	public void setSearchMatch(boolean searchMatch) {
		this.searchMatch = searchMatch;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public DefaultMutableTreeNode getSelectedTreeNode() {
		return selectedTreeNode;
	}

	public void setSelectedTreeNode(DefaultMutableTreeNode selectedTreeNode) {
		this.selectedTreeNode = selectedTreeNode;
	}

	
	/****************************************************************************************
	 * search for results in database	
	 * @param searchQuery				
	 * @return							
	 ****************************************************************************************/
	/*public GrpArticle search(String searchQuery) {
	
		String[] searchResultArticles;
		GrpArticle searchResult = null;
		
	// SEARCHQUERY CONTAINS 00-ARTICLE-NR
		if (searchQuery.matches("[0-9]{5}+"))
		{
			searchQuery = "00"+searchQuery;
			searchResult = new GrpArticle(this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE child_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);
			searchResultArticles = this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT child_id FROM pro_product_relation WHERE parent_id = '"+searchResult.getNr()+"' ORDER BY child_id ASC;"));
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
			searchResult = new GrpArticle(this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT parent_id FROM pro_product_relation WHERE parent_id = '"+searchQuery+"' GROUP BY parent_id ORDER BY parent_id ASC;"))[0]);
			searchResultArticles = this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery("SELECT child_id FROM pro_product_relation WHERE parent_id = '"+searchResult.getNr()+"' ORDER BY child_id ASC;"));
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
	*/
	
	
	/****************************************************************************************
	 * 
	 * @param tree_entities
	 * @param searchQuery
	 ***************************************************************************************/
	public void updateArticleTree(JTree tree_entities, String searchQuery) {
		tree_entities.setModel(svcSearch.updateArticleTreeModel(svcSearch.articleSearch(searchQuery)));
		tree_entities.expandRow(0);
	}
	
	
/*	*//**************************************************************************************
	 * Generate new DefaultTreeModel
	 * @param (GrpArticle) searchResult
	 * @return DefaultTreeModel
	 *************************************************************************************//*
	public DefaultTreeModel updateArticleTreeModel( GrpArticle searchResult) {
		
		DefaultMutableTreeNode treeNode;

		DefaultMutableTreeNode treeSubNode;
		DefaultMutableTreeNode treeSubSubNode;
		treeNode = new DefaultMutableTreeNode("Results");
		
        		treeSubNode = new DefaultMutableTreeNode(searchResult.getNr());
        		
        		for(int x = 0; x < searchResult.getArticles().length; x++) {
        			treeSubSubNode = new DefaultMutableTreeNode(searchResult.getArticles()[x].getNr());
	        		treeSubNode.add(treeSubSubNode);
	        		if (searchResult.getArticles()[x].getNr()==this.searchQuery) {
	        			 this.selectedTreeNode = treeSubSubNode;
	        		}
        		}
        		
				treeNode.add(treeSubNode);
        	
        	DefaultTreeModel resultModel = new DefaultTreeModel(treeNode);
        	
        return resultModel;
    }
	*/
	
	
	/************************************************************************************
	 * Update ModuleTabs			
	 * @param selectedNode 
	 * @param moduleTab 
	 * @param tabbedPane_treeNodeMediaModules 
	 ************************************************************************************/
	public void updateProductService(DefaultMutableTreeNode selectedNode) {
		switch(mainView.getTabbedPane_treeNodeMediaModules().getSelectedIndex()) {
		case 0:
			svcImage.fillImgViewport(selectedNode, mainView.getLbl_imgViewport());
			svcImage.fillArticleThumbsList(selectedNode, mainView.getList_articleThumbs());
			break;
		case 1:
			break;
		}
	}
	
	
	/**
	 * Inits JList list_brands with all brands
	 */
	public void initListBrands() {
		DefaultListModel<Brand> model = new DefaultListModel<Brand>();
		String sqlQuery = "SELECT brands_name FROM pro_brands ORDER BY brands_name ASC;";
		for (String brandName: this.mySqlHandler.sqlArrayListToStringArray(this.mySqlHandler.sqlExecuteQuery(sqlQuery)))
		{
			model.addElement(new Brand(brandName));
		}
			mainView.getList_brands().setModel(model);
			mainView.getList_brands().setCellRenderer(new BrandsListRenderer());
	}
	
	
	public void updateBrandList(String searchQuery) {
		mainView.getList_brands().setModel(svcSearch.updateListBrands(searchQuery));
		mainView.getList_brands().setCellRenderer(new BrandsListRenderer());
	}
	
	/**
	 * Update TabbedPane Brand-Details
	 * @param object
	 */
	public void updateBrandService(Object selectedBrand) {
		switch(mainView.getTabbedPane_treeNodeMediaModules().getSelectedIndex()) {
		case 0:
			svcLogo.fillLogoViewport(selectedBrand, mainView.getLbl_logoViewport());
			break;
		case 1:
			break;
		}
	}
	
	/*private void setArticleImageList() {
        final DefaultListModel model = new DefaultListModel();
        if (grpArticle.hasImages()) {
            for (File image : grpArticle.getImages()) {
                model.addElement(image.getName());
            }
        }
        for( Article article: articles ) {
            
            if (article.hasImages()) {
                for (File image : article.getImages()) {
                model.addElement(image.getName());
                }
            }
        }
	}*/
}
