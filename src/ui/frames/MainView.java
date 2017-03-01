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

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtf_searchField;
	private JTree tree_entities;
	private JTabbedPane tabbedPane_treeNodeMediaModules;
	/**
	 * @wbp.nonvisual location=22,829
	 */
	private final ButtonGroup btnGrp_adminpanels = new ButtonGroup();
	private JRadioButtonMenuItem rdbtnmntm_adminpanelArticles;
	private JRadioButtonMenuItem rdbtnmntm_adminpanelBrands;
	private JLabel lbl_ArticleImageViewport;
	private JList list_ArticleImages;
	private JButton btnNewButton;
	
	public MainView() {

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
		setSize(new Dimension(1200, 880));
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
		btnNewButton.setRolloverIcon(new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_search_highlighted.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.updateTree(tree_entities, txtf_searchField.getText());
				tabbedPane_treeNodeMediaModules.setEnabled(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_search.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(0, 204, 255), 2)));
		btnNewButton.setBounds(154, 0, 28, 36);
		pnl_searchBar.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		
		JMenu mnSettigns = new JMenu("PANELS");
		mnSettigns.setBorder(null);
		mnSettigns.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnSettigns);
		{
			rdbtnmntm_adminpanelArticles = new JRadioButtonMenuItem("Articles-board");
			rdbtnmntm_adminpanelArticles.setSelected(true);
			mnSettigns.add(rdbtnmntm_adminpanelArticles);
		}
		{
			rdbtnmntm_adminpanelBrands = new JRadioButtonMenuItem("Brands-board");
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
		
		JMenuItem mnImagewizard = new JMenuItem("ImageWizard");
		mnImagewizard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ImgWzrdView().setVisible(true);
			}
		});
		mnTools.add(mnImagewizard);
		
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
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnUserprofile = new JMenu("USER-PROFILE");
		mnUserprofile.setBorder(null);
		mnUserprofile.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnUserprofile);
		{
			JMenuItem mntmLogout = new JMenuItem("Logout");
			mnUserprofile.add(mntmLogout);
		}
		{
			JMenuItem mntmExit = new JMenuItem("Exit");
			mnUserprofile.add(mntmExit);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(328, 20));
			menuBar.add(rigidArea);
		}
		{
			JMenu mnSystem = new JMenu("SYSTEM");
			mnSystem.setBorder(null);
			mnSystem.setFont(new Font("Open Sans", Font.BOLD, 18));
			menuBar.add(mnSystem);
			{
				JMenuItem mntmStores = new JMenuItem("Stores");
				mnSystem.add(mntmStores);
			}
			{
				JMenu mnRemoteConfig = new JMenu("Remote Config");
				mnSystem.add(mnRemoteConfig);
				{
					JMenuItem mntmPromond = new JMenuItem("Promond");
					mnRemoteConfig.add(mntmPromond);
				}
			}
		}
		
		JPanel pnl_contentWrap = new JPanel();
		pnl_contentWrap.setBackground(new Color(255, 255, 255));
		pnl_contentWrap.setBounds(10, 82, 1214, 657);
		pnl_mainWrap.add(pnl_contentWrap);
		pnl_contentWrap.setLayout(null);
		
		JPanel pnl_navTree = new JPanel();
		pnl_navTree.setBounds(10, 11, 302, 635);
		pnl_contentWrap.add(pnl_navTree);
		pnl_navTree.setLayout(null);
		{
			tree_entities = new JTree();
			tree_entities.addTreeSelectionListener(new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent arg0) {
					moduleUpdate((DefaultMutableTreeNode) tree_entities.getLastSelectedPathComponent());
					tabbedPane_treeNodeMediaModules.setEnabled(true);
				}
			});
			tree_entities.setFont(new Font("Consolas", Font.PLAIN, 15));
			tree_entities.setRootVisible(false);
			tree_entities.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Results")));
			tree_entities.setBounds(10, 11, 282, 613);
			pnl_navTree.add(tree_entities);
		}
		
		JPanel pnl_treeNodeDetails = new JPanel();
		pnl_treeNodeDetails.setBounds(322, 11, 882, 635);
		pnl_contentWrap.add(pnl_treeNodeDetails);
		pnl_treeNodeDetails.setLayout(null);
		
		JPanel pnl_treeNodeMeta = new JPanel();
		pnl_treeNodeMeta.setBackground(new Color(255, 255, 255));
		pnl_treeNodeMeta.setBounds(10, 11, 862, 87);
		pnl_treeNodeDetails.add(pnl_treeNodeMeta);
		pnl_treeNodeMeta.setLayout(null);
		{
			JLabel label = new JLabel("#12345");
			label.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			label.setFont(new Font("Consolas", Font.BOLD, 15));
			label.setBounds(10, 11, 74, 33);
			pnl_treeNodeMeta.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("Braunes Luxus-Toilettenpapier");
			lblNewLabel.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
			lblNewLabel.setBounds(94, 11, 758, 33);
			pnl_treeNodeMeta.add(lblNewLabel);
		}
		{
			tabbedPane_treeNodeMediaModules = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_treeNodeMediaModules.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			tabbedPane_treeNodeMediaModules.setBounds(10, 137, 862, 487);
			pnl_treeNodeDetails.add(tabbedPane_treeNodeMediaModules);
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				tabbedPane_treeNodeMediaModules.addTab("Images", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_images.png")), panel, null);
				tabbedPane_treeNodeMediaModules.setEnabledAt(0, false);
				panel.setLayout(null);
				{
					lbl_ArticleImageViewport = new JLabel("");
					lbl_ArticleImageViewport.setOpaque(true);
					lbl_ArticleImageViewport.setBackground(new Color(102, 153, 204));
					lbl_ArticleImageViewport.setBounds(204, 11, 378, 378);
					panel.add(lbl_ArticleImageViewport);
				}
				{
					list_ArticleImages = new JList();
					list_ArticleImages.setBorder(new LineBorder(new Color(0, 0, 0)));
					list_ArticleImages.setBounds(10, 11, 129, 430);
					panel.add(list_ArticleImages);
					list_ArticleImages.setLayout(null);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(204, 400, 378, 41);
					panel.add(panel_1);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(635, 11, 212, 430);
					panel.add(panel_1);
				}
			}
			{
				JPanel panel = new JPanel();
				tabbedPane_treeNodeMediaModules.addTab("Videos", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_videos.png")), panel, null);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane_treeNodeMediaModules.addTab("Labels", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_labels.png")), panel, null);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane_treeNodeMediaModules.addTab("Attachments", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_attachments.png")), panel, null);
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
	public JList getList_imgs() {
		return list_ArticleImages;
	}
	public JTree getTree_entities() {
		return tree_entities;
	}
	public JTabbedPane getTabbedPane_treeNodeMediaModules() {
		return tabbedPane_treeNodeMediaModules;
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
}
