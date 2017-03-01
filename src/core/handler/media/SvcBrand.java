package core.handler.media;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import core.bricks.Brand;
import core.handler.MySQLHandler;
import ui.dialog.DlgInputTxtField;

public class SvcBrand{

	JOptionPane optionPane_confirmAction;
	public SvcBrand() {
		optionPane_confirmAction = new JOptionPane();
	}
	public void brandAdd() {
		DlgInputTxtField inputDia = new DlgInputTxtField();
		inputDia.setAlwaysOnTop(true);
		inputDia.setVisible(true);
		
			
		inputDia.getBtn_ok().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MySQLHandler mySQLHandler = new MySQLHandler();
				String sqlQuery = "INSERT INTO pro_brands (brands_name) "
				          				  +"VALUES ('"+inputDia.getTxtF_brandName().getText()+"')";
				mySQLHandler.sqlInsertQuery(sqlQuery);
				inputDia.dispose();
			}
		});
		inputDia.getBtn_cancel().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputDia.dispose();
			}
		});
	}
	
	public void brandRemove(Object selectedBrand) {
		Brand brand = (Brand) selectedBrand;
		
	        // showOptionDialog for User Confirmation
	            int result = 0;
	            if(brand!=null) {
	            	String titleConfirm = "Warning";
		            String messageConfirm = "This will delete Brand '"+brand.getName()+"'."; 
		            Object[] optionsConfirm = {"Cancel", "Delete"};
	                //optionPane_confirmAction.setOptions(optionsConfirm);
	                result = JOptionPane.showOptionDialog(null, messageConfirm, titleConfirm, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, optionsConfirm, optionsConfirm[1]);
	            } else {
	            	String titleError = "Error";
	 	            String messageNoFiles = "No Brand is selected."; 
	 	            Object[] optionsError = {"Ok"};
	                //optionPane_confirmAction.setOptions(optionsError);
	                result = JOptionPane.showOptionDialog(null, messageNoFiles, titleError, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, optionsError, optionsError[0]);
	            }
	            
	            // Start the Import&Upload process
	            if(result==1){
	            	MySQLHandler mySQLHandler = new MySQLHandler();
	            	mySQLHandler.sqlDeleteQuery(brand.getName());
	        }
	    }

	
}
