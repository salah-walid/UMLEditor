package IHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import UMLEditor.UMLJlabel;
import UMLEditor.UMLStatesType;
import UMLEditor.UMLTypes;
import UMLEditor.UMLlinkType;
import UMLEditor.costumeDragJLabel;
import UMLEditor.costumeDropComponent;

public class Diagramme_pannel extends JPanel{

	  private UMLTypes type;
	  private costumeDropComponent panel = new costumeDropComponent();
	  
	  JButton LN = new JButton("");
	  JButton LA = new JButton("");
	  JButton LAgg = new JButton("");
	  JButton LC = new JButton("");
	  JButton LI = new JButton("");
	  JButton LE = new JButton("");

	  public costumeDropComponent getPanel() {
		return panel;
	}


	  public void highlight(UMLJlabel label){
		  LN.setEnabled(false);
		  LA.setEnabled(false);
		  LAgg.setEnabled(false);
		  LC.setEnabled(false);
		  LI.setEnabled(false);
		  LE.setEnabled(false);
		  if(label != null){
			  
			  LN.setEnabled(true);
			  switch(label.getType()){
			  
			  	case Class:
			  		LA.setEnabled(true);
			  		LAgg.setEnabled(true);
			  		LC.setEnabled(true);
			  	break;
			  	case CasDutilisation:
			  		LI.setEnabled(true);
			  		LE.setEnabled(true);
			  	break;
			  	default:
			  		
			  	break;
			  }
			  
		  }
		  
	  }


	public void setPanel(costumeDropComponent panel) {
		this.panel = panel;
	}





	public Diagramme_pannel(UMLTypes type){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	  	
		JPanel p = new JPanel();
		p.setBackground(new Color(176, 196, 222));
		p.setAlignmentX(Component.LEFT_ALIGNMENT);
		p.setAlignmentY(Component.CENTER_ALIGNMENT);
		p.setMaximumSize(new Dimension(10000, 150));
	  	add(p);
	  	FlowLayout fl_p = new FlowLayout(FlowLayout.LEFT, 20, 3);
	  	p.setLayout(fl_p);
	  	//p.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10));
	  
	  	switch(type){
	  	
  		case DiagrammeCasDUtilisatsion:{
  			panel.drawSystem(true);
		  	costumeDragJLabel label_1_1 = new costumeDragJLabel("Cas d'utilisation", UMLStatesType.CasDutilisation);
		  	label_1_1.setIcon(new ImageIcon("Images\\IconCasUtilisation.png"));
		  	p.add(label_1_1);
		  	costumeDragJLabel label2 = new costumeDragJLabel("Acteur", UMLStatesType.Acteur);
		  	label2.setIcon(new ImageIcon("Images\\IconActeur.png"));
		  	p.add(label2);
		  	
		  	/*JLabel nomSystem = new JLabel("Nom du system");
		  	p.add(nomSystem);
		  	
		  	JTextField fieldSystem = new JTextField("Sans Nom");
		  	
		  	p.add(fieldSystem);
		  	*/
		  	JButton ok = new JButton("<html>Changer le<br> nom du system<html>");
		  	ok.setHorizontalAlignment(JButton.CENTER);
		  	ok.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String o = JOptionPane.showInputDialog(null, "Nom de system", "Changer le nom du system", JOptionPane.QUESTION_MESSAGE);
					panel.setSystemName(o);
					panel.repaint();
					
				}
			});
		  
		  	p.add(ok);
  		}break;
  		
  		case DiagrammeDeClass:{
  			
  			costumeDragJLabel label_1_3 = new costumeDragJLabel("Classe", UMLStatesType.Class);
  			label_1_3.setIcon(new ImageIcon("Images\\IconClasse.png"));
  			p.add(label_1_3);
  			
  			
  		}break;
  			
  		case DiagrammeDObjets:{
  			costumeDragJLabel label_1_4 = new costumeDragJLabel("Objet", UMLStatesType.Objet);
  			label_1_4.setIcon(new ImageIcon("Images\\IconObjet.png"));
  			p.add(label_1_4);
  			
  			
  		}break;
  			
  		case DiagrammeEtatTransition:{
  			costumeDragJLabel label_1_5 = new costumeDragJLabel("Etat Initial", UMLStatesType.EtatEnitial);
  			label_1_5.setIcon(new ImageIcon("Images\\point.png"));
  			p.add(label_1_5);
		 	
		  	costumeDragJLabel label_1_6 = new costumeDragJLabel("Etat Final", UMLStatesType.EtatFinale);
		  	label_1_6.setIcon(new ImageIcon("Images\\pointAvecCercle.png"));
		  	p.add(label_1_6);
		  	
		  	costumeDragJLabel label_1_7 = new costumeDragJLabel("Etat", UMLStatesType.Etat);
		  	label_1_7.setIcon(new ImageIcon("Images\\IconObjet.png"));
		  	p.add(label_1_7);
		  	
		  	
		  	
  		}break;
  	
  	}
	
	  	JSeparator s = new JSeparator(SwingConstants.VERTICAL);
		s.setBackground(Color.BLACK);
		s.setPreferredSize(new Dimension(3,40));
		p.add(s);
	  	LN.setToolTipText("Lien normal/heritage");
	  	LN.addActionListener(new ActionListener() {
	  		public void actionPerformed(ActionEvent arg0) {
	  			panel.setOrigin(panel.getSelection(), UMLlinkType.HeritageEtNormale);
	  		}
	  	});
	  	
	  	
	  	LN.setEnabled(false);
		LN.setIcon(new ImageIcon("Images\\Arrow-To-icon.png"));
		LN.setPreferredSize(new Dimension(40,40));
		p.add(LN);
		LA.setToolTipText("Association");
		LA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setOrigin(panel.getSelection(), UMLlinkType.Assosiation);
			}
		});
		
		
		LA.setEnabled(false);
		LA.setIcon(new ImageIcon("Images\\line.png"));
		LA.setPreferredSize(new Dimension(40,40));
		p.add(LA);
		LAgg.setToolTipText("Aggregation");
		LAgg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setOrigin(panel.getSelection(), UMLlinkType.aggregation);
			}
		});
		
		
		LAgg.setEnabled(false);
		LAgg.setIcon(new ImageIcon("Images\\vector-path-line.png"));
		LAgg.setPreferredSize(new Dimension(40,40));
		p.add(LAgg);
		LC.setToolTipText("Composition");
		LC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setOrigin(panel.getSelection(), UMLlinkType.composition);
			}
		});
		
		
		LC.setEnabled(false);
		LC.setIcon(new ImageIcon("Images\\composition.png"));
		LC.setPreferredSize(new Dimension(40,40));
		p.add(LC);
		LI.setToolTipText("Include");
		LI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setOrigin(panel.getSelection(), UMLlinkType.include);
			}
		});
		
		
		LI.setEnabled(false);
		LI.setIcon(new ImageIcon("Images\\import-512.png"));
		LI.setPreferredSize(new Dimension(40,40));
		p.add(LI);
		LE.setToolTipText("Extend");
		LE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setOrigin(panel.getSelection(), UMLlinkType.extend);
			}
		});
		
		
		LE.setEnabled(false);
		LE.setIcon(new ImageIcon("Images\\minicons2-35-512.png"));
		LE.setPreferredSize(new Dimension(40,40));
		p.add(LE);
	  	
	  	panel.setBackground(Color.LIGHT_GRAY);
	  	panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	  	add(panel);
	  	panel.setLayout(null);
		this.type = type;

	  }
	  
	  
		  


	public UMLTypes getType() {
		return type;
	}

	public void setType(UMLTypes type) {
		this.type = type;
	}
}