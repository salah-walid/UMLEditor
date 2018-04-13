/**
 * 
 */
package IHM;

import javax.swing.JDialog;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Akram
 *
 */
@SuppressWarnings("serial")
public class Aide extends JDialog {
	public Aide() {
		setResizable(false);
		this.setSize(new Dimension(772,382));
		setModalityType(ModalityType.APPLICATION_MODAL);
		getContentPane().setLayout(null);
		this.setLocation(300, 200);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images\\question-512.png"));
		setTitle("Tutoriels et aide");
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel pricipale = new JPanel();
		pricipale.setBackground(Color.WHITE);
		getContentPane().add(pricipale, "name_152640138045142");
		pricipale.setLayout(null);
		
		JLabel AidePricipale = new JLabel("Aide ?");
		AidePricipale.setIcon(new ImageIcon("Images\\help-icon-7.png_64x64.png"));
		AidePricipale.setHorizontalAlignment(SwingConstants.CENTER);
		AidePricipale.setToolTipText("");
		AidePricipale.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		AidePricipale.setBounds(255, 0, 217, 104);
		pricipale.add(AidePricipale);
		
		JPanel tutoriels = new JPanel();
		getContentPane().add(tutoriels, "name_233578243725748");
		tutoriels.setLayout(null);
		
		
		
		JPanel tutoNewDiag = new JPanel();
		tutoNewDiag.setLayout(null);
		tutoNewDiag.setBackground(Color.WHITE);
		getContentPane().add(tutoNewDiag, "name_235645036273395");
		
		JPanel tutoSaveDiag = new JPanel();
		tutoSaveDiag.setLayout(null);
		tutoSaveDiag.setBackground(Color.WHITE);
		getContentPane().add(tutoSaveDiag, "name_237007005197977");
		
		JPanel tutoOpenDiag = new JPanel();
		tutoOpenDiag.setBackground(Color.WHITE);
		getContentPane().add(tutoOpenDiag, "name_237255217272242");
		tutoOpenDiag.setLayout(null);
		
		JPanel tutoSuppLinks = new JPanel();
		tutoSuppLinks.setBackground(Color.WHITE);
		getContentPane().add(tutoSuppLinks, "name_237457660223001");
		tutoSuppLinks.setLayout(null);
		
		JPanel tutoVider = new JPanel();
		tutoVider.setBackground(Color.WHITE);
		getContentPane().add(tutoVider, "name_242518411499180");
		tutoVider.setLayout(null);
		
		
		JLabel lblTutoriels = new JLabel("Tutoriels :");
		lblTutoriels.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblTutoriels.setBounds(318, 11, 115, 20);
		tutoriels.add(lblTutoriels);
		
		JButton btnNouveauDiagramme = new JButton("Nouveau diagramme");
		btnNouveauDiagramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				tutoNewDiag.setVisible(true);
			}
		});
		btnNouveauDiagramme.setIcon(new ImageIcon("Images\\New_File.png"));
		btnNouveauDiagramme.setBounds(261, 42, 195, 34);
		tutoriels.add(btnNouveauDiagramme);
		
		JButton btnEnregistrerUnDiagramme = new JButton("Enregistrer un diagramme");
		btnEnregistrerUnDiagramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				tutoSaveDiag.setVisible(true);
			}
		});
		btnEnregistrerUnDiagramme.setIcon(new ImageIcon("Images\\Save-icon.png"));
		btnEnregistrerUnDiagramme.setBounds(261, 87, 195, 34);
		tutoriels.add(btnEnregistrerUnDiagramme);
		
		JButton btnOuvrirUnDiagramme = new JButton("Ouvrir un diagramme");
		btnOuvrirUnDiagramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				tutoOpenDiag.setVisible(true);
			}
		});
		btnOuvrirUnDiagramme.setIcon(new ImageIcon("Images\\Open-icon.png"));
		btnOuvrirUnDiagramme.setBounds(261, 132, 195, 34);
		tutoriels.add(btnOuvrirUnDiagramme);
		
		JButton btnSupprimerLesLiens = new JButton("Supprimer les liens de diagrammes");
		btnSupprimerLesLiens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				tutoSuppLinks.setVisible(true);
			}
		});
		btnSupprimerLesLiens.setIcon(new ImageIcon("Images\\supprimerLesLien.png"));
		btnSupprimerLesLiens.setBounds(261, 177, 195, 34);
		tutoriels.add(btnSupprimerLesLiens);
		
		JButton btnViderLesDiagrammes = new JButton("Vider les diagrammes");
		btnViderLesDiagrammes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				tutoVider.setVisible(true);
			}
		});
		btnViderLesDiagrammes.setIcon(new ImageIcon("Images\\wipe-97583_960_720.png"));
		btnViderLesDiagrammes.setBounds(261, 220, 195, 37);
		tutoriels.add(btnViderLesDiagrammes);
		
		JButton button_6 = new JButton("Retour au menu pricipale");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoriels.setVisible(false);
				pricipale.setVisible(true);
			}
		});
		button_6.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_6.setBounds(10, 302, 200, 41);
		tutoriels.add(button_6);
		
		
		
		
		
		JLabel lblTutorielNouveau = new JLabel("Tutoriel : Nouveau diagramme");
		lblTutorielNouveau.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTutorielNouveau.setBounds(10, 9, 218, 14);
		tutoNewDiag.add(lblTutorielNouveau);
		
		JButton button_5 = new JButton("Retour");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoNewDiag.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		button_5.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_5.setBounds(599, 277, 137, 37);
		tutoNewDiag.add(button_5);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("Images\\NewDiag.png"));
		label_5.setBounds(132, 34, 426, 302);
		tutoNewDiag.add(label_5);
		
		
		
		
		JLabel lblTutorielEnregistrer = new JLabel("Tutoriel : Enregistrer un diagramme");
		lblTutorielEnregistrer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTutorielEnregistrer.setBounds(10, 9, 218, 14);
		tutoSaveDiag.add(lblTutorielEnregistrer);
		
		JButton button_7 = new JButton("Retour");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoSaveDiag.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		button_7.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_7.setBounds(599, 277, 137, 37);
		tutoSaveDiag.add(button_7);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("Images\\SaveDiag.png"));
		label_7.setBounds(178, 34, 354, 270);
		tutoSaveDiag.add(label_7);
		
		
		
		
		JLabel lblTutorielOuvrir = new JLabel("Tutoriel : Ouvrir un diagramme");
		lblTutorielOuvrir.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTutorielOuvrir.setBounds(10, 11, 218, 14);
		tutoOpenDiag.add(lblTutorielOuvrir);
		
		JButton button_8 = new JButton("Retour");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoOpenDiag.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		button_8.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_8.setBounds(619, 274, 137, 37);
		tutoOpenDiag.add(button_8);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("Images\\OpenDiag.png"));
		label_8.setBounds(187, 68, 344, 224);
		tutoOpenDiag.add(label_8);
		
		
		
		
		JLabel lblTutorielSupprimer = new JLabel("Tutoriel : Supprimer les liens de diagrammes");
		lblTutorielSupprimer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTutorielSupprimer.setBounds(10, 11, 265, 14);
		tutoSuppLinks.add(lblTutorielSupprimer);
		
		JButton button_10 = new JButton("Retour");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoSuppLinks.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		button_10.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_10.setBounds(619, 281, 137, 37);
		tutoSuppLinks.add(button_10);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("Images\\SuppLinks1.jpg"));
		label_9.setBounds(414, 69, 316, 176);
		tutoSuppLinks.add(label_9);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("Images\\SuppLinks2.jpg"));
		label_6.setBounds(10, 44, 377, 239);
		tutoSuppLinks.add(label_6);
		
		
		
		
		JLabel lblTutorielVider = new JLabel("Tutoriel : Vider un diagramme");
		lblTutorielVider.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblTutorielVider.setBounds(10, 11, 182, 14);
		tutoVider.add(lblTutorielVider);
		
		JButton button_11 = new JButton("Retour");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tutoVider.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		button_11.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_11.setBounds(619, 284, 137, 37);
		tutoVider.add(button_11);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon("Images\\Vider.png"));
		label_10.setBounds(353, 36, 403, 228);
		tutoVider.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("Images\\Vider2.png"));
		label_11.setBounds(10, 36, 333, 249);
		tutoVider.add(label_11);
		
		JPanel ExamplesDiag = new JPanel();
		ExamplesDiag.setBackground(Color.WHITE);
		getContentPane().add(ExamplesDiag, "name_153443200200440");
		ExamplesDiag.setLayout(null);
		
		JButton btnExempleDiagrammes = new JButton("Exemples Diagrammes");
		btnExempleDiagrammes.setIcon(new ImageIcon("Images\\exampleIcon.jpg"));
		btnExempleDiagrammes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pricipale.setVisible(false);
			ExamplesDiag.setVisible(true);
			}
		});
		btnExempleDiagrammes.setBounds(265, 120, 230, 58);
		pricipale.add(btnExempleDiagrammes);
		
		
		JButton btnTutoriels = new JButton("Tutoriels");
		btnTutoriels.setIcon(new ImageIcon("Images\\tutoIcon.png"));
		btnTutoriels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pricipale.setVisible(false);
				tutoriels.setVisible(true);
			}
		});
		btnTutoriels.setBounds(265, 189, 230, 58);
		pricipale.add(btnTutoriels);
		
		JPanel ClassesGenerales = new JPanel();
		ClassesGenerales.setBackground(Color.WHITE);
		getContentPane().add(ClassesGenerales, "name_156223062388668");
		ClassesGenerales.setLayout(null);
		
		JPanel classesAssociation = new JPanel();
		classesAssociation.setBackground(Color.WHITE);
		getContentPane().add(classesAssociation, "name_153445290377249");
		classesAssociation.setLayout(null);
		
		JLabel lblExamplesDiagrammes = new JLabel("Examples Diagrammes");
		lblExamplesDiagrammes.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamplesDiagrammes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblExamplesDiagrammes.setBounds(251, 11, 228, 31);
		ExamplesDiag.add(lblExamplesDiagrammes);
		
		
		JPanel classesHeritage = new JPanel();
		classesHeritage.setBackground(Color.WHITE);
		getContentPane().add(classesHeritage, "name_156029194817283");
		classesHeritage.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Diagramme de classes");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamplesDiag.setVisible(false);
				ClassesGenerales.setVisible(true);
			}
		});
		btnNewButton.setBounds(167, 99, 176, 31);
		ExamplesDiag.add(btnNewButton);
		
		JPanel etatTransition = new JPanel();
		etatTransition.setBackground(Color.WHITE);
		getContentPane().add(etatTransition, "name_154443600224714");
		etatTransition.setLayout(null);
		
		JButton btnDiagrammeDtatTransition = new JButton("Diagramme d'\u00E9tat transition");
		btnDiagrammeDtatTransition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamplesDiag.setVisible(false);
				etatTransition.setVisible(true);
			}
		});
		btnDiagrammeDtatTransition.setBounds(375, 99, 176, 31);
		ExamplesDiag.add(btnDiagrammeDtatTransition);
		
		JPanel objets = new JPanel();
		objets.setBackground(Color.WHITE);
		getContentPane().add(objets, "name_154460631006521");
		objets.setLayout(null);
		
		
		JButton btnDiagrammeDobjets = new JButton("Diagramme d'objets");
		btnDiagrammeDobjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamplesDiag.setVisible(false);
				objets.setVisible(true);
			}
		});
		btnDiagrammeDobjets.setBounds(167, 164, 176, 31);
		ExamplesDiag.add(btnDiagrammeDobjets);
		
		JPanel casUtilisation = new JPanel();
		casUtilisation.setBackground(Color.WHITE);
		getContentPane().add(casUtilisation, "name_154441770244401");
		casUtilisation.setLayout(null);
		
		JButton btnDiagrammeDeCas = new JButton("Diagramme de cas d'utilisation");
		btnDiagrammeDeCas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamplesDiag.setVisible(false);
				casUtilisation.setVisible(true);
			}
		});
		btnDiagrammeDeCas.setBounds(375, 164, 176, 31);
		ExamplesDiag.add(btnDiagrammeDeCas);
		
		JButton btnNewButton_1 = new JButton("Retour au menu pricipale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ExamplesDiag.setVisible(false);
			pricipale.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		btnNewButton_1.setBounds(10, 289, 200, 41);
		ExamplesDiag.add(btnNewButton_1);
		
		
		
		JLabel lblDiagrammesDeClasses = new JLabel("Diagrammes de classes : ");
		lblDiagrammesDeClasses.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagrammesDeClasses.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lblDiagrammesDeClasses.setBounds(242, 23, 248, 29);
		ClassesGenerales.add(lblDiagrammesDeClasses);
		
		JButton btnAssociation = new JButton("Association");
		btnAssociation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassesGenerales.setVisible(false);
				classesAssociation.setVisible(true);
			}
		});
		btnAssociation.setBounds(119, 143, 182, 36);
		ClassesGenerales.add(btnAssociation);
		
		JButton btnHeritage = new JButton("Heritage");
		btnHeritage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassesGenerales.setVisible(false);
				classesHeritage.setVisible(true);
			}
		});
		btnHeritage.setBounds(464, 145, 183, 33);
		ClassesGenerales.add(btnHeritage);
		
		
		
		JButton btnRetourAuExamples = new JButton("Retour au examples");
		btnRetourAuExamples.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		btnRetourAuExamples.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassesGenerales.setVisible(false);
				ExamplesDiag.setVisible(true);
			}
		});
		btnRetourAuExamples.setBounds(10, 289, 200, 41);
		ClassesGenerales.add(btnRetourAuExamples);
		
		
		
		JLabel lblDiagrammeDeClasses = new JLabel("Diagramme de classes (Association) :");
		lblDiagrammeDeClasses.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDiagrammeDeClasses.setBounds(10, 11, 218, 14);
		classesAssociation.add(lblDiagrammeDeClasses);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("Images\\ClassesAssociation.png"));
		label_2.setBounds(162, 39, 386, 262);
		classesAssociation.add(label_2);
		
		JButton button_3 = new JButton("Retour");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classesAssociation.setVisible(false);
				ClassesGenerales.setVisible(true);
			}
		});
		button_3.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_3.setBounds(604, 284, 137, 37);
		classesAssociation.add(button_3);
		
		
		
		JLabel lblDiagrammeDeClasses_1 = new JLabel("Diagramme de classes (Heritage) :");
		lblDiagrammeDeClasses_1.setBounds(10, 9, 218, 14);
		lblDiagrammeDeClasses_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		classesHeritage.add(lblDiagrammeDeClasses_1);
		
		JButton button_4 = new JButton("Retour");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				classesHeritage.setVisible(false);
				ClassesGenerales.setVisible(true);
			}
		});
		button_4.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_4.setBounds(599, 277, 137, 37);
		classesHeritage.add(button_4);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("Images\\ClassesHeritage.png"));
		label_4.setBounds(171, 35, 387, 258);
		classesHeritage.add(label_4);
		
		
		
		JButton button = new JButton("Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				casUtilisation.setVisible(false);
				ExamplesDiag.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button.setBounds(592, 278, 137, 37);
		casUtilisation.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Images\\CasUtilisation.png"));
		label.setBounds(165, 53, 356, 222);
		casUtilisation.add(label);
		
		JLabel lblDiagrammeCasDutilisation = new JLabel("Diagramme Cas d'Utilisation :");
		lblDiagrammeCasDutilisation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDiagrammeCasDutilisation.setBounds(10, 11, 174, 14);
		casUtilisation.add(lblDiagrammeCasDutilisation);
		
		
		
		JButton button_2 = new JButton("Retour");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etatTransition.setVisible(false);
				ExamplesDiag.setVisible(true);
			}
		});
		button_2.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_2.setBounds(596, 277, 137, 37);
		etatTransition.add(button_2);
		
		JLabel lblDiagrammeDtatTransition = new JLabel("Diagramme d'\u00E9tat transition");
		lblDiagrammeDtatTransition.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDiagrammeDtatTransition.setBounds(10, 11, 174, 14);
		etatTransition.add(lblDiagrammeDtatTransition);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Images\\EtatTransition.png"));
		label_1.setBounds(169, 36, 384, 264);
		etatTransition.add(label_1);
		
		
		JButton button_1 = new JButton("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objets.setVisible(false);
				ExamplesDiag.setVisible(true);
			}
		});
		button_1.setIcon(new ImageIcon("Images\\returnIcon.jpg"));
		button_1.setBounds(596, 280, 137, 37);
		objets.add(button_1);
		
		JLabel lblDiagrammeDobjets = new JLabel("Diagramme d'objets :");
		lblDiagrammeDobjets.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblDiagrammeDobjets.setBounds(14, 8, 164, 16);
		objets.add(lblDiagrammeDobjets);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("Images\\Objets.png"));
		label_3.setBounds(156, 39, 382, 258);
		objets.add(label_3);
	}
}
