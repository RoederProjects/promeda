package ui.controller;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import core.bricks.Article;
import core.bricks.Brand;
import core.bricks.GrpArticle;
import core.handler.MySQLHandler;
import core.handler.media.article.SvcArticle;
import core.handler.media.article.AttachmentHandler;
import core.handler.media.article.ImageHandler;
import core.handler.media.article.LabelHandler;
import core.handler.media.article.VideoHandler;
import core.handler.media.brand.SvcBrand;
import core.handler.media.brand.SvcLogo;
import core.service.SearchService;
import ui.frames.MainView2;
import ui.frames.MainView3;
import ui.renderer.BrandsListRenderer;

public class MainController extends ViewController {

// GENERAL OBJECTS
	// GUI
	private MainView3 mainView;
	// DB
	private MySQLHandler mySQLHandler;
	// MEDIA-SERVICES
	private ImageHandler imageHandler;
	private VideoHandler videoHandler;
	private LabelHandler labelHandler;
	private AttachmentHandler attachmentHandler;
	private SvcLogo svcLogo;
	private SvcBrand svcBrand;
	private SvcArticle svcArticle;
	
// SEARCH-FIELDS
	private boolean searchMatch;
	private String searchQuery;
	private GrpArticle searchResult;
	private DefaultMutableTreeNode selectedTreeNode;
	private SearchService searchService;

// BOARDS-FIELDS
	private String activePanel;
	private Article selectedArticle;
	
	
	/************************************************************************************
	 * Constructor - Inits the media-services of products-module 						*
	 ************************************************************************************/
	public MainController() {
		this.mySQLHandler = new MySQLHandler();
		this.mainView = new MainView3();
		mainView.setVisible(true);
		imageHandler = new ImageHandler();
		videoHandler = new VideoHandler();
		labelHandler = new LabelHandler();
		attachmentHandler = new AttachmentHandler();
		svcLogo = new SvcLogo();
		svcBrand = new SvcBrand();
		svcArticle = new SvcArticle();
		selectedArticle = new Article("00000");
		
		searchService = new SearchService();
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
		
		mainView.getTabbedPane_treeNodeMediaModules().setBackgroundAt(0, Color.getHSBColor(20, 50, 90));
		mainView.getTabbedPane_treeNodeMediaModules().setBackgroundAt(1, Color.getHSBColor(50, 50, 90));
		mainView.getTabbedPane_treeNodeMediaModules().setBackgroundAt(2, Color.getHSBColor(20, 20, 90));
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
					updateBrandList(mainView.getTxtf_searchField().getText());
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
		
		mainView.getBtn_addBrand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				svcBrand.brandAdd();
			}
		});
		mainView.getBtn_deleteBrand().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				svcBrand.brandRemove(mainView.getList_brands().getSelectedValue());
			}
		});
		
		mainView.getMntm_imageWizard().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImgWzrdController imgWzrdCtrl = new ImgWzrdController();
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

	
	
/**********************************************************************************************************************
 ******** A R T I C L E S - B O A R D [Begin] *************************************************************************
 */
	/****************************************************************************************
	 * 
	 * @param tree_entities
	 * @param searchQuery
	 ***************************************************************************************/
	public void updateArticleTree(JTree tree_entities, String searchQuery) {
		tree_entities.setModel(searchService.updateArticleTreeModel(searchService.articleSearch(searchQuery)));
		tree_entities.expandRow(0);
	}
	
	
	/************************************************************************************
	 * Update ModuleTabs			
	 * @param selectedNode 
	 * @param moduleTab 
	 * @param tabbedPane_treeNodeMediaModules 
	 ************************************************************************************/
	public void updateProductService(DefaultMutableTreeNode selectedNode) {
		updateArticleTitleBar(selectedNode);
		switch(mainView.getTabbedPane_treeNodeMediaModules().getSelectedIndex()) {
		case 0:
			imageHandler.fillImgViewport(selectedNode, mainView.getLbl_imgViewport());
			imageHandler.fillArticleThumbsList(selectedNode, mainView.getList_articleThumbs());
			break;
		case 1:
			break;
		}
	}
	
	public void updateArticleTitleBar(DefaultMutableTreeNode selectedNode) {
		Object nodeInfo = selectedNode.getUserObject();
        String selectedArticleNr = nodeInfo.toString();
        selectedArticle.setNr(selectedArticleNr);
        mainView.getLbl_titleBarArtNr().setText(selectedArticle.getNr());
        mainView.getLbl_titleBarArtName().setText(selectedArticle.interrogateArticleName());
	}
/**
 ******** A R T I C L E S - B O A R D [End] ****************************************************************************
 ***********************************************************************************************************************/


	
/**********************************************************************************************************************
 ******** B R A N D S - B O A R D [Begin] *****************************************************************************
 */	
	/**
	 * Inits JList list_brands with all brands
	 */
	public void initListBrands() {
		mySQLHandler.conCheck();
		DefaultListModel<Brand> model = new DefaultListModel<Brand>();
		String sqlQuery = "SELECT brands_name FROM pro_brands ORDER BY brands_name ASC;";
		for (String brandName: this.mySQLHandler.sqlArrayListToStringArray(this.mySQLHandler.sqlExecuteQuery(sqlQuery)))
		{
			model.addElement(new Brand(brandName));
		}
			mainView.getList_brands().setModel(model);
			mainView.getList_brands().setCellRenderer(new BrandsListRenderer());
			mainView.getList_brands().setBorder(new CompoundBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "All Brands", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(102, 102, 102)), new EmptyBorder(4, 4, 4, 4)));
	}
	
	
	public void updateBrandList(String searchQuery) {
		mainView.getList_brands().setModel(searchService.updateListBrands(searchQuery));
		mainView.getList_brands().setCellRenderer(new BrandsListRenderer());
		mainView.getList_brands().setBorder(new CompoundBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "All Brands", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(102, 102, 102)), new EmptyBorder(4, 4, 4, 4)));
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
/**
 ******** B R A N D S - B O A R D [End] ********************************************************************************
 ***********************************************************************************************************************/
	
}
