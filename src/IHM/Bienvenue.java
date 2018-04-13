package IHM;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class Bienvenue extends JDialog {

	public Bienvenue() {
		setResizable(false);
		this.setLocation(450, 130);
		setType(Type.POPUP);
		setTitle("Bienvenue");
		setModalityType(ModalityType.APPLICATION_MODAL);
		//470,440
		this.setSize(new Dimension(470,440));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\uml_icon.png"));
		label.setLocation(112, 11);
		label.setSize(label.getPreferredSize());
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("<html>\r\nBienvenue dans le programme de cr\u00E9ation de diagramme UML<br>\r\nCe programme permet de cr\u00E9er 4 types de diagramme qui sont :<br>\r\n-Diagramme de class<br>\r\n-Diagramme d'objet<br>\r\n-Diagramme de cas d'utilisation<br>\r\n-Diagramme d'etat transition<br>\r\n</html>");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setLocation(57, 196);
		lblNewLabel.setSize(lblNewLabel.getPreferredSize());
		getContentPane().add(lblNewLabel);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bienvenue.this.setVisible(false);
			}
		});
		btnFermer.setBounds(186, 371, 89, 23);
		getContentPane().add(btnFermer);
		
	}
}
