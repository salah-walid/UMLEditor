package IHM;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import UMLEditor.UMLTypes;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;


public class NewDiagrammeWindow extends JDialog {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public NewDiagrammeWindow(JTabbedPaneCloseButton onglet){
		super();
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		this.setResizable(false);
		setTitle("Nouveau Diagramme");
		setBounds(100, 100, 559, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 45, 307, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomProjet = new JLabel("Nom du diagramme  : ");
		lblNomProjet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNomProjet.setBounds(35, 54, 114, 14);
		contentPane.add(lblNomProjet);
		
		JLabel labelTypeProjet = new JLabel("Type : ");
		labelTypeProjet.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		labelTypeProjet.setBounds(103, 97, 52, 14);
		contentPane.add(labelTypeProjet);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selectionner......", "Diagramme Classes", "Diagramme Objets", "Diagramme Etat Transition", "Diagramme Cas D'Utilisation"}));
		comboBox.setBounds(159, 88, 307, 32);
		contentPane.add(comboBox);
		
		/*JButton btnChemin = new JButton("Chemin : ");
		btnChemin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setVisible(true);
				chooser.showSaveDialog(null);
				File file = chooser.getCurrentDirectory();
				String filename = file.getAbsolutePath();
				textField_1.setText(filename);
				
			}
		});
	
		btnChemin.setBounds(60, 137, 89, 23);
		contentPane.add(btnChemin);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(159, 138, 307, 20);
		contentPane.add(textField_1);
		*/
		
		JButton btnCrer = new JButton("Cr\u00E9er");	
		
		btnCrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Vous devez saisir le nom du projet !!!");
					return;
				}else if(onglet.checkName(textField.getText())){
					
					JOptionPane.showMessageDialog(null, "Ce nom exist deja veuillez saisir un autre");
					return;
					
				}
				switch(comboBox.getSelectedItem().toString()){
					
					case "Diagramme Classes":
				    	onglet.addTab(comboBox.getSelectedItem().toString() + " : " + textField.getText(),new Diagramme_pannel(UMLTypes.DiagrammeDeClass), textField.getText());
				    	onglet.setSelectedIndex(onglet.getTabCount()-1);
				    	NewDiagrammeWindow.this.setVisible(false);				    	
				    	
					break;
					case "Diagramme Objets":
						onglet.addTab(comboBox.getSelectedItem().toString() + " : " + textField.getText(),new Diagramme_pannel(UMLTypes.DiagrammeDObjets), textField.getText());
						onglet.setSelectedIndex(onglet.getTabCount()-1);
				    	NewDiagrammeWindow.this.setVisible(false);
					break;
					case "Diagramme Etat Transition":
						onglet.addTab(comboBox.getSelectedItem().toString() + " : " + textField.getText(),new Diagramme_pannel(UMLTypes.DiagrammeEtatTransition), textField.getText());
						onglet.setSelectedIndex(onglet.getTabCount()-1);
				    	NewDiagrammeWindow.this.setVisible(false);
					break;
					case "Diagramme Cas D'Utilisation":
						onglet.addTab(comboBox.getSelectedItem().toString() + " : " + textField.getText(),new Diagramme_pannel(UMLTypes.DiagrammeCasDUtilisatsion), textField.getText());
						onglet.setSelectedIndex(onglet.getTabCount()-1);
				    	NewDiagrammeWindow.this.setVisible(false);
					break;
					
					default:
						   JOptionPane.showMessageDialog(null, "Vous devez choisir un type parmi les diagrammes !!!");
					break;
				}
			}
			
		});
		btnCrer.setIcon(new ImageIcon("Images\\169-Add_charge_create_new_plus_positive_-512.png_24x24.png"));
		btnCrer.setBounds(263, 246, 114, 32);
		contentPane.add(btnCrer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setIcon(new ImageIcon("Images\\error-icon-4_png_24x24.png"));
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewDiagrammeWindow.this.setVisible(false);
			}
		});
		btnAnnuler.setBounds(397, 246, 105, 32);
		contentPane.add(btnAnnuler);
		
		

	}
	
}

