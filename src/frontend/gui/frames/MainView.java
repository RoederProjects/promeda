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
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setLocationByPlatform(true);
		setSize(new Dimension(1200, 880));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("PROMEDA |old-version");
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
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(51, 153, 153));
		panel_10.setBounds(0, 0, 1234, 750);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
		JPanel pnl_topBar = new JPanel();
		pnl_topBar.setBackground(new Color(0, 102, 102));
		pnl_topBar.setBounds(10, 11, 1214, 60);
		panel_10.add(pnl_topBar);
		pnl_topBar.setLayout(null);
		
		JPanel pnl_searchField = new JPanel();
		pnl_searchField.setOpaque(false);
		pnl_searchField.setBounds(10, 11, 227, 40);
		pnl_topBar.add(pnl_searchField);
		pnl_searchField.setBackground(new Color(0, 102, 102));
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.WHITE, 4, true));
		textField.setBounds(8, 8, 150, 24);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton(">>");
		btnNewButton.setBorder(new LineBorder(Color.WHITE, 4, true));
		btnNewButton.setBounds(158, 8, 60, 24);
		pnl_searchField.setLayout(null);
		pnl_searchField.add(textField);
		pnl_searchField.add(btnNewButton);
		
		JPanel pnl_topNav = new JPanel();
		pnl_topNav.setOpaque(false);
		pnl_topNav.setBounds(332, 11, 872, 40);
		pnl_topBar.add(pnl_topNav);
		
		JMenu mn_media = new JMenu("MEDIA");
		mn_media.setArmed(true);
		mn_media.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		mn_media.setForeground(Color.WHITE);
		
		JMenu mn_mediaImages = new JMenu("Images");
		mn_media.add(mn_mediaImages);
		
		JMenuItem mntmGenerateImagesFrom = new JMenuItem("Generate Images From Originals");
		mn_mediaImages.add(mntmGenerateImagesFrom);
		
		JMenu mnADHS = new JMenu("A.D.H.S");
		mnADHS.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		mnADHS.setForeground(Color.WHITE);
		
		JMenu mnSettings = new JMenu("SETTINGS");
		mnSettings.setHorizontalTextPosition(SwingConstants.LEFT);
		mnSettings.setHorizontalAlignment(SwingConstants.LEFT);
		mnSettings.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		mnSettings.setForeground(Color.WHITE);
		GroupLayout gl_pnl_topNav = new GroupLayout(pnl_topNav);
		gl_pnl_topNav.setHorizontalGroup(
			gl_pnl_topNav.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnl_topNav.createSequentialGroup()
					.addComponent(mn_media, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(mnADHS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(mnSettings, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(495, Short.MAX_VALUE))
		);
		gl_pnl_topNav.setVerticalGroup(
			gl_pnl_topNav.createParallelGroup(Alignment.LEADING)
				.addComponent(mn_media, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addComponent(mnADHS, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
				.addComponent(mnSettings, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
		);
		pnl_topNav.setLayout(gl_pnl_topNav);
		
		JMenu mnInfo = new JMenu("INFO");
		mnInfo.setBounds(719, 11, 94, 40);
		pnl_topBar.add(mnInfo);
		mnInfo.setHorizontalAlignment(SwingConstants.LEFT);
		mnInfo.setHorizontalTextPosition(SwingConstants.LEFT);
		mnInfo.setIconTextGap(0);
		mnInfo.setForeground(Color.WHITE);
		mnInfo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 82, 1214, 657);
		panel_10.add(panel_1);
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
		panel_5.setBackground(new Color(0, 0, 255));
		panel_5.setBounds(10, 11, 376, 244);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBackground(new Color(0, 102, 102));
		menuBar.setBounds(0, 0, 97, 65);
		panel_5.add(menuBar);
		{
			JMenu mnMedia = new JMenu("Media");
			mnMedia.setContentAreaFilled(false);
			mnMedia.setBackground(new Color(0, 102, 102));
			menuBar.add(mnMedia);
			{
				JMenu mnImages = new JMenu("Images");
				mnImages.setOpaque(true);
				mnImages.setBackground(new Color(204, 0, 102));
				mnMedia.add(mnImages);
				{
					JMenuItem mntmCreateFromOriginals = new JMenuItem("Create from originals");
					mnImages.add(mntmCreateFromOriginals);
				}
			}
			{
				JMenu mnVideos = new JMenu("Videos");
				mnMedia.add(mnVideos);
			}
		}
		{
			JMenu mnSettigns = new JMenu("Settigns");
			menuBar.add(mnSettigns);
			{
				JCheckBoxMenuItem chckbxmntmDingsa = new JCheckBoxMenuItem("DingsA");
				buttonGroup.add(chckbxmntmDingsa);
				mnSettigns.add(chckbxmntmDingsa);
			}
			{
				JCheckBoxMenuItem chckbxmntmDingsb = new JCheckBoxMenuItem("DingsB");
				chckbxmntmDingsb.setSelected(true);
				mnSettigns.add(chckbxmntmDingsb);
			}
			{
				JCheckBoxMenuItem chckbxmntmDingsc = new JCheckBoxMenuItem("DingsC");
				mnSettigns.add(chckbxmntmDingsc);
			}
		}
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 332, 862, 292);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
	}
}
