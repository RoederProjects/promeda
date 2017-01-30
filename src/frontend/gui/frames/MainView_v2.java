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

public class MainView_v2 extends JFrame {

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
					MainView_v2 frame = new MainView_v2();
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
	public MainView_v2() {
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
		
		JPanel pnl_mainWrap = new JPanel();
		pnl_mainWrap.setBackground(new Color(51, 153, 153));
		pnl_mainWrap.setBounds(0, 0, 1234, 750);
		contentPane.add(pnl_mainWrap);
		pnl_mainWrap.setLayout(null);
		
		JPanel pnl_topBar = new JPanel();
		pnl_topBar.setBackground(new Color(0, 102, 102));
		pnl_topBar.setBounds(10, 11, 1214, 60);
		pnl_mainWrap.add(pnl_topBar);
		pnl_topBar.setLayout(null);
		
		JPanel pnl_searchBar = new JPanel();
		pnl_searchBar.setOpaque(false);
		pnl_searchBar.setBounds(10, 11, 227, 40);
		pnl_topBar.add(pnl_searchBar);
		pnl_searchBar.setBackground(new Color(0, 102, 102));
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.WHITE, 4, true));
		textField.setBounds(8, 8, 150, 24);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBorder(new LineBorder(Color.WHITE, 4, true));
		btnNewButton.setBounds(158, 8, 60, 24);
		pnl_searchBar.setLayout(null);
		pnl_searchBar.add(textField);
		pnl_searchBar.add(btnNewButton);
		
		JPanel pnl_NavBar = new JPanel();
		pnl_NavBar.setOpaque(false);
		pnl_NavBar.setBounds(332, 11, 872, 40);
		pnl_topBar.add(pnl_NavBar);
		JButton btn_navSettings = new JButton("SETTINGS");
		btn_navSettings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_navSettings.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_navSettings.setBounds(110, 0, 112, 40);
		btn_navSettings.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btn_navSettings.setForeground(Color.WHITE);
		btn_navSettings.setBorderPainted(false);
		btn_navSettings.setContentAreaFilled(false);
		JButton btn_navMedia = new JButton("MEDIA");
		btn_navMedia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_navMedia.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_navMedia.setContentAreaFilled(false);
		btn_navMedia.setBounds(0, 0, 99, 40);
		btn_navMedia.setForeground(Color.WHITE);
		btn_navMedia.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton btn_navADHS = new JButton("A.D.H.S");
		btn_navADHS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_navADHS.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_navADHS.setBounds(228, 0, 99, 40);
		btn_navADHS.setForeground(Color.WHITE);
		btn_navADHS.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btn_navADHS.setContentAreaFilled(false);
		btn_navADHS.setBorderPainted(false);
		JButton btn_navInfo = new JButton("INFO");
		btn_navInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_navInfo.setAlignmentY(Component.TOP_ALIGNMENT);
		btn_navInfo.setBounds(337, 0, 99, 40);
		btn_navInfo.setForeground(Color.WHITE);
		btn_navInfo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btn_navInfo.setContentAreaFilled(false);
		btn_navInfo.setBorderPainted(false);
		pnl_NavBar.setLayout(null);
		pnl_NavBar.add(btn_navMedia);
		{
			pop_navMedia = new JPopupMenu();
			pop_navMedia.setAlignmentY(Component.TOP_ALIGNMENT);
			pop_navMedia.setPopupSize(new Dimension(0, 0));
			pop_navMedia.setLabel("media-popup");
			pop_navMedia.setBounds(0, 150, 112, 0);
			pnl_NavBar.add(pop_navMedia);
			{
				JMenu mnImages = new JMenu("Images");
				pop_navMedia.add(mnImages);
				{
					JMenuItem mntmNewMenuItem_1 = new JMenuItem("Generate from originals");
					mnImages.add(mntmNewMenuItem_1);
				}
			}
		}
		pnl_NavBar.add(btn_navSettings);
		pnl_NavBar.add(btn_navADHS);
		pnl_NavBar.add(btn_navInfo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 82, 1214, 657);
		pnl_mainWrap.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 302, 635);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 282, 613);
		panel_3.add(tree);
		tree.setVisibleRowCount(100);
		tree.setShowsRootHandles(true);
		tree.setSelectionRow(2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(322, 11, 882, 635);
		panel_1.add(panel_4);
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
		 pop_navMedia.addMouseListener(new MousePopupListener());
		
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
	        pop_navMedia.show(MainView_v2.this, e.getX(), e.getY());
	      }
	    }
	  }
}
