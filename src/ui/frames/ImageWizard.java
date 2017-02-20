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
		setBounds(100, 100, 784, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 125, 748, 284);
			contentPane.add(panel);
			panel.setLayout(null);
			{
				JList<File> list = new JList<File>();
				list.setBounds(27, 47, 291, 207);
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
				btnSelectFiles.setBounds(27, 13, 89, 23);
				panel.add(btnSelectFiles);
			}
		}
	}
}
