package IHM;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import UMLEditor.UMLJlabel;
import UMLEditor.UMLStatesType;
import UMLEditor.UMLTypes;
import UMLEditor.UMLlink;
import UMLEditor.UMLlinkType;
import UMLEditor.costumeDropComponent;



//import org.eclipse.wb.swing.FocusTraversalOnArray;




@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	//private JTabbedPane onglet;
	private JFrame frmEditeurDeDessin;
	private final JButton button = new JButton("");
	private final JButton button_1 = new JButton("");
	private final JButton button_2 = new JButton("");
	private final JButton button_5 = new JButton("");
	private final JButton button_6 = new JButton("");
	private final JButton button_4 = new JButton("");
	private final JMenuItem mntmNouveau = new JMenuItem("Nouveau diagramme");
	private final JMenuItem mntmOuvrir = new JMenuItem("Ouvrir");
	private final JMenuItem mntmEnregistrer = new JMenuItem("Enregistrer");
	private final JMenuItem mntmEditionDesAttribus = new JMenuItem("Edition des attribut");
	private final JMenuItem mntmGrerLesLien = new JMenuItem("G\u00E9rer les liens");
	private final JMenuItem mntmSupprimerLeDiagramme = new JMenuItem("Supprimer le diagramme");
	private final JMenuItem mntmNewMenuItem = new JMenuItem("Supprimer tout les liens");
	private final JMenuItem mntmNewMenuItem_1 = new JMenuItem("Vider le diagramme");
	private final JMenu mnAide = new JMenu("Aide?");
	private final JMenuItem mntmBienvenue = new JMenuItem("Bienvenue");
	private final JSeparator separator = new JSeparator();
	private final JMenuItem mntmAPropos = new JMenuItem("A propos");
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmAide = new JMenuItem("Tutoriels et aide");
	private JTabbedPaneCloseButton tabbedPan = new JTabbedPaneCloseButton();
	
	/**
	 * Launch the application.
	 */
	
	public void lightsOn(boolean on){
		
		button.setEnabled(on);
		button_1.setEnabled(on);
		button_2.setEnabled(on);
		button_5.setEnabled(on);
		button_6.setEnabled(on);
		button_4.setEnabled(on);
		mntmEnregistrer.setEnabled(on);
		mntmEditionDesAttribus.setEnabled(on);
		mntmGrerLesLien.setEnabled(on);
		mntmSupprimerLeDiagramme.setEnabled(on);
		mntmNewMenuItem.setEnabled(on);
		mntmNewMenuItem_1.setEnabled(on);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmEditeurDeDessin.setVisible(true);
					Bienvenue b = new Bienvenue();
					b.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize(){
		frmEditeurDeDessin = new JFrame();
		frmEditeurDeDessin.getContentPane().setBackground(Color.GRAY);
		frmEditeurDeDessin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmEditeurDeDessin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			
				if(JOptionPane.showConfirmDialog(null, "Voulez vous quitter le programme","Quitter", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					frmEditeurDeDessin.dispose();
					
			}
			
			}
		});
		frmEditeurDeDessin.setTitle("Editeur de dessin UML");
		frmEditeurDeDessin.setBounds(0, 0, 1368, 718);
		frmEditeurDeDessin.setMinimumSize(new Dimension(1366, 500));
		frmEditeurDeDessin.setResizable(true);
		frmEditeurDeDessin.getContentPane().setLayout(new BoxLayout(frmEditeurDeDessin.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		
		tabbedPan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPan.setContainer(this);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setMaximumSize(new Dimension(10000, 100));
		frmEditeurDeDessin.getContentPane().add(panel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		panel.add(toolBar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Nouveau diagramme");
		toolBar.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewDiagrammeWindow f = new NewDiagrammeWindow(tabbedPan);
				f.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("Images\\New_File.png"));
		
		JButton button_3 = new JButton("");
		button_3.setToolTipText("Ouvrir un diagramme ");
		button_3.setIcon(new ImageIcon("Images\\Open-icon.png"));
		toolBar.add(button_3);
		
		 
		
		button_4.setEnabled(false);
		button_4.setToolTipText("Enregistrer le diagramme actuel");
		button_4.setIcon(new ImageIcon("Images\\Save-icon.png"));
		toolBar.add(button_4);
		
		toolBar.addSeparator();
		button.setEnabled(false);
		
		button_4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser saveFile = new JFileChooser();
				saveFile.setFileFilter(new FileNameExtensionFilter("Fichier uml", "uml"));
				saveFile.showSaveDialog(MainWindow.this);
				saveDiagramme(saveFile.getSelectedFile());
				JOptionPane.showMessageDialog(MainWindow.this, "Diagramme sauvegardé avec succées", "Succées", JOptionPane.INFORMATION_MESSAGE);
				
			}
			
			
		});
		
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser openFile = new JFileChooser();
				openFile.setFileFilter(new FileNameExtensionFilter("Fichier uml", "uml"));
				openFile.showOpenDialog(MainWindow.this);
				//System.out.println(openFile.getSelectedFile().getAbsolutePath());
				openProject(openFile.getSelectedFile());
				JOptionPane.showMessageDialog(MainWindow.this, "Diagramme ouvert avec succées", "Succées", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponentAt(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.changeUMLDialog();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un élément du diagramme !!!", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		
		button.setToolTipText("Editer les propri\u00E9tes");
		toolBar.add(button);
		button.setIcon(new ImageIcon("Images\\Actions-document-edit-icon.png"));
		button_1.setEnabled(false);
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				costumeDropComponent panel = ((Diagramme_pannel)tabbedPan.getComponentAt(tabbedPan.getSelectedIndex())).getPanel();
				if(panel.getSelection() != null){
					
					panel.linkManage(panel.getSelection());
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un élément du diagramme !!!", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		button_1.setToolTipText("G\u00E9rer les liens");
		toolBar.add(button_1);
		button_1.setIcon(new ImageIcon("Images\\editLink.png"));
		button_2.setEnabled(false);
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponentAt(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.removeComponent();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un élément du diagramme !!!", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
				
			}
		});
		button_2.setToolTipText("Supprimer");
		button_2.setIcon(new ImageIcon("Images\\delete-xxl.png"));
		toolBar.add(button_2);
		button_5.setEnabled(false);
		
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponentAt(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.removeAllLinks();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un élement du diagramme !!!", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		button_5.setToolTipText("Supprimer tous les liens");
		button_5.setIcon(new ImageIcon("Images\\supprimerLesLien.png"));
		toolBar.add(button_5);
		button_6.setEnabled(false);
		
		
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costumeDropComponent panel = ((Diagramme_pannel)tabbedPan.getComponentAt(tabbedPan.getSelectedIndex())).getPanel();
				panel.removeAll();
			}
		});
		button_6.setToolTipText("Vider le tous");
		button_6.setIcon(new ImageIcon("Images\\wipe-97583_960_720.png"));
		toolBar.add(button_6);
		
		tabbedPan.setBackground(new Color(95, 158, 160));
		frmEditeurDeDessin.getContentPane().add(tabbedPan);
		//tabbedPan.setAlignmentX(Component.LEFT_ALIGNMENT);
		//tabbedPan.setBackground(SystemColor.inactiveCaptionBorder);
		
		/*Panneau panneau = new Panneau(UMLTypes.DiagrammeDeClass);
		frmEditeurDeDessin.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{toolBar, tglbtnActeur, tglbtnCasDutilisation, tglbtnEtatInitial, tglbtnEtatFinal, tglbtnClasse, tglbtnObjet, tabbedPan, panneau}));
			*/	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frmEditeurDeDessin.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		
		mntmNouveau.setIcon(new ImageIcon("Images\\New_File.png"));
		mnFichier.add(mntmNouveau);
		mntmOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser openFile = new JFileChooser();
				openFile.setFileFilter(new FileNameExtensionFilter("Fichier uml", "uml"));
				openFile.showOpenDialog(MainWindow.this);
				//System.out.println(openFile.getSelectedFile().getAbsolutePath());
				openProject(openFile.getSelectedFile());
				JOptionPane.showMessageDialog(MainWindow.this, "Diagramme ouvert avec succées", "Succées", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		mntmOuvrir.setIcon(new ImageIcon("Images\\Open-icon.png"));
		mnFichier.add(mntmOuvrir);
		mntmEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveFile = new JFileChooser();
				saveFile.setFileFilter(new FileNameExtensionFilter("Fichier uml", "uml"));
				saveFile.showSaveDialog(MainWindow.this);
				saveDiagramme(saveFile.getSelectedFile());
				JOptionPane.showMessageDialog(MainWindow.this, "Diagramme sauvegardé avec succées", "Succées", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmEnregistrer.setEnabled(false);
		
		
		mntmEnregistrer.setIcon(new ImageIcon("Images\\Save-icon.png"));
		mnFichier.add(mntmEnregistrer);
		
		JMenu mnEdition = new JMenu("Edition");
		menuBar.add(mnEdition);
		
		
		mntmEditionDesAttribus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.changeUMLDialog();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un diagramme", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		mntmEditionDesAttribus.setEnabled(false);
		mntmEditionDesAttribus.setIcon(new ImageIcon("Images\\Actions-document-edit-icon.png"));
		mnEdition.add(mntmEditionDesAttribus);
		mntmGrerLesLien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costumeDropComponent panel = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel();
				if(panel.getSelection() != null){
					
					panel.linkManage(panel.getSelection());
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un diagramme", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		
		
		mntmGrerLesLien.setEnabled(false);
		mntmGrerLesLien.setIcon(new ImageIcon("Images\\editLink.png"));
		mnEdition.add(mntmGrerLesLien);
		mntmSupprimerLeDiagramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.removeComponent();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un diagramme", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		
		
		mntmSupprimerLeDiagramme.setEnabled(false);
		mntmSupprimerLeDiagramme.setIcon(new ImageIcon("Images\\delete-xxl.png"));
		mnEdition.add(mntmSupprimerLeDiagramme);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UMLJlabel uml = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel().getSelection();
				if(uml != null){
					
					uml.removeAllLinks();
					
				}else{
					
					JOptionPane.showMessageDialog(panel, "Veuillez selectioner un diagramme", "Erreur",
					        JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		
		
		mntmNewMenuItem.setEnabled(false);
		mntmNewMenuItem.setIcon(new ImageIcon("Images\\supprimerLesLien.png"));
		mnEdition.add(mntmNewMenuItem);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				costumeDropComponent panel = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel();
				panel.removeAll();
			}
		});
		
		
		mntmNewMenuItem_1.setEnabled(false);
		mntmNewMenuItem_1.setIcon(new ImageIcon("Images\\wipe-97583_960_720.png"));
		mnEdition.add(mntmNewMenuItem_1);
		
		menuBar.add(mnAide);
		
		mntmBienvenue.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Bienvenue b = new Bienvenue();
				b.setVisible(true);
				
			}
			
			
		});
		
		mnAide.add(mntmBienvenue);
		
		mnAide.add(separator);
		
		mnAide.add(separator_1);
		mntmAide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aide b = new Aide();
				b.setVisible(true);
			}
		});
		
		mnAide.add(mntmAide);
		
		mntmAPropos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Apropos b = new Apropos();
				b.setVisible(true);
				
			}
			
			
		});
		
		mnAide.add(mntmAPropos);
		mntmNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewDiagrammeWindow f = new NewDiagrammeWindow(tabbedPan);
				f.setVisible(true);
				
			}
		    });
		;
	
	}

