package ui.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import ui.controller.MainViewController;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MainView extends JFrame {

	private MainViewController controller;
	private JPanel contentPane;
	private JTextField txtf_searchField;
	private JTree tree_entities;

	public MainView() {

		/**
		 * Init Controller
		 */
		controller = new MainViewController();
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
		txtf_searchField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//tree_entities.setModel(controller.updateTree(controller.search(txtf_searchField.getText())));
				tree_entities.setModel(controller.updateTree(controller.search(txtf_searchField.getText())));
			}
		});
		txtf_searchField.setBackground(new Color(255, 255, 255));
		txtf_searchField.setBounds(0, 0, 154, 36);
		pnl_searchBar.add(txtf_searchField);
		txtf_searchField.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(51, 204, 255), 2)));
		txtf_searchField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
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
				//tree_entities.setModel(controller.updateTree(controller.search(txtf_searchField.getText())));
					tree_entities.setModel(controller.updateTree(controller.search(txtf_searchField.getText())));
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
		
		Component rigidArea_2 = Box.createRigidArea(new Dimension(99, 20));
		menuBar.add(rigidArea_2);
		{
			JMenu menu = new JMenu("MODULES");
			menu.setFont(new Font("Open Sans", Font.BOLD, 18));
			menu.setBorder(null);
			menuBar.add(menu);
			{
				JMenu menu_1 = new JMenu("Article-Administration");
				menu.add(menu_1);
				{
					JMenu menu_2 = new JMenu("Images");
					menu_1.add(menu_2);
					{
						JMenuItem menuItem = new JMenuItem("Regenerate from backup (.psd)");
						menu_2.add(menuItem);
					}
					{
						JMenuItem menuItem = new JMenuItem("Generate from local (.psd)");
						menu_2.add(menuItem);
					}
				}
				{
					JMenu menu_2 = new JMenu("Videos");
					menu_1.add(menu_2);
				}
				{
					JMenu menu_2 = new JMenu("Labels");
					menu_1.add(menu_2);
				}
				{
					JMenu menu_2 = new JMenu("Attachments");
					menu_1.add(menu_2);
				}
			}
			{
				JMenu menu_1 = new JMenu("Brand-Administration");
				menu.add(menu_1);
			}
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
				new ImageWizard().setVisible(true);
			}
		});
		mnTools.add(mnImagewizard);
		
		JMenu mnVideowizard = new JMenu("VideoWizard");
		mnTools.add(mnVideowizard);
		
		JMenu mnLabelwizard = new JMenu("LabelWizard");
		mnTools.add(mnLabelwizard);
		
		JMenu mnAttachmentwizard = new JMenu("AttachmentWizard");
		mnTools.add(mnAttachmentwizard);
		
		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		menuBar.add(rigidArea_1);
		
		JMenu mnSettigns = new JMenu("SETTINGS");
		mnSettigns.setBorder(null);
		mnSettigns.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnSettigns);
		{
			JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("New check item");
			mnSettigns.add(chckbxmntmNewCheckItem);
		}
		{
			JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("New check item");
			mnSettigns.add(chckbxmntmNewCheckItem_1);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnAdhs = new JMenu("A.D.H.S");
		mnAdhs.setBorder(null);
		mnAdhs.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnAdhs);
		{
			JMenuItem mntmRunAdhs = new JMenuItem("Run A.D.H.S");
			mnAdhs.add(mntmRunAdhs);
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
			Component rigidArea = Box.createRigidArea(new Dimension(106, 20));
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
			tree_entities.setFont(new Font("Consolas", Font.PLAIN, 15));
			tree_entities.setRootVisible(false);
			tree_entities.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Results") {
					{
					}
				}
			));
			tree_entities.setBounds(10, 11, 282, 532);
			pnl_navTree.add(tree_entities);
		}
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(322, 11, 882, 635);
		pnl_contentWrap.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 11, 862, 87);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		{
			JLabel label = new JLabel("#12345");
			label.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			label.setFont(new Font("Consolas", Font.BOLD, 15));
			label.setBounds(10, 11, 74, 33);
			panel_5.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("Braunes Luxus-Toilettenpapier");
			lblNewLabel.setBorder(new CompoundBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
			lblNewLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
			lblNewLabel.setBounds(94, 11, 758, 33);
			panel_5.add(lblNewLabel);
		}
		{
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
			tabbedPane.setBounds(10, 137, 862, 487);
			panel_4.add(tabbedPane);
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(255, 255, 255));
				tabbedPane.addTab("Images", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_images.png")), panel, null);
				panel.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("");
					lblNewLabel_1.setOpaque(true);
					lblNewLabel_1.setBackground(new Color(102, 153, 204));
					lblNewLabel_1.setBounds(204, 11, 378, 378);
					panel.add(lblNewLabel_1);
				}
				{
					JLabel label = new JLabel("");
					label.setBounds(27, 30, 100, 100);
					panel.add(label);
					label.setOpaque(true);
					label.setBackground(new Color(102, 153, 204));
				}
				{
					JList list_imgs = new JList();
					list_imgs.setBorder(new LineBorder(new Color(0, 0, 0)));
					list_imgs.setBounds(10, 11, 133, 437);
					panel.add(list_imgs);
					list_imgs.setLayout(null);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(204, 400, 378, 48);
					panel.add(panel_1);
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(592, 11, 255, 437);
					panel.add(panel_1);
				}
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Videos", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_videos.png")), panel, null);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Labels", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_labels.png")), panel, null);
			}
			{
				JPanel panel = new JPanel();
				tabbedPane.addTab("Attachments", new ImageIcon(MainView.class.getResource("/res/icons/v2/icon_attachments.png")), panel, null);
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
	}
}
