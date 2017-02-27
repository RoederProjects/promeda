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

public class ImageWizard extends JFrame {

	private JPanel contentPane;
	private ViewController controller;

	
	public ImageWizard() {
		
		/**
		 * Init ViewController
		 */
		this.controller = new ViewController();
		/**
		 * Create the frame.
		 */
		setTitle("PROMEDA | Image Wizard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(216, 61, 343, 300);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				JList<File> list = new JList<File>();
				list.setBackground(UIManager.getColor("OptionPane.background"));
				list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				list.setBounds(10, 11, 223, 278);
				panel.add(list);
			}
			{
				JButton btnSelectFiles = new JButton("Add Files");
				btnSelectFiles.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						File[] psdFiles = controller.openFile();
						System.out.println("array-length: " + psdFiles.length);
						for (int i=0;i<psdFiles.length;i++) {
							System.out.println("counter i: " + i);
						System.out.println(psdFiles[i].getName());
						}
					}
				});
				btnSelectFiles.setBounds(243, 11, 89, 23);
				panel.add(btnSelectFiles);
			}
			{
				JButton btnNewButton = new JButton("Remove");
				btnNewButton.setBounds(243, 45, 89, 23);
				panel.add(btnNewButton);
			}
			{
				JButton btnNewButton_1 = new JButton("Clear List");
				btnNewButton_1.setBounds(244, 79, 89, 23);
				panel.add(btnNewButton_1);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(216, 11, 343, 39);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				JLabel lblSelectThePsd = new JLabel("Select the PSD Files you want to load into the Online-Shops");
				lblSelectThePsd.setBounds(10, 11, 284, 14);
				panel.add(lblSelectThePsd);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 185, 350);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				JLabel lblSelectFiles = new JLabel("1. Select Files");
				lblSelectFiles.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblSelectFiles.setBounds(10, 11, 190, 29);
				panel.add(lblSelectFiles);
			}
			{
				JLabel lblSelectImage = new JLabel("2. Select Image Options");
				lblSelectImage.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblSelectImage.setBounds(10, 51, 190, 29);
				panel.add(lblSelectImage);
			}
			{
				JLabel lblSelectUpload = new JLabel("3. Select Upload Options");
				lblSelectUpload.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblSelectUpload.setBounds(10, 91, 190, 29);
				panel.add(lblSelectUpload);
			}
			{
				JLabel lblSummary = new JLabel("4. Summary");
				lblSummary.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblSummary.setBounds(10, 131, 190, 29);
				panel.add(lblSummary);
			}
			{
				JLabel lblProcessing = new JLabel("5. Processing");
				lblProcessing.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblProcessing.setBounds(10, 171, 190, 29);
				panel.add(lblProcessing);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 383, 549, 46);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setBounds(10, 11, 65, 23);
				panel.add(btnCancel);
			}
			{
				JButton btnNext = new JButton("OK");
				btnNext.setBounds(451, 11, 82, 23);
				panel.add(btnNext);
			}
			{
				JButton btnBack = new JButton("Back");
				btnBack.setBounds(346, 11, 82, 23);
				panel.add(btnBack);
			}
		}
		{
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(205, 11, 1, 361);
			contentPane.add(separator);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(11, 372, 548, 2);
			contentPane.add(separator);
		}
	}
}
