package ui.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ui.controller.ViewController;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Toolkit;

public class ImgWzrdView extends JFrame {

	private JPanel contentPane;
	private ViewController controller;
	private JButton btn_selectFiles;
	private JButton btn_removeFiles;
	private JButton btn_clearFilesList;
	private JList<File> list_files;
	private JPanel pnl_card1;
	private JPanel pnl_card2;
	private JButton btn_card1Next;
	private JButton btn_card2Next;
	private JButton btn_card2Back;
	private JButton btn_card1Cancel;
	private JButton btn_card2Cancel;
	private JPanel pnl_card3;
	private JButton btn_card3Next;
	private JButton btn_card3Back;
	private JButton btn_card3Cancel;
	private JButton btn_card4Start;
	private JButton btn_card4Back;
	private JButton btn_card4Cancel;
	private JLabel lbl_test;

	
	public ImgWzrdView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImgWzrdView.class.getResource("/res/icons/v2/Export.png")));
		
		/**
		 * Init ViewController
		 */
		this.controller = new ViewController();
		/**
		 * Create the frame.
		 */
		setTitle("PROMEDA | Image Wizard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		{
			pnl_card1 = new JPanel();
			contentPane.add(pnl_card1, "card1");
			pnl_card1.setLayout(null);
			{
				JPanel pnl_stepView = new JPanel();
				pnl_stepView.setBounds(0, 0, 185, 350);
				pnl_card1.add(pnl_stepView);
				pnl_stepView.setLayout(null);
				{
					JLabel lblSelectFiles = new JLabel("1. Select Files");
					lblSelectFiles.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblSelectFiles.setBounds(10, 11, 190, 29);
					pnl_stepView.add(lblSelectFiles);
				}
				{
					JLabel lblSelectImage = new JLabel("2. Select Image Options");
					lblSelectImage.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblSelectImage.setBounds(10, 51, 190, 29);
					pnl_stepView.add(lblSelectImage);
				}
				{
					JLabel lblSelectUpload = new JLabel("3. Select Upload Options");
					lblSelectUpload.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblSelectUpload.setBounds(10, 91, 190, 29);
					pnl_stepView.add(lblSelectUpload);
				}
				{
					JLabel lblSummary = new JLabel("4. Summary");
					lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblSummary.setBounds(10, 131, 190, 29);
					pnl_stepView.add(lblSummary);
				}
				{
					JLabel lblProcessing = new JLabel("5. Processing");
					lblProcessing.setFont(new Font("Tahoma", Font.PLAIN, 13));
					lblProcessing.setBounds(10, 171, 190, 29);
					pnl_stepView.add(lblProcessing);
				}
			}
			{
				JPanel pnl_title = new JPanel();
				pnl_title.setFont(new Font("Tahoma", Font.PLAIN, 12));
				pnl_title.setBounds(206, 0, 343, 39);
				pnl_card1.add(pnl_title);
				pnl_title.setLayout(null);
				{
					JLabel lblSelectThePsd = new JLabel("Select the PSD Files you want to load into the Online-Shops");
					lblSelectThePsd.setForeground(new Color(102, 102, 102));
					lblSelectThePsd.setBounds(10, 11, 284, 14);
					pnl_title.add(lblSelectThePsd);
				}
			}
			{
				JPanel pnl_content = new JPanel();
				pnl_content.setBounds(206, 50, 343, 300);
				pnl_card1.add(pnl_content);
				pnl_content.setLayout(null);
				{
					list_files = new JList<File>();
					list_files.setFont(new Font("Calibri Light", Font.BOLD, 14));
					list_files.setVisibleRowCount(20);
					list_files.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					list_files.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 204, 204), new Color(0, 153, 153)), new EmptyBorder(4, 4, 4, 4)));
					list_files.setBounds(10, 11, 223, 278);
					pnl_content.add(list_files);
				}
				{
					btn_selectFiles = new JButton("Add Files");
					btn_selectFiles.setBounds(243, 11, 89, 23);
					pnl_content.add(btn_selectFiles);
				}
				{
					btn_removeFiles = new JButton("Remove");
					btn_removeFiles.setBounds(243, 45, 89, 23);
					pnl_content.add(btn_removeFiles);
				}
				{
					btn_clearFilesList = new JButton("Clear List");
					btn_clearFilesList.setBounds(244, 79, 89, 23);
					pnl_content.add(btn_clearFilesList);
				}
			}
			{
				JPanel pnl_footerNav = new JPanel();
				pnl_footerNav.setBackground(new Color(255, 255, 255));
				pnl_footerNav.setBounds(0, 368, 558, 50);
				pnl_card1.add(pnl_footerNav);
				pnl_footerNav.setLayout(null);
				{
					btn_card1Cancel = new JButton("Cancel");
					btn_card1Cancel.setBounds(10, 11, 65, 23);
					pnl_footerNav.add(btn_card1Cancel);
				}
				{
					btn_card1Next = new JButton("Next");
					btn_card1Next.setBounds(451, 11, 82, 23);
					pnl_footerNav.add(btn_card1Next);
				}
			}
			{
				JSeparator sep_vert = new JSeparator();
				sep_vert.setBounds(195, 0, 1, 361);
				pnl_card1.add(sep_vert);
				sep_vert.setOrientation(SwingConstants.VERTICAL);
			}
			{
				JSeparator sep_hori = new JSeparator();
				sep_hori.setBounds(1, 361, 557, 2);
				pnl_card1.add(sep_hori);
			}
		}
		{
			pnl_card2 = new JPanel();
			pnl_card2.setLayout(null);
			contentPane.add(pnl_card2, "card2");
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(206, 50, 343, 300);
				pnl_card2.add(panel_1);
				{
					JLabel lblImagesizes = new JLabel("Image-Sizes");
					lblImagesizes.setBounds(6, 18, 112, 14);
					panel_1.add(lblImagesizes);
				}
				{
					JCheckBox chckbxThumb = new JCheckBox("Thumb (100x100)");
					chckbxThumb.setBounds(6, 39, 132, 23);
					panel_1.add(chckbxThumb);
				}
				{
					JCheckBox chckbxMediumx = new JCheckBox("Medium (378x378)");
					chckbxMediumx.setBounds(6, 65, 132, 23);
					panel_1.add(chckbxMediumx);
				}
				{
					JCheckBox chckbxLargex = new JCheckBox("Large (1280x1280)");
					chckbxLargex.setBounds(6, 91, 132, 23);
					panel_1.add(chckbxLargex);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel_1.setBounds(206, 0, 343, 39);
				pnl_card2.add(panel_1);
				{
					JLabel lblSelectTheImage = new JLabel("Select the Image Options");
					lblSelectTheImage.setForeground(new Color(102, 102, 102));
					lblSelectTheImage.setBounds(10, 11, 284, 14);
					panel_1.add(lblSelectTheImage);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(0, 0, 185, 350);
				pnl_card2.add(panel_1);
				{
					JLabel label = new JLabel("1. Select Files");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 11, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("2. Select Image Options");
					label.setFont(new Font("Tahoma", Font.BOLD, 13));
					label.setBounds(10, 51, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("3. Select Upload Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 91, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("4. Summary");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 131, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("5. Processing");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 171, 190, 29);
					panel_1.add(label);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(0, 368, 558, 50);
				pnl_card2.add(panel_1);
				{
					btn_card2Cancel = new JButton("Cancel");
					btn_card2Cancel.setBounds(10, 11, 65, 23);
					panel_1.add(btn_card2Cancel);
				}
				{
					btn_card2Next = new JButton("Next");
					btn_card2Next.setBounds(451, 11, 82, 23);
					panel_1.add(btn_card2Next);
				}
				{
					btn_card2Back = new JButton("Back");
					btn_card2Back.setBounds(346, 11, 82, 23);
					panel_1.add(btn_card2Back);
				}
			}
			{
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(195, 0, 1, 361);
				pnl_card2.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(1, 361, 557, 2);
				pnl_card2.add(separator);
			}
		}
		{
			pnl_card3 = new JPanel();
			pnl_card3.setLayout(null);
			contentPane.add(pnl_card3, "card3");
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(206, 50, 343, 300);
				pnl_card3.add(panel_1);
				{
					JLabel lblShops = new JLabel("Shops");
					lblShops.setBounds(6, 18, 112, 14);
					panel_1.add(lblShops);
				}
				{
					JCheckBox chckbxWebsalePromondode = new JCheckBox("Websale ( Promondo.de)");
					chckbxWebsalePromondode.setBounds(6, 39, 165, 23);
					panel_1.add(chckbxWebsalePromondode);
				}
				{
					JCheckBox chckbxMagentoWein = new JCheckBox("Magento ( Wein & Koffer)");
					chckbxMagentoWein.setBounds(6, 65, 165, 23);
					panel_1.add(chckbxMagentoWein);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel_1.setBounds(206, 0, 343, 39);
				pnl_card3.add(panel_1);
				{
					JLabel lblSelectTheUpload = new JLabel("Select the Upload Options");
					lblSelectTheUpload.setForeground(new Color(102, 102, 102));
					lblSelectTheUpload.setBounds(10, 11, 284, 14);
					panel_1.add(lblSelectTheUpload);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(0, 0, 185, 350);
				pnl_card3.add(panel_1);
				{
					JLabel label = new JLabel("1. Select Files");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 11, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("2. Select Image Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 51, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("3. Select Upload Options");
					label.setFont(new Font("Tahoma", Font.BOLD, 13));
					label.setBounds(10, 91, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("4. Summary");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 131, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("5. Processing");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 171, 190, 29);
					panel_1.add(label);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(0, 368, 558, 50);
				pnl_card3.add(panel_1);
				{
					btn_card3Cancel = new JButton("Cancel");
					btn_card3Cancel.setBounds(10, 11, 65, 23);
					panel_1.add(btn_card3Cancel);
				}
				{
					btn_card3Next = new JButton("Next");
					btn_card3Next.setBounds(451, 11, 82, 23);
					panel_1.add(btn_card3Next);
				}
				{
					btn_card3Back = new JButton("Back");
					btn_card3Back.setBounds(346, 11, 82, 23);
					panel_1.add(btn_card3Back);
				}
			}
			{
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(195, 0, 1, 361);
				pnl_card3.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(1, 361, 557, 2);
				pnl_card3.add(separator);
			}
		}
		{
			JPanel pnl_card4 = new JPanel();
			pnl_card4.setLayout(null);
			contentPane.add(pnl_card4, "card4");
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(206, 50, 343, 300);
				pnl_card4.add(panel_1);
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 11, 155, 278);
					panel_1.add(scrollPane);
					{
						JList list = new JList();
						list.setOpaque(false);
						list.setEnabled(false);
						list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(list);
					}
				}
				{
					JLabel label = new JLabel("Image-Sizes");
					label.setBounds(182, 11, 112, 14);
					panel_1.add(label);
				}
				{
					JCheckBox checkBox = new JCheckBox("Thumb (100x100)");
					checkBox.setEnabled(false);
					checkBox.setBounds(182, 32, 132, 23);
					panel_1.add(checkBox);
				}
				{
					JCheckBox checkBox = new JCheckBox("Medium (378x378)");
					checkBox.setEnabled(false);
					checkBox.setBounds(182, 58, 132, 23);
					panel_1.add(checkBox);
				}
				{
					JCheckBox checkBox = new JCheckBox("Large (1280x1280)");
					checkBox.setEnabled(false);
					checkBox.setBounds(182, 84, 132, 23);
					panel_1.add(checkBox);
				}
				{
					JLabel label = new JLabel("Shops");
					label.setBounds(182, 126, 112, 14);
					panel_1.add(label);
				}
				{
					JCheckBox checkBox = new JCheckBox("Websale ( Promondo.de)");
					checkBox.setEnabled(false);
					checkBox.setBounds(182, 147, 155, 23);
					panel_1.add(checkBox);
				}
				{
					JCheckBox checkBox = new JCheckBox("Magento ( Wein & Koffer)");
					checkBox.setEnabled(false);
					checkBox.setBounds(182, 173, 151, 23);
					panel_1.add(checkBox);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel_1.setBounds(206, 0, 343, 39);
				pnl_card4.add(panel_1);
				{
					JLabel lblSummary_1 = new JLabel("Summary");
					lblSummary_1.setForeground(new Color(102, 102, 102));
					lblSummary_1.setBounds(10, 11, 284, 14);
					panel_1.add(lblSummary_1);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBounds(0, 0, 185, 350);
				pnl_card4.add(panel_1);
				{
					JLabel label = new JLabel("1. Select Files");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 11, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("2. Select Image Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 51, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("3. Select Upload Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 91, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("4. Summary");
					label.setFont(new Font("Tahoma", Font.BOLD, 13));
					label.setBounds(10, 131, 190, 29);
					panel_1.add(label);
				}
				{
					JLabel label = new JLabel("5. Processing");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 171, 190, 29);
					panel_1.add(label);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.WHITE);
				panel_1.setBounds(0, 368, 558, 50);
				pnl_card4.add(panel_1);
				{
					btn_card4Cancel = new JButton("Cancel");
					btn_card4Cancel.setBounds(10, 11, 65, 23);
					panel_1.add(btn_card4Cancel);
				}
				{
					btn_card4Start = new JButton("Next");
					btn_card4Start.setBounds(451, 11, 82, 23);
					panel_1.add(btn_card4Start);
				}
				{
					btn_card4Back = new JButton("Back");
					btn_card4Back.setBounds(346, 11, 82, 23);
					panel_1.add(btn_card4Back);
				}
			}
			{
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(195, 0, 1, 361);
				pnl_card4.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(1, 361, 557, 2);
				pnl_card4.add(separator);
			}
		}
		{
			JPanel pnl_card5 = new JPanel();
			pnl_card5.setLayout(null);
			contentPane.add(pnl_card5, "card5");
			{
				JPanel pnl_stepView = new JPanel();
				pnl_stepView.setLayout(null);
				pnl_stepView.setBounds(0, 0, 185, 350);
				pnl_card5.add(pnl_stepView);
				{
					JLabel label = new JLabel("1. Select Files");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 11, 190, 29);
					pnl_stepView.add(label);
				}
				{
					JLabel label = new JLabel("2. Select Image Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 51, 190, 29);
					pnl_stepView.add(label);
				}
				{
					JLabel label = new JLabel("3. Select Upload Options");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 91, 190, 29);
					pnl_stepView.add(label);
				}
				{
					JLabel label = new JLabel("4. Summary");
					label.setFont(new Font("Tahoma", Font.PLAIN, 13));
					label.setBounds(10, 131, 190, 29);
					pnl_stepView.add(label);
				}
				{
					JLabel label = new JLabel("5. Processing");
					label.setFont(new Font("Tahoma", Font.BOLD, 13));
					label.setBounds(10, 171, 190, 29);
					pnl_stepView.add(label);
				}
			}
			{
				JPanel pnl_title = new JPanel();
				pnl_title.setLayout(null);
				pnl_title.setFont(new Font("Tahoma", Font.PLAIN, 12));
				pnl_title.setBounds(206, 0, 343, 39);
				pnl_card5.add(pnl_title);
				{
					JLabel lblTheWizardIs = new JLabel("The Wizard is processing your request now...");
					lblTheWizardIs.setForeground(new Color(102, 102, 102));
					lblTheWizardIs.setBounds(10, 11, 284, 14);
					pnl_title.add(lblTheWizardIs);
				}
			}
			{
				JPanel pnl_content = new JPanel();
				pnl_content.setLayout(null);
				pnl_content.setBounds(206, 50, 343, 300);
				pnl_card5.add(pnl_content);
				{
					JProgressBar progressBar = new JProgressBar();
					progressBar.setBounds(10, 265, 323, 24);
					pnl_content.add(progressBar);
				}
				{
					lbl_test = new JLabel("");
					lbl_test.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
					lbl_test.setBounds(10, 11, 323, 243);
					pnl_content.add(lbl_test);
				}
			}
			{
				JPanel pnl_footerNav = new JPanel();
				pnl_footerNav.setLayout(null);
				pnl_footerNav.setBackground(Color.WHITE);
				pnl_footerNav.setBounds(0, 368, 558, 50);
				pnl_card5.add(pnl_footerNav);
				{
					JButton button = new JButton("Cancel");
					button.setBounds(10, 11, 65, 23);
					pnl_footerNav.add(button);
				}
				{
					JButton button = new JButton("Next");
					button.setBounds(451, 11, 82, 23);
					pnl_footerNav.add(button);
				}
				{
					JButton button = new JButton("Back");
					button.setBounds(346, 11, 82, 23);
					pnl_footerNav.add(button);
				}
			}
			{
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(195, 0, 1, 361);
				pnl_card5.add(separator);
			}
			{
				JSeparator separator = new JSeparator();
				separator.setBounds(1, 361, 557, 2);
				pnl_card5.add(separator);
			}
		}
	}
	public JButton getBtn_selectFiles() {
		return btn_selectFiles;
	}
	public JButton getBtn_removeFiles() {
		return btn_removeFiles;
	}
	public JButton getBtn_clearFilesList() {
		return btn_clearFilesList;
	}
	public JList getList_files() {
		return list_files;
	}
	public JButton getBtn_card1Next() {
		return btn_card1Next;
	}
	public JPanel getPnl_card1() {
		return pnl_card1;
	}
	public JPanel getPnl_card2() {
		return pnl_card2;
	}
	public JButton getBtn_card1Cancel() {
		return btn_card1Cancel;
	}
	public JButton getBtn_card2Cancel() {
		return btn_card2Cancel;
	}
	public JButton getBtn_card2Back() {
		return btn_card2Back;
	}
	public JButton getBtn_card2Next() {
		return btn_card2Next;
	}
	public JButton getBtn_card3Next() {
		return btn_card3Next;
	}
	public JButton getBtn_card3Back() {
		return btn_card3Back;
	}
	public JButton getBtn_card3Cancel() {
		return btn_card3Cancel;
	}
	public JButton getBtn_card4Start() {
		return btn_card4Start;
	}
	public JButton getBtn_card4Back() {
		return btn_card4Back;
	}
	public JButton getBtn_card4Cancel() {
		return btn_card4Cancel;
	}
	public JLabel getLbl_test() {
		return lbl_test;
	}
}
