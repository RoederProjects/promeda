package ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgInputTxtField extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtF_brandName;
	private JButton btn_ok;
	private JButton btn_cancel;

	/**
	 * Create the dialog.
	 */
	public DlgInputTxtField() {
		setBounds(100, 100, 450, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblBrandsName = new JLabel("Brand's name");
			lblBrandsName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblBrandsName.setBounds(10, 21, 89, 35);
			contentPanel.add(lblBrandsName);
		}
		{
			txtF_brandName = new JTextField();
			txtF_brandName.setFont(new Font("Tahoma", Font.BOLD, 14));
			txtF_brandName.setBounds(98, 21, 326, 35);
			contentPanel.add(txtF_brandName);
			txtF_brandName.setColumns(40);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btn_ok = new JButton("OK");
				btn_ok.setActionCommand("OK");
				buttonPane.add(btn_ok);
				getRootPane().setDefaultButton(btn_ok);
			}
			{
				btn_cancel = new JButton("Cancel");
				btn_cancel.setActionCommand("Cancel");
				buttonPane.add(btn_cancel);
			}
		}
	}

	public JButton getBtn_ok() {
		return btn_ok;
	}
	public JButton getBtn_cancel() {
		return btn_cancel;
	}
	public JTextField getTxtF_brandName() {
		return txtF_brandName;
	}
}
