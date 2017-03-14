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

import core.handler.media.article.AttachmentHandler;
import core.handler.media.article.ImageHandler;
import core.handler.media.article.LabelHandler;
import core.handler.media.article.VideoHandler;

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
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JToolBar;
import java.awt.ComponentOrientation;
import javax.swing.JCheckBox;

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
	private final ButtonGroup btnGrp_searchSettings = new ButtonGroup();
	private final ButtonGroup btnGrp_mediaImgStatus = new ButtonGroup();
	private final ButtonGroup btnGrp_searchResultViewport = new ButtonGroup();
	
	public MainView2() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView2.class.getResource("/res/favicon/dromedar.png")));

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
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("PROMEDA | Media Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 832);
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
		pnl_mainWrap.setBounds(0, 0, 1234, 778);
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
		txtf_searchField.setOpaque(false);
	
		txtf_searchField.setBackground(new Color(255, 255, 255));
		txtf_searchField.setBounds(10, 0, 154, 36);
		pnl_searchBar.add(txtf_searchField);
		txtf_searchField.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(51, 204, 255), 2)));
		txtf_searchField.setColumns(10);
		
		btnNewButton = new JButton("");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setIconTextGap(0);
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setRolloverIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_search_highlighted.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_search.png")));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new CompoundBorder(new EmptyBorder(4, 0, 4, 0), new LineBorder(new Color(0, 204, 255), 2)));
		btnNewButton.setBounds(163, 0, 29, 36);
		pnl_searchBar.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		{
			JMenu mnSearchsettings = new JMenu("");
			mnSearchsettings.setContentAreaFilled(false);
			mnSearchsettings.setHorizontalAlignment(SwingConstants.CENTER);
			mnSearchsettings.setToolTipText("Choose how the results will be viewed");
			mnSearchsettings.setPressedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_searchSettingsHighlighted.png")));
			mnSearchsettings.setRolloverSelectedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_searchSettingsHighlighted.png")));
			mnSearchsettings.setSelectedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_searchSettingsHighlighted.png")));
			mnSearchsettings.setRolloverIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_searchSettingsHighlighted.png")));
			mnSearchsettings.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_searchSettings.png")));
			menuBar.add(mnSearchsettings);
			{
				JRadioButtonMenuItem rdbtnmntmShowGrparticle = new JRadioButtonMenuItem("Find GrpArticle");
				rdbtnmntmShowGrparticle.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_findGrpArticle.png")));
				rdbtnmntmShowGrparticle.setSelected(true);
				btnGrp_searchSettings.add(rdbtnmntmShowGrparticle);
				mnSearchsettings.add(rdbtnmntmShowGrparticle);
			}
			{
				JRadioButtonMenuItem rdbtnmntmShowSingleArticles = new JRadioButtonMenuItem("Search All");
				rdbtnmntmShowSingleArticles.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_searchAll.png")));
				btnGrp_searchSettings.add(rdbtnmntmShowSingleArticles);
				mnSearchsettings.add(rdbtnmntmShowSingleArticles);
			}
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(81, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnSettigns = new JMenu("BOARDS");
		mnSettigns.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_boards.png")));
		mnSettigns.setBorder(null);
		mnSettigns.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnSettigns);
		{
			rdbtnmntm_adminpanelBrands = new JRadioButtonMenuItem("Brands");
			rdbtnmntm_adminpanelBrands.setFocusPainted(true);
			rdbtnmntm_adminpanelBrands.setFocusable(true);
			rdbtnmntm_adminpanelBrands.setRolloverEnabled(true);
			rdbtnmntm_adminpanelBrands.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_boardBrands.png")));
			mnSettigns.add(rdbtnmntm_adminpanelBrands);
		}
		{
			rdbtnmntm_adminpanelArticles = new JRadioButtonMenuItem("Articles");
			rdbtnmntm_adminpanelArticles.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_boardArticles.png")));
			rdbtnmntm_adminpanelArticles.setSelected(true);
			mnSettigns.add(rdbtnmntm_adminpanelArticles);
		}
		{
			JRadioButtonMenuItem rdbtnmntmMedia = new JRadioButtonMenuItem("Media");
			rdbtnmntmMedia.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_boardMedia.png")));
			btnGrp_adminpanels.add(rdbtnmntmMedia);
			mnSettigns.add(rdbtnmntmMedia);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(25, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnTools = new JMenu("TOOLS");
		mnTools.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_tools.png")));
		mnTools.setFont(new Font("Open Sans", Font.BOLD, 18));
		mnTools.setBorder(null);
		menuBar.add(mnTools);
		
		mntm_imageWizard = new JMenuItem("ImageWizard");
		mntm_imageWizard.setOpaque(true);
		mntm_imageWizard.setBackground(new Color(102, 204, 255));
		mntm_imageWizard.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_imgWzrd.png")));
		mnTools.add(mntm_imageWizard);
		
		JMenu mnLabelwizard = new JMenu("LabelWizard");
		mnTools.add(mnLabelwizard);
		
		JMenu mnAttachmentwizard = new JMenu("AttachmentWizard");
		mnTools.add(mnAttachmentwizard);
		{
			Component rigidArea = Box.createRigidArea(new Dimension(25, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnMedia = new JMenu("MEDIA");
		mnMedia.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_media.png")));
		mnMedia.setFont(new Font("Open Sans", Font.BOLD, 18));
		mnMedia.setBorder(null);
		menuBar.add(mnMedia);
		{
			JMenuItem mntmVideo = new JMenuItem("Video");
			mnMedia.add(mntmVideo);
		}
		{
			JSeparator separator = new JSeparator();
			mnMedia.add(separator);
		}
		{
			JMenuItem mntmMediaitemsreport = new JMenuItem("Media-Items-Report");
			mnMedia.add(mntmMediaitemsreport);
		}
		{
			JMenuItem mntmMediabackupdirectory = new JMenuItem("Media-Backup-Directory");
			mnMedia.add(mntmMediabackupdirectory);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(25, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnUserprofile = new JMenu("USER");
		mnUserprofile.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_user.png")));
		mnUserprofile.setBorder(null);
		mnUserprofile.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnUserprofile);
		{
			JMenuItem mntmProfile = new JMenuItem("Profile");
			mnUserprofile.add(mntmProfile);
		}
		{
			JMenuItem mntmLogout = new JMenuItem("Change Password");
			mntmLogout.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_authority.png")));
			mnUserprofile.add(mntmLogout);
		}
		{
			JMenuItem mntmLogout_1 = new JMenuItem("Logout");
			mnUserprofile.add(mntmLogout_1);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(25, 20));
			menuBar.add(rigidArea);
		}
		
		JMenu mnInfo = new JMenu("INFO");
		mnInfo.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_info.png")));
		mnInfo.setBorder(null);
		mnInfo.setFont(new Font("Open Sans", Font.BOLD, 18));
		menuBar.add(mnInfo);
		{
			JMenu mntmHelp = new JMenu("Help");
			mnInfo.add(mntmHelp);
			{
				JMenuItem mntmFaq = new JMenuItem("FAQ");
				mntmHelp.add(mntmFaq);
			}
			{
				JMenuItem mntmDocs = new JMenuItem("Docs");
				mntmHelp.add(mntmDocs);
			}
		}
		{
			JMenuItem mntmStartAdhs = new JMenuItem("Start A.D.H.S");
			mnInfo.add(mntmStartAdhs);
		}
		{
			JMenuItem mntmAbout = new JMenuItem("About");
			mnInfo.add(mntmAbout);
		}
		{
			Component rigidArea = Box.createRigidArea(new Dimension(190, 20));
			menuBar.add(rigidArea);
		}
		{
			JMenu mnSystem = new JMenu("SYSTEM");
			mnSystem.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_system.png")));
			mnSystem.setBorder(null);
			mnSystem.setFont(new Font("Open Sans", Font.BOLD, 18));
			menuBar.add(mnSystem);
			{
				JMenuItem mntmStores = new JMenuItem("Settings");
				mntmStores.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_settings.png")));
				mnSystem.add(mntmStores);
			}
			{
				JMenu mnRemoteConfig = new JMenu("User Management");
				mnRemoteConfig.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_userManagement.png")));
				mnSystem.add(mnRemoteConfig);
				{
					JMenuItem mntmUsers = new JMenuItem("Users");
					mntmUsers.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_users.png")));
					mnRemoteConfig.add(mntmUsers);
				}
				{
					JMenuItem mntmUserroles = new JMenuItem("UserRoles");
					mntmUserroles.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_userRoles.png")));
					mnRemoteConfig.add(mntmUserroles);
				}
			}
			{
				JMenuItem mntmExit = new JMenuItem("Exit");
				mntmExit.setRolloverEnabled(true);
				mntmExit.setPressedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_shutDown_highlighted.png")));
				mntmExit.setRolloverIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_shutDown_highlighted.png")));
				mntmExit.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_shutDown.png")));
				mnSystem.add(mntmExit);
			}
		}
		
		pnl_contentWrap = new JPanel();
		pnl_contentWrap.setBackground(new Color(255, 255, 255));
		pnl_contentWrap.setBounds(10, 82, 1214, 685);
		pnl_mainWrap.add(pnl_contentWrap);
		pnl_contentWrap.setLayout(new CardLayout(0, 0));
		{
			pnl_articlesBoard = new JPanel();
			pnl_articlesBoard.setBorder(new LineBorder(new Color(51, 51, 51)));
			pnl_articlesBoard.setName("card_articlesBoard");
			pnl_articlesBoard.setOpaque(false);
			pnl_contentWrap.add(pnl_articlesBoard, "card_articlesBoard");
			pnl_articlesBoard.setLayout(null);
			
			JPanel pnl_navTree = new JPanel();
			pnl_navTree.setBorder(new LineBorder(new Color(102, 102, 102)));
			pnl_navTree.setBounds(10, 11, 302, 663);
			pnl_articlesBoard.add(pnl_navTree);
			pnl_navTree.setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				panel.setBackground(new Color(153, 204, 204));
				panel.setBounds(10, 11, 282, 641);
				pnl_navTree.add(panel);
				panel.setLayout(null);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 53, 262, 503);
					panel.add(scrollPane);
					{
						tree_entities = new JTree();
						tree_entities.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
						tree_entities.setAutoscrolls(true);
						scrollPane.setViewportView(tree_entities);
						tree_entities.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(4, 4, 4, 4)));
						tree_entities.setRowHeight(20);
						tree_entities.setFont(new Font("Consolas", Font.PLAIN, 15));
						tree_entities.setRootVisible(false);
						tree_entities.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Results")));
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					panel_1.setBackground(new Color(204, 204, 204));
					panel_1.setBounds(10, 567, 262, 60);
					panel.add(panel_1);
					panel_1.setLayout(null);
					{
						JButton button = new JButton("");
						button.setBorder(new LineBorder(new Color(255, 255, 255), 2));
						button.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_goToWebProductView_enabled.png")));
						button.setDisabledIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_goToWebProductView_disabled.png")));
						button.setContentAreaFilled(false);
						button.setBounds(10, 9, 42, 42);
						panel_1.add(button);
					}
				}
				{
					JToggleButton toggleButton = new JToggleButton("");
					btnGrp_searchResultViewport.add(toggleButton);
					toggleButton.setOpaque(true);
					toggleButton.setBackground(new Color(51, 102, 102));
					toggleButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_findGrpArticle.png")));
					toggleButton.setSelected(true);
					toggleButton.setBorder(new LineBorder(new Color(0, 0, 0)));
					toggleButton.setBounds(10, 11, 42, 42);
					panel.add(toggleButton);
				}
				{
					JToggleButton toggleButton = new JToggleButton("");
					btnGrp_searchResultViewport.add(toggleButton);
					toggleButton.setBackground(new Color(51, 102, 153));
					toggleButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@menu_searchAll.png")));
					toggleButton.setBorder(new LineBorder(new Color(0, 0, 0)));
					toggleButton.setBounds(50, 11, 42, 42);
					panel.add(toggleButton);
				}
			}
			
			JPanel pnl_treeNodeDetails = new JPanel();
			pnl_treeNodeDetails.setBackground(new Color(255, 255, 255));
			pnl_treeNodeDetails.setBorder(new LineBorder(new Color(102, 102, 102)));
			pnl_treeNodeDetails.setBounds(322, 11, 882, 663);
			pnl_articlesBoard.add(pnl_treeNodeDetails);
			pnl_treeNodeDetails.setLayout(null);
			{
				tabbedPane_articleMedia = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane_articleMedia.setBorder(UIManager.getBorder("Button.border"));
				tabbedPane_articleMedia.setBackground(new Color(255, 255, 255));
				tabbedPane_articleMedia.setOpaque(true);
				tabbedPane_articleMedia.setFont(new Font("Segoe UI", Font.BOLD, 15));
				tabbedPane_articleMedia.setBounds(10, 55, 862, 597);
				pnl_treeNodeDetails.add(tabbedPane_articleMedia);
				JPanel pnl_articleImages = new JPanel();
				pnl_articleImages.setBackground(new Color(255, 255, 255));
				tabbedPane_articleMedia.addTab("", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_images.png")), pnl_articleImages, "");
				tabbedPane_articleMedia.setDisabledIconAt(0, new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_images_disabled.png")));
				tabbedPane_articleMedia.setForegroundAt(0, new Color(0, 153, 255));
				pnl_articleImages.setLayout(null);
				{
					lbl_ArticleImageViewport = new JLabel("");
					lbl_ArticleImageViewport.setOpaque(true);
					lbl_ArticleImageViewport.setBorder(new LineBorder(new Color(102, 102, 102)));
					lbl_ArticleImageViewport.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_ArticleImageViewport.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_imageViewportPlaceholder.png")));
					lbl_ArticleImageViewport.setBounds(10, 11, 379, 379);
					pnl_articleImages.add(lbl_ArticleImageViewport);
				}
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 401, 379, 117);
					pnl_articleImages.add(scrollPane);
					{
						list_ArticleThumbs = new JList();
						list_ArticleThumbs.setLayoutOrientation(JList.HORIZONTAL_WRAP);
						scrollPane.setViewportView(list_ArticleThumbs);
						list_ArticleThumbs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						list_ArticleThumbs.setBorder(new LineBorder(new Color(0, 0, 0)));
						list_ArticleThumbs.setLayout(null);
					}
				}
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
					panel_1.setBounds(399, 11, 217, 507);
					pnl_articleImages.add(panel_1);
					panel_1.setLayout(null);
					{
						JButton btn_imgFileAdd = new JButton("");
						btn_imgFileAdd.setBounds(10, 11, 42, 42);
						panel_1.add(btn_imgFileAdd);
						btn_imgFileAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
						btn_imgFileAdd.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@btn_fileAdd.png")));
					}
					{
						JButton button = new JButton("");
						button.setBounds(62, 11, 42, 42);
						panel_1.add(button);
						button.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@btn_fileExchange.png")));
						button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					}
					{
						JButton button = new JButton("");
						button.setBounds(114, 11, 42, 42);
						panel_1.add(button);
						button.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@btn_fileDownload.png")));
						button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					}
					{
						JButton button = new JButton("");
						button.setBounds(166, 11, 42, 42);
						panel_1.add(button);
						button.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@btn_fileDelete.png")));
						button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
					}
					{
						JToggleButton toggleButton = new JToggleButton("");
						toggleButton.setBounds(10, 146, 42, 42);
						panel_1.add(toggleButton);
						toggleButton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
						btnGrp_mediaImgStatus.add(toggleButton);
						toggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						toggleButton.setSelected(true);
						toggleButton.setSelectedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_mediaEnabledSelected.png")));
						toggleButton.setContentAreaFilled(false);
						toggleButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_mediaEnabledNonSelected.png")));
					}
					{
						JToggleButton toggleButton = new JToggleButton("");
						toggleButton.setBounds(50, 146, 42, 42);
						panel_1.add(toggleButton);
						toggleButton.setBorder(new LineBorder(new Color(255, 255, 255), 2));
						btnGrp_mediaImgStatus.add(toggleButton);
						toggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						toggleButton.setSelectedIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_mediaDisabledSelected.png")));
						toggleButton.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_mediaDisabledNonSelected.png")));
						toggleButton.setContentAreaFilled(false);
					}
					{
						JSeparator separator = new JSeparator();
						separator.setBounds(10, 117, 197, 2);
						panel_1.add(separator);
					}
					{
						JLabel label = new JLabel("Image-Sizes");
						label.setBounds(10, 199, 112, 14);
						panel_1.add(label);
					}
					{
						JCheckBox checkBox = new JCheckBox("Thumb (100x100)");
						checkBox.setBounds(10, 220, 132, 23);
						panel_1.add(checkBox);
					}
					{
						JCheckBox checkBox = new JCheckBox("Medium (378x378)");
						checkBox.setBounds(10, 246, 132, 23);
						panel_1.add(checkBox);
					}
					{
						JCheckBox checkBox = new JCheckBox("Large (1280x1280)");
						checkBox.setBounds(10, 272, 132, 23);
						panel_1.add(checkBox);
					}
					{
						JLabel label = new JLabel("Shops");
						label.setBounds(10, 298, 112, 14);
						panel_1.add(label);
					}
					{
						JCheckBox checkBox = new JCheckBox("Websale ( Promondo.de)");
						checkBox.setBounds(10, 319, 165, 23);
						panel_1.add(checkBox);
					}
					{
						JCheckBox checkBox = new JCheckBox("Magento ( Wein & Koffer)");
						checkBox.setBounds(10, 345, 165, 23);
						panel_1.add(checkBox);
					}
					{
						JButton button = new JButton("");
						button.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@btn_fileSettings.png")));
						button.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
						button.setBounds(10, 64, 42, 42);
						panel_1.add(button);
					}
					{
						JLabel lblImageProperties = new JLabel("Image Properties");
						lblImageProperties.setFont(new Font("Segoe WP Semibold", Font.BOLD, 12));
						lblImageProperties.setBounds(14, 126, 194, 23);
						panel_1.add(lblImageProperties);
					}
				}
				{
					JPanel pnl_articleVideos = new JPanel();
					pnl_articleVideos.setBackground(new Color(255, 255, 255));
					tabbedPane_articleMedia.addTab("", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_videos.png")), pnl_articleVideos, null);
					tabbedPane_articleMedia.setDisabledIconAt(1, new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_videos_disabled.png")));
					pnl_articleVideos.setLayout(null);
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setOpaque(true);
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						lblNewLabel.setIcon(new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon_videoViewportPlaceholder.png")));
						lblNewLabel.setBorder(new MatteBorder(50, 1, 50, 1, (Color) new Color(0, 0, 0)));
						lblNewLabel.setBounds(145, 22, 562, 350);
						pnl_articleVideos.add(lblNewLabel);
					}
				}
				{
					JPanel pnl_articleLabels = new JPanel();
					pnl_articleLabels.setBackground(new Color(255, 255, 255));
					tabbedPane_articleMedia.addTab("", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_labels.png")), pnl_articleLabels, null);
					tabbedPane_articleMedia.setDisabledIconAt(2, new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_labels_disabled.png")));
					pnl_articleLabels.setLayout(null);
				}
				{
					JPanel pnl_articleAttachments = new JPanel();
					pnl_articleAttachments.setBackground(new Color(255, 255, 255));
					tabbedPane_articleMedia.addTab("", new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_attachments.png")), pnl_articleAttachments, null);
					tabbedPane_articleMedia.setDisabledIconAt(3, new ImageIcon(MainView2.class.getResource("/res/icons/v2/icon@tab_attachments_disabled.png")));
					pnl_articleAttachments.setLayout(null);
				}
			}
			{
				lbl_titleBarArtNr = new JLabel("#12345");
				lbl_titleBarArtNr.setBounds(10, 11, 108, 33);
				pnl_treeNodeDetails.add(lbl_titleBarArtNr);
				lbl_titleBarArtNr.setOpaque(true);
				lbl_titleBarArtNr.setBackground(new Color(255, 255, 204));
				lbl_titleBarArtNr.setBorder(new CompoundBorder(new LineBorder(new Color(102, 102, 102), 2), new EmptyBorder(5, 5, 5, 5)));
				lbl_titleBarArtNr.setFont(new Font("Source Code Pro", Font.BOLD, 14));
			}
			{
				lbl_titleBarArtName = new JLabel("Braunes Luxus-Toilettenpapier");
				lbl_titleBarArtName.setBounds(128, 11, 744, 33);
				pnl_treeNodeDetails.add(lbl_titleBarArtName);
				lbl_titleBarArtName.setOpaque(true);
				lbl_titleBarArtName.setBorder(new CompoundBorder(new LineBorder(new Color(102, 102, 102), 2), new EmptyBorder(5, 5, 5, 5)));
				lbl_titleBarArtName.setFont(new Font("Source Sans Pro", Font.PLAIN, 14));
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
		{
			JLabel lblVersion = new JLabel("Version 0.1");
			lblVersion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			lblVersion.setHorizontalAlignment(SwingConstants.RIGHT);
			lblVersion.setBounds(1074, 778, 150, 25);
			contentPane.add(lblVersion);
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
