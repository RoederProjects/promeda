package frontend.gui.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;

public class MainView_v3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPopupMenu pop_navMedia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView_v3 frame = new MainView_v3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView_v3() {
		setResizable(false);
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
		{
			pop_navMedia = new JPopupMenu();
			pop_navMedia.setSize(new Dimension(120, 200));
			pop_navMedia.setMaximumSize(new Dimension(120, 200));
			pop_navMedia.setPreferredSize(new Dimension(120, 200));
			pop_navMedia.setLightWeightPopupEnabled(false);
			contentPane.add(pop_navMedia);
			pop_navMedia.setPopupSize(new Dimension(120, 200));
			pop_navMedia.setLabel("mediapopup");
			pop_navMedia.setBounds(0, 0, 0, 0);
			{
				JMenu mnImages = new JMenu("Images");
				pop_navMedia.add(mnImages);
				{
					JMenuItem mntmNewMenuItem_1 = new JMenuItem("Generate from originals");
					mnImages.add(mntmNewMenuItem_1);
				}
			}
		}
		
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
		
		JPanel pnl_searchBar = new JPanel();
		pnl_searchBar.setBounds(0, 0, 227, 40);
		pnl_topBar.add(pnl_searchBar);
		pnl_searchBar.setOpaque(false);
		pnl_searchBar.setBackground(new Color(0, 102, 102));
		pnl_searchBar.setLayout(null);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.setBorder(new LineBorder(Color.WHITE, 4, true));
		btnNewButton.setBounds(175, 0, 52, 40);
		pnl_searchBar.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.WHITE, 4, true));
		textField.setBounds(0, 0, 178, 40);
		textField.setColumns(10);
		pnl_searchBar.add(textField);
		
		JPanel pnl_NavBar = new JPanel();
		pnl_NavBar.setOpaque(false);
		pnl_NavBar.setBounds(322, 0, 892, 40);
		pnl_topBar.add(pnl_NavBar);
		pnl_NavBar.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 102, 102), 2));
		menuBar.setBounds(0, 0, 892, 40);
		pnl_NavBar.add(menuBar);
		
		JMenu mnMedia = new JMenu("MEDIA");
		mnMedia.setFont(new Font("Open Sans", Font.BOLD, 18));
		mnMedia.setBorder(null);
		menuBar.add(mnMedia);
		
		JMenu mnImages_1 = new JMenu("Images");
		mnMedia.add(mnImages_1);
		
		JMenuItem mntmRegenerateFromOriginals = new JMenuItem("Regenerate from backup (.psd)");
		mnImages_1.add(mntmRegenerateFromOriginals);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Generate from local (.psd)");
		mnImages_1.add(mntmNewMenuItem);
		
		JMenu mnVideos = new JMenu("Videos");
		mnMedia.add(mnVideos);
		
		JMenu mnLabels = new JMenu("Labels");
		mnMedia.add(mnLabels);
		
		JMenu mnAttachments = new JMenu("Attachments");
		mnMedia.add(mnAttachments);
		{
			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			menuBar.add(rigidArea);
		}
		
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
			Component rigidArea = Box.createRigidArea(new Dimension(291, 20));
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
		pnl_contentWrap.setBounds(10, 82, 1214, 657);
		pnl_mainWrap.add(pnl_contentWrap);
		pnl_contentWrap.setLayout(null);
		
		JPanel pnl_navTree = new JPanel();
		pnl_navTree.setBounds(10, 11, 302, 635);
		pnl_contentWrap.add(pnl_navTree);
		pnl_navTree.setLayout(null);
		
		JTree tree_entities = new JTree();
		tree_entities.setBounds(10, 11, 282, 613);
		pnl_navTree.add(tree_entities);
		tree_entities.setVisibleRowCount(100);
		tree_entities.setShowsRootHandles(true);
		tree_entities.setSelectionRow(2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(322, 11, 882, 635);
		pnl_contentWrap.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 11, 376, 244);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 266, 862, 358);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		compSetup();
	}
	
	
	public void compCreate() {
		
	}
	
	public void compSetup() {
		pop_navMedia.addPopupMenuListener(new PopupPrintListener());
		
		addMouseListener(new MousePopupListener());
		
	}
	
	// An inner class to check whether mouse events are the popup trigger
	  class MousePopupListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	      checkPopup(e);
	    }

	    public void mouseClicked(MouseEvent e) {
	      checkPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	      checkPopup(e);
	    }

	    private void checkPopup(MouseEvent e) {
	      if (e.isPopupTrigger()) {
	        pop_navMedia.show(MainView_v3.this, e.getX(), e.getY());
	      }
	    }
	  }
	  
	// An inner class to show when popup events occur
	  class PopupPrintListener implements PopupMenuListener {
	    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
	      System.out.println("Popup menu will be visible!");
	    }

	    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
	      System.out.println("Popup menu will be invisible!");
	    }

	    public void popupMenuCanceled(PopupMenuEvent e) {
	      System.out.println("Popup menu is hidden!");
	    }
	  }
}
