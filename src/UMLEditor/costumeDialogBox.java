package UMLEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JPanel;
import java.awt.Dialog.ModalityType;

public class costumeDialogBox extends JDialog {
	private JTextField nomTextField;
	public costumeDialogBox(JFrame parent, String title, boolean modal, UMLJlabel uml) {
		super(parent, title, modal);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
		this.setSize(498, 394);
		this.setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(30, 45, 62, 14);
		this.getContentPane().add(lblNom);
		
		nomTextField = new JTextField();
		nomTextField.setBounds(154, 40, 295, 24);
		nomTextField.setText(uml.getName());
		this.getContentPane().add(nomTextField);
		nomTextField.setColumns(10);
		JLabel lblPropriete = new JLabel("Attributs");
		lblPropriete.setBounds(30, 116, 62, 14);
		
		
		JLabel lblMethode = new JLabel("Méthodes");
		lblMethode.setBounds(30, 228, 62, 14);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 78, 295, 90);
		
		JTextArea AttributTextArea = new JTextArea();
		scrollPane.setViewportView(AttributTextArea);
		AttributTextArea.setText(uml.getPropriete());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(154, 190, 295, 90);
		
		JTextArea MethodeTextArea = new JTextArea();
		scrollPane_1.setViewportView(MethodeTextArea);
		
		
		MethodeTextArea.setText(uml.getMethode());
		
		if(uml.getType() == UMLStatesType.Class || uml.getType() == UMLStatesType.Objet){	
			this.getContentPane().add(lblPropriete);
			this.getContentPane().add(lblMethode);
			getContentPane().add(scrollPane);
			getContentPane().add(scrollPane_1);
			/*MethodeTextArea.setVisible(false);
			AttributTextArea.setVisible(false);
			lblMethode.setVisible(false);
			lblPropriete.setVisible(false);
			*/
		}
		JButton boutonOK = new JButton("OK");
		boutonOK.setBounds(154, 294, 139, 36);
		boutonOK.setIcon(new ImageIcon("Images\\sign-check-icon_png_24x24.png"));
		boutonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				uml.setName(nomTextField.getText());
				uml.setProprite(AttributTextArea.getText());
				uml.setMethodes(MethodeTextArea.getText());
				uml.repaintUML();
				costumeDialogBox.this.setVisible(false);
			}
		});
		this.getContentPane().add(boutonOK);
		
		JButton boutonAnnuler = new JButton("Annuler");
		boutonAnnuler.setBounds(303, 294, 146, 36);
		boutonAnnuler.setIcon(new ImageIcon("Images\\error-icon-4_png_24x24.png"));
		boutonAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				costumeDialogBox.this.setVisible(false);
				
			}
		});
		this.getContentPane().add(boutonAnnuler);
		
		
		
		this.setVisible(true);
	}
}
