package IHM;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Apropos extends JDialog {
	public Apropos(){
		setResizable(false);
		setTitle("A propos");
		this.setLocation(550, 200);
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		setSize(new Dimension(229, 214));
		
		JLabel lblProjet = new JLabel("<html>\r\nProjet du module IHM<br>\r\nEnseignant : Mme GUERROUJI<br>\r\nBinome :<br>\r\n-Salah Mohamed Oualid<br>\r\n-Doudou Akram<br>\r\n-Ghomari Mohamed Reda <br>\r\n </html>");
		lblProjet.setFont(new Font("Open Sans", Font.PLAIN, 14));
		lblProjet.setLocation(10, 11);
		lblProjet.setSize(lblProjet.getPreferredSize());
		getContentPane().add(lblProjet);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Apropos.this.setVisible(false);
			}
		});
		btnFermer.setBounds(67, 151, 89, 23);
		getContentPane().add(btnFermer);
		
		
	}
}
