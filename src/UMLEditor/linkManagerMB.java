package UMLEditor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class linkManagerMB extends JDialog {
	
	private CDefaultListModel<String> values1 = new CDefaultListModel<>();
	private CDefaultListModel<String> values2 = new CDefaultListModel<>();
	
	public linkManagerMB(ArrayList<UMLlink> links, costumeDropComponent drop) {
		setTitle("Modification des liens");
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		
		for(int i=0;i < links.size();i++){
			
			values1.addElement("<html><font color=red>Type : " + links.get(i).getLinkType().toString() + " : </font> " 
					+ " " + links.get(i).getUMLstart().getName() 
					+ " --> " +
					"<font color=blue>" +links.get(i).getUMLend().getName() + "</font>"
					+ "</html>",
					links.get(i));
			
		}
		
		JList<String> list1 = new JList<>(values1);
		list1.setBounds(20, 45, 353, 343);
		getContentPane().add(list1);
		
		JButton button = new JButton(">>");
		
		button.setBounds(399, 63, 57, 31);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("<<");
		
		button_1.setBounds(399, 114, 57, 31);
		getContentPane().add(button_1);
		
		JList<String> list2 = new JList<>(values2);
		list2.setBounds(487, 45, 353, 343);
		getContentPane().add(list2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setIcon(new ImageIcon("Images\\sign-check-icon_png_24x24.png"));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i < values2.size(); i++){
					
					drop.deleteLink(values2.getLink(i));
					
				}
				drop.repaint();
				linkManagerMB.this.setVisible(false);
			}
		});
		btnOk.setBounds(324, 409, 101, 31);
		getContentPane().add(btnOk);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon("Images\\error-icon-4_png_24x24.png"));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linkManagerMB.this.setVisible(false);
			}
		});
		btnAnnuler.setBounds(446, 409, 101, 31);
		getContentPane().add(btnAnnuler);
		
		JLabel lblListDesLiens = new JLabel("Liste des liens");
		lblListDesLiens.setForeground(Color.BLUE);
		lblListDesLiens.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListDesLiens.setBounds(20, 11, 89, 23);
		getContentPane().add(lblListDesLiens);
		
		JLabel lblLiensASupprimer = new JLabel("Liens a supprimer");
		lblLiensASupprimer.setForeground(Color.RED);
		lblLiensASupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLiensASupprimer.setBounds(487, 11, 116, 23);
		getContentPane().add(lblLiensASupprimer);
		setSize(new Dimension(895, 490));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selection = list1.getSelectedIndex();
				if(selection != -1){
					String element = (String)values1.getElementAt(selection);
					values2.addElement(element, values1.getLink(selection));
					values1.remove(selection);
					list2.repaint();
					list1.repaint();
				}
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = list2.getSelectedIndex();
				if(selection != -1){
					String element = (String)values2.getElementAt(selection);
					values1.addElement(element, values2.getLink(selection));
					values2.remove(selection);
					list2.repaint();
					list1.repaint();
				}
			}
		});
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