public void openProject(File fileName){
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	try {
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.parse(fileName);
		String title = dom.getElementsByTagName("title").item(0).getTextContent();
		String type = dom.getElementsByTagName("type").item(0).getTextContent();
		if(tabbedPan.checkName(title)){
			
			JOptionPane.showMessageDialog(this, "Le diagramme est deja ouvert");
			return;
			
		}
		Diagramme_pannel p;
		switch(type){
		
			case "Diagramme Etat Transition":
				p = new Diagramme_pannel(UMLTypes.DiagrammeEtatTransition);
				tabbedPan.addTab(title + " : " + type,p, title);
		    	tabbedPan.setSelectedIndex(tabbedPan.getTabCount()-1);
			break;
			case "Diagramme de Class":
				p = new Diagramme_pannel(UMLTypes.DiagrammeDeClass);
				tabbedPan.addTab(title + " : " + type,p, title);
		    	tabbedPan.setSelectedIndex(tabbedPan.getTabCount()-1);
			break;
			case "Digramme D'objets":
				p = new Diagramme_pannel(UMLTypes.DiagrammeDObjets);
				tabbedPan.addTab(title + " : " + type,p, title);
		    	tabbedPan.setSelectedIndex(tabbedPan.getTabCount()-1);
			break;
			case "Diagramme Cas D'utilisatsion":
				p = new Diagramme_pannel(UMLTypes.DiagrammeCasDUtilisatsion);
				tabbedPan.addTab(title + " : " + type, p, title);
		    	tabbedPan.setSelectedIndex(tabbedPan.getTabCount()-1);
			break;
			default:
				p = new Diagramme_pannel(UMLTypes.DiagrammeDeClass);
			break;
		
		}
		
		NodeList umls = dom.getElementsByTagName("uml");
		for(int i=0; i < umls.getLength();i++){
			Element uml = (Element)umls.item(i);
			String umlType = uml.getElementsByTagName("type").item(0).getTextContent();
			String name = uml.getElementsByTagName("name").item(0).getTextContent();
			String propriete = uml.getElementsByTagName("propriete").item(0).getTextContent();
			String methode = uml.getElementsByTagName("methode").item(0).getTextContent();
			int X = Integer.parseInt(uml.getElementsByTagName("X").item(0).getTextContent());
			int Y = Integer.parseInt(uml.getElementsByTagName("Y").item(0).getTextContent());
			int id = Integer.parseInt(uml.getAttribute("id"));
			
			/*for(int j=0;j < items.getLength(); j++)
				System.out.println(items.item(j).getTextContent() + " : " + items.item(j).getNodeName());
			*/
			switch(umlType){
				
				case "etat":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.Etat, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "etatEnitial":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.EtatEnitial, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "etatFinale":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.EtatFinale, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "class":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.Class, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "objet":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.Objet, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "Acteur":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.Acteur, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				case "Cas":{
					UMLJlabel Class = new UMLJlabel(UMLStatesType.CasDutilisation, X, Y, p.getPanel());
					Class.setName(name);
					Class.setProprite(propriete);
					Class.setMethodes(methode);
					Class.setComponentNumber(id);
					Class.repaintUML();
					p.getPanel().add(Class);
					p.getPanel().setComponentZOrder(Class, 0);
				}break;
				
			
			}
			
		}
		NodeList links = dom.getElementsByTagName("link");
		for(int i=0;i < links.getLength();i++){
			
			Element Elink = (Element)links.item(i);
			String linkType = Elink.getAttribute("Type");
			int idBegin = Integer.parseInt(Elink.getAttribute("from"));
			int idEnd = Integer.parseInt(Elink.getAttribute("to"));
			switch(linkType){
			
				case "Assosiation":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.Assosiation);
				break;
				case "Heritage / lien normale":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.HeritageEtNormale);
				break;
				case "Aggregation":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.aggregation);
				break;
				case "Composition":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.composition);
				break;
				case "Include":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.include);
				break;
				case "Extend":
					p.getPanel().addLink(p.getPanel().getComponentIndex(idBegin), p.getPanel().getComponentIndex(idEnd), UMLlinkType.extend);
				break;
				
			
			}
			
			p.getPanel().repaint();
			
		}
		
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void saveDiagramme(File fileName){
	
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	Element e;
	try {
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document dom = db.newDocument();
		
		Element root = dom.createElement("Diagramme");
		
		e = dom.createElement("title");
		e.appendChild(dom.createTextNode(tabbedPan.getName(tabbedPan.getSelectedIndex())));
		root.appendChild(e);
		
		e = dom.createElement("type");
		e.appendChild(dom.createTextNode(((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getType().toString()));
		root.appendChild(e);
		
		Element UMLS = dom.createElement("UMLS");
		costumeDropComponent c = ((Diagramme_pannel)tabbedPan.getComponent(tabbedPan.getSelectedIndex())).getPanel();
		//System.out.println(c.getComponentCount());
		for(int i=0;i < c.getComponentCount(); i++){
			
			UMLJlabel label = (UMLJlabel)c.getComponent(i);
			Element uml = dom.createElement("uml");
			uml.setAttribute("id", String.valueOf(label.getComponentNumber()));
			
			Element type = dom.createElement("type");
			type.appendChild(dom.createTextNode(label.getType().toString()));
			uml.appendChild(type);
			
			Element name = dom.createElement("name");
			name.appendChild(dom.createTextNode(label.getName()));
			uml.appendChild(name);
			
			Element propriete = dom.createElement("propriete");
			propriete.appendChild(dom.createTextNode(label.getPropriete()));
			uml.appendChild(propriete);
			
			Element methode = dom.createElement("methode");
			methode.appendChild(dom.createTextNode(label.getMethode()));
			uml.appendChild(methode);
			
			Element X = dom.createElement("X");
			X.appendChild(dom.createTextNode(String.valueOf(label.getX())));
			uml.appendChild(X);
			
			Element Y = dom.createElement("Y");
			Y.appendChild(dom.createTextNode(String.valueOf(label.getY())));
			uml.appendChild(Y);
			
			
			
			UMLS.appendChild(uml);
			
		}
		Element Links = dom.createElement("links");
		
		ArrayList<UMLlink> links = c.getLinks();
		for(int j=0; j < links.size(); j++){
			
			Element Link = dom.createElement("link");
			Link.setAttribute("from", String.valueOf(links.get(j).getUMLstart().getComponentNumber()));
			Link.setAttribute("to", String.valueOf(links.get(j).getUMLend().getComponentNumber()));
			Link.setAttribute("Type", links.get(j).getLinkType().toString());
			Links.appendChild(Link);
		}
		
		root.appendChild(Links);
		
		root.appendChild(UMLS);
		
		dom.appendChild(root);
		try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "roles.dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            FileOutputStream s = new FileOutputStream(fileName); 
            tr.transform(new DOMSource(dom), 
                                 new StreamResult(s));
            s.close();

        } catch (TransformerException te) {
            System.out.println(te.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
	} catch (ParserConfigurationException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}

	
	public JFrame getFrmEditeurDeDessin() {
		return frmEditeurDeDessin;
	}

	public void setFrmEditeurDeDessin(JFrame frmEditeurDeDessin) {
		this.frmEditeurDeDessin = frmEditeurDeDessin;
	}
}