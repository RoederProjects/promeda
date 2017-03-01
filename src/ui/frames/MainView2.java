package ui.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.ldap.Rdn;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import ui.controller.MainController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.tree.DefaultTreeModel;

import core.handler.media.SvcAttachment;
import core.handler.media.SvcImage;
import core.handler.media.SvcLabel;
import core.handler.media.SvcVideo;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class MainView2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtf_searchField;
	private JTree tree_entities;
	private JTabbedPane tabbedPane_articleMedia;
	/**
	 * @wbp.nonvisual location=22,829
	 */
	private final ButtonGroup btnGrp_adminpanels = new ButtonGroup();
	private JRadioButtonMenuItem rdbtnmntm_adminpanelArticles;
	private JRadioButtonMenuItem rdbtnmntm_adminpanelBrands;
	private JLabel lbl_ArticleImageViewport;
	private JList list_ArticleThumbs;
	private JButton btnNewButton;
	private JPanel pnl_contentWrap;
	private JPanel pnl_articlesBoard;
	private JPanel pnl_brandsBoard;
	private JTextField textField;
	private JList list_brands;
	private JLabel lbl_logoViewport;
	private JButton btn_addBrand;
	private JButton btn_deleteBrand;
	private JButton btn_brandNameEdit;
	private JMenuItem mntm_imageWizard;
	private JLabel lbl_titleBarArtName;
	private JLabel lbl_titleBarArtNr;
	
	public MainView2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView2.class.getResource("/res/favicon/dromedar.png")));
		setResizable(false);

		/**
		 * Init Controller and Modules
		 */
		//controller = new MainViewController();
	
		/**
		 * Create the frame.
		 */
		compCreate();
		compCustomSetup();
	}
	
	/**
	 * Creates the frame and all its swing components
	 */
	public void compCreate() {
		setLocationByPlatform(true);
		setSize(new Dimension(1300, 815));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("PROMEDA | Media Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 801);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setAlignmentX(0.0f);
		contentPane.setAlignmentY(0.0f);
		contentPane.setAutoscrolls(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnl_mainWrap = new JPanel();
		pnl_mainWrap.setBackground(new Color(51, 153, 153));
		pnl_mainWrap.setBounds(0, 0, 1234, 750);
		contentPane.add(pnl_mainWrap);
		pnl_mainWrap.setLayout(null);
		
		JPanel pnl_topBar = new JPanel();
		pnl_topBar.setBackground(new Color(0, 102, 102));
		pnl_topBar.setBounds(10, 22, 1214, 39);
		pnl_mainWrap.add(pnl_topBar);
		pnl_topBar.setLayout(null);
		
		JPanel pnl_NavBar = new JPanel();
		pnl_NavBar.setOpaque(false);
		pnl_NavBar.setBounds(0, 0, 1214, 40);
		pnl_topBar.add(pnl_NavBar);
		pnl_NavBar.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 102, 102), 2));
		menuBar.setBounds(0, 0, 1214, 40);
		pnl_NavBar.add(menuBar);
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JPanel pnl_searchBar = new JPanel();
		menuBar.add(pnl_searchBar);
		pnl_searchBar.setOpaque(false);
		pnl_searchBar.setBackground(new Color(0, 102, 102));
		pnl_searchBar.setLayout(null);
		
		txtf_searchField = new JTextField();
	
		txtf_searchField.setBackground(new Color(255, 255, 255));
		txtf_searchField.setBounds(0, 0, 154, 36);
		pnl_searchBar.add(txtf_searchField);
		txtf_searchField.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(51, 204, 255), 2)));
		txtf_searchField.setColumns(10);
		
		btnNewButton = new JButton("");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setOpaque(false);
		btnNewButton.setIconTextGap(0);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setRolloverIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_search_highlighted.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_search.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(0, 204, 255), 2)));
		btnNewButton.setBounds(154, 0, 28, 36);
		pnl_searchBar.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		JMenu mnSettigns = new JMenu("BOARDS");
		mnSettigns.setBorder(null);
		mnSettigns.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnSettigns);
		{
			rdbtnmntm_adminpanelArticles = new JRadioButtonMenuItem("Articles");
			rdbtnmntm_adminpanelArticles.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_articlesBoard.png")));
			rdbtnmntm_adminpanelArticles.setSelected(true);
			mnSettigns.add(rdbtnmntm_adminpanelArticles);
		}
		{
			rdbtnmntm_adminpanelBrands = new JRadioButtonMenuItem("Brands");
			rdbtnmntm_adminpanelBrands.setFocusPainted(true);
			rdbtnmntm_adminpanelBrands.setFocusable(true);
			rdbtnmntm_adminpanelBrands.setRolloverEnabled(true);
			rdbtnmntm_adminpanelBrands.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_brandsBoard.png")));
			mnSettigns.add(rdbtnmntm_adminpanelBrands);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnMedia = new JMenu("MEDIA");
		mnMedia.setFont(new Font("Open Sans", Font.BOLD, 18));
		mnMedia.setBorder(null);
		menuBar.add(mnMedia);
		{
			JMenu mnArticleadministration = new JMenu("Article-Administration");
			mnMedia.add(mnArticleadministration);
			
			JMenu mnImages_1 = new JMenu("Images");
			mnArticleadministration.add(mnImages_1);
			
			JMenuItem mntmRegenerateFromOriginals = new JMenuItem("Regenerate from backup (.psd)");
			mnImages_1.add(mntmRegenerateFromOriginals);
			
			JMenuItem mntmNewMenuItem = new JMenuItem("Generate from local (.psd)");
			mnImages_1.add(mntmNewMenuItem);
			
			JMenu mnVideos = new JMenu("Videos");
			mnArticleadministration.add(mnVideos);
			
			JMenu mnLabels = new JMenu("Labels");
			mnArticleadministration.add(mnLabels);
			
			JMenu mnAttachments = new JMenu("Attachments");
			mnArticleadministration.add(mnAttachments);
		}
		{
			JMenu mnBrandadministration = new JMenu("Brand-Administration");
			mnMedia.add(mnBrandadministration);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnTools = new JMenu("TOOLS");
		mnTools.setFont(new Font("Open Sans", Font.BOLD, 18));
		mnTools.setBorder(null);
		menuBar.add(mnTools);
		
		mntm_imageWizard = new JMenuItem("ImageWizard");
		mnTools.add(mntm_imageWizard);
		
		JMenu mnVideowizard = new JMenu("VideoWizard");
		mnTools.add(mnVideowizard);
		
		JMenu mnLabelwizard = new JMenu("LabelWizard");
		mnTools.add(mnLabelwizard);
		
		JMenu mnAttachmentwizard = new JMenu("AttachmentWizard");
		mnTools.add(mnAttachmentwizard);
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnUserprofile = new JMenu("USER");
		mnUserprofile.setBorder(null);
		mnUserprofile.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnUserprofile);
		{
			JMenuItem mntmLogout = new JMenuItem("Change Password");
			mnUserprofile.add(mntmLogout);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnInfo = new JMenu("INFO");
		mnInfo.setBorder(null);
		mnInfo.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnInfo);
		{
			JMenuItem mntmHelp = new JMenuItem("Help");
			mnInfo.add(mntmHelp);
		}
		{
			JMenuItem mntmAbout = new JMenuItem("About");
			mnInfo.add(mntmAbout);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(403, 20));
			menuBar.add(rigidArea);
		}
		{
			JMenu mnSystem = new JMenu("SYSTEM");
			mnSystem.setBorder(null);
			mnSystem.setFont(new Font("Open Sans", Font.BOLD, 18));
			menuBar.add(mnSystem);
			{
				JMenuItem mntmStores = new JMenuItem("Settings");
				mnSystem.add(mntmStores);
			}
			{
				JMenu mnRemoteConfig = new JMenu("User Management");
				mnSystem.add(mnRemoteConfig);
			}
		}
		
		pnl_contentWrap = new JPanel();
		pnl_contentWrap.setBackground(new Color(255, 255, 255));
		pnl_contentWrap.setBounds(10, 82, 1214, 657);
		pnl_mainWrap.add(pnl_contentWrap);
		pnl_contentWrap.setLayout(new CardLayout(0, 0));
		{
			pnl_articlesBoard = new JPanel();
			pnl_articlesBoard.setName("card_articlesBoard");
			pnl_articlesBoard.setOpaque(false);
			pnl_contentWrap.add(pnl_articlesBoard, "card_articlesBoard");
			pnl_articlesBoard.setLayout(null);
			
			JPanel pnl_navTree = new JPanel();
			pnl_navTree.setBounds(10, 11, 302, 635);
			pnl_articlesBoard.add(pnl_navTree);
			pnl_navTree.setLayout(null);
			{
				tree_entities = new JTree();
				tree_entities.setBorder(new CompoundBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "Search-Results", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(102, 102, 102)), new EmptyBorder(4, 4, 4, 4)));
				tree_entities.setRowHeight(20);
				tree_entities.setFont(new Font("Consolas", Font.PLAIN, 15));
				tree_entities.setRootVisible(false);
				tree_entities.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Results")));
				tree_entities.setBounds(10, 11, 282, 613);
				pnl_navTree.add(tree_entities);
			}
			
			JPanel pnl_treeNodeDetails = new JPanel();
			pnl_treeNodeDetails.setBounds(322, 11, 882, 635);
			pnl_articlesBoard.add(pnl_treeNodeDetails);
			pnl_treeNodeDetails.setLayout(null);
			
			JPanel pnl_treeNodeMeta = new JPanel();
			pnl_treeNodeMeta.setBackground(new Color(255, 255, 255));
			pnl_treeNodeMeta.setBounds(10, 11, 862, 87);
			pnl_treeNodeDetails.add(pnl_treeNodeMeta);
			pnl_treeNodeMeta.setLayout(null);
			{
				lbl_titleBarArtNr = new JLabel("#12345");
				lbl_titleBarArtNr.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
				lbl_titleBarArtNr.setFont(new Font("Consolas", Font.BOLD, 15));
				lbl_titleBarArtNr.setBounds(10, 11, 74, 33);
				pnl_treeNodeMeta.add(lbl_titleBarArtNr);
			}
			{
				lbl_titleBarArtName = new JLabel("Braunes Luxus-Toilettenpapier");
				lbl_titleBarArtName.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
				lbl_titleBarArtName.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
				lbl_titleBarArtName.setBounds(94, 11, 758, 33);
				pnl_treeNodeMeta.add(lbl_titleBarArtName);
			}
			{
				tabbedPane_articleMedia = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane_articleMedia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
				tabbedPane_articleMedia.setBounds(10, 137, 862, 487);
				pnl_treeNodeDetails.add(tabbedPane_articleMedia);
				{
					JPanel pnl_articleImages = new JPanel();
					pnl_articleImages.setBackground(new Color(255, 255, 255));
					tabbedPane_articleMedia.addTab("Images", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_images.png")), pnl_articleImages, "asd");
					pnl_articleImages.setLayout(null);
					{
						lbl_ArticleImageViewport = new JLabel("");
						lbl_ArticleImageViewport.setOpaque(true);
						lbl_ArticleImageViewport.setBackground(new Color(102, 153, 204));
						lbl_ArticleImageViewport.setBounds(204, 11, 378, 378);
						pnl_articleImages.add(lbl_ArticleImageViewport);
					}
					{
						list_ArticleThumbs = new JList();
						list_ArticleThumbs.setBorder(new LineBorder(new Color(0, 0, 0)));
						list_ArticleThumbs.setBounds(10, 11, 129, 430);
						pnl_articleImages.add(list_ArticleThumbs);
						list_ArticleThumbs.setLayout(null);
					}
					{
						JPanel panel_1 = new JPanel();
						panel_1.setBounds(204, 400, 378, 41);
						pnl_articleImages.add(panel_1);
					}
					{
						JPanel panel_1 = new JPanel();
						panel_1.setBounds(635, 11, 212, 430);
						pnl_articleImages.add(panel_1);
					}
				}
				{
					JPanel pnl_articleVideos = new JPanel();
					tabbedPane_articleMedia.addTab("Videos", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_videos.png")), pnl_articleVideos, null);
				}
				{
					JPanel pnl_articleLabels = new JPanel();
					tabbedPane_articleMedia.addTab("Labels", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_labels.png")), pnl_articleLabels, null);
				}
				{
					JPanel pnl_articleAttachments = new JPanel();
					tabbedPane_articleMedia.addTab("Attachments", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_attachments.png")), pnl_articleAttachments, null);
				}
			}
		}
		{
			pnl_brandsBoard = new JPanel();
			pnl_contentWrap.add(pnl_brandsBoard, "card_brandsBoard");
			pnl_brandsBoard.setLayout(null);
			{
				JPanel pnl_brandList = new JPanel();
				pnl_brandList.setLayout(null);
				pnl_brandList.setBounds(10, 11, 302, 635);
				pnl_brandsBoard.add(pnl_brandList);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBorder(new TitledBorder(new LineBorder(new Color(51, 51, 51), 2), "All Brands", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
					scrollPane.setBounds(10, 0, 282, 583);
					pnl_brandList.add(scrollPane);
					{
						list_brands = new JList();
						scrollPane.setViewportView(list_brands);
						list_brands.setFont(new Font("Consolas", Font.PLAIN, 15));
						list_brands.setBorder(new CompoundBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("CheckBoxMenuItem.border")), "All Brands", TitledBorder.LEADING, TitledBorder.BELOW_TOP, null, new Color(102, 102, 102)), new EmptyBorder(4, 4, 4, 4)));
					}
				}
				{
					btn_addBrand = new JButton("");
					btn_addBrand.setFocusPainted(false);
					btn_addBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btn_addBrand.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_cycle-add.png")));
					btn_addBrand.setContentAreaFilled(false);
					btn_addBrand.setBounds(196, 590, 34, 34);
					pnl_brandList.add(btn_addBrand);
				}
				{
					btn_deleteBrand = new JButton("");
					btn_deleteBrand.setFocusPainted(false);
					btn_deleteBrand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btn_deleteBrand.setContentAreaFilled(false);
					btn_deleteBrand.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_cycle-remove.png")));
					btn_deleteBrand.setBounds(240, 590, 34, 34);
					pnl_brandList.add(btn_deleteBrand);
				}
			}
			{
				JPanel pnl_brandDetails = new JPanel();
				pnl_brandDetails.setLayout(null);
				pnl_brandDetails.setBounds(322, 11, 882, 635);
				pnl_brandsBoard.add(pnl_brandDetails);
				{
					JPanel pnl_brandTitle = new JPanel();
					pnl_brandTitle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					pnl_brandTitle.setLayout(null);
					pnl_brandTitle.setBackground(Color.WHITE);
					pnl_brandTitle.setBounds(10, 11, 862, 87);
					pnl_brandDetails.add(pnl_brandTitle);
					{
						JLabel lbl_brandName = new JLabel("Brandname");
						lbl_brandName.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
						lbl_brandName.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
						lbl_brandName.setBounds(10, 11, 842, 42);
						pnl_brandTitle.add(lbl_brandName);
					}
					{
						btn_brandNameEdit = new JButton("");
						btn_brandNameEdit.setFocusPainted(false);
						btn_brandNameEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						btn_brandNameEdit.setContentAreaFilled(false);
						btn_brandNameEdit.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_cycle-edit.png")));
						btn_brandNameEdit.setBounds(818, 11, 34, 42);
						pnl_brandTitle.add(btn_brandNameEdit);
					}
				}
				{
					JTabbedPane tabbedPane_brandMedia = new JTabbedPane(JTabbedPane.TOP);
					tabbedPane_brandMedia.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
					tabbedPane_brandMedia.setBounds(10, 109, 862, 515);
					pnl_brandDetails.add(tabbedPane_brandMedia);
					{
						JPanel pnl_brandLogo = new JPanel();
						pnl_brandLogo.setBackground(new Color(255, 255, 255));
						tabbedPane_brandMedia.addTab("Logo", null, pnl_brandLogo, null);
						pnl_brandLogo.setLayout(null);
						{
							lbl_logoViewport = new JLabel("");
							lbl_logoViewport.setHorizontalTextPosition(SwingConstants.CENTER);
							lbl_logoViewport.setHorizontalAlignment(SwingConstants.CENTER);
							lbl_logoViewport.setBorder(new LineBorder(new Color(204, 204, 204), 2));
							lbl_logoViewport.setBounds(10, 11, 563, 458);
							pnl_brandLogo.add(lbl_logoViewport);
						}
						{
							JPanel panel_2 = new JPanel();
							panel_2.setBackground(new Color(255, 255, 255));
							panel_2.setBounds(583, 11, 264, 458);
							pnl_brandLogo.add(panel_2);
							panel_2.setLayout(null);
							{
								JLabel lblNewLabel_1 = new JLabel("Logo File");
								lblNewLabel_1.setBounds(10, 11, 46, 14);
								panel_2.add(lblNewLabel_1);
							}
							{
								JButton btnUploadLogo = new JButton("Upload Logo");
								btnUploadLogo.setBounds(10, 121, 244, 23);
								panel_2.add(btnUploadLogo);
							}
							{
								textField = new JTextField();
								textField.setEditable(false);
								textField.setBounds(10, 36, 244, 20);
								panel_2.add(textField);
							}
							{
								JLabel lblResolution = new JLabel("Resolution");
								lblResolution.setBounds(10, 67, 108, 14);
								panel_2.add(lblResolution);
							}
							{
								JLabel lblNewLabel_2 = new JLabel("600 x 400");
								lblNewLabel_2.setBounds(129, 67, 125, 14);
								panel_2.add(lblNewLabel_2);
							}
						}
					}
				}
			}
		}
	}
	
	public void compSetup() {
	}
	
	public void compCustomSetup() {
		DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) tree_entities.getCellRenderer();
		render.setOpenIcon(new ImageIcon("./src/res/icons/v2/icon_0G.png"));
		render.setClosedIcon(new ImageIcon("./src/res/icons/v2/icon_0G.png"));
		render.setLeafIcon(new ImageIcon("./src/res/icons/v2/icon_00.png"));
		tree_entities.setCellRenderer(render);
		
		btnGrp_adminpanels.add(rdbtnmntm_adminpanelArticles);
		btnGrp_adminpanels.add(rdbtnmntm_adminpanelBrands);
	}
	
	public void moduleUpdate(DefaultMutableTreeNode selectedNode) {
		
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JTextField getTxtf_searchField() {
		return txtf_searchField;
	}
	public JLabel getLbl_imgViewport() {
		return lbl_ArticleImageViewport;
	}
	public JList getList_articleThumbs() {
		return list_ArticleThumbs;
	}
	public JTree getTree_entities() {
		return tree_entities;
	}
	public JTabbedPane getTabbedPane_treeNodeMediaModules() {
		return tabbedPane_articleMedia;
	}
	public ButtonGroup getBtnGrp_adminpanels() {
		return btnGrp_adminpanels;
	}
	public JRadioButtonMenuItem getRdbtnmntm_adminpanelArticles() {
		return rdbtnmntm_adminpanelArticles;
	}
	public JRadioButtonMenuItem getRdbtnmntm_adminpanelBrands() {
		return rdbtnmntm_adminpanelBrands;
	}
	public JPanel getPnl_contentWrap() {
		return pnl_contentWrap;
	}
	public JPanel getPnl_articlesBoard() {
		return pnl_articlesBoard;
	}
	public JPanel getPnl_brandsBoard() {
		return pnl_brandsBoard;
	}
	public JList getList_brands() {
		return list_brands;
	}
	public JLabel getLbl_logoViewport() {
		return lbl_logoViewport;
	}
	public JButton getBtn_addBrand() {
		return btn_addBrand;
	}
	public JButton getBtn_deleteBrand() {
		return btn_deleteBrand;
	}
	public JButton getBtn_brandNameEdit() {
		return btn_brandNameEdit;
	}
	public JMenuItem getMntm_imageWizard() {
		return mntm_imageWizard;
	}
	public JLabel getLbl_titleBarArtNr() {
		return lbl_titleBarArtNr;
	}
	public JLabel getLbl_titleBarArtName() {
		return lbl_titleBarArtName;
	}
}
