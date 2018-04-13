package IHM;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author 6dc
 *
 * A class which creates a JTabbedPane and auto sets a close button when you add a tab
 */
public class JTabbedPaneCloseButton extends JTabbedPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> names;
	public String getName(int  i) {
		return names.get(i);
	}

	public void setName(String name, int i) {
		this.names.set(i, name);
	}
	MainWindow f;
	
    public JTabbedPaneCloseButton() {
    	super();
    	names = new ArrayList<String>();
    }
    
    public void setContainer(MainWindow f){
    	
    	this.f = f;
    	
    }
    
    public boolean checkName(String name){
    	
    	for(int i=0; i < names.size(); i++){
    		
    		if(names.get(i).equals(name)){
    			return true;
    			
    		}
    		
    	}
    	return false;
    	
    }

    
    public void addTab(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
        int count = this.getTabCount() - 1;
        setTabComponentAt(count, new CloseButtonTab(component, title, icon));
    }

    @Override
    public void addTab(String title, Icon icon, Component component) {
        addTab(title, icon, component, null);
    }

    @Override
    public void addTab(String title, Component component) {
        addTab(title, null, component);
    }
    
    public void addTab(String title, Component component, String name) {
        addTab(title, null, component);
        f.lightsOn(true);
        names.add(name);
    }
    
    @Override
    public void remove(Component c){
    	
    	int index = this.indexOfComponent(c);
    	names.remove(index);
    	super.remove(c);
    	if(this.getTabCount() == 0)
    		f.lightsOn(false);
    	
    }
    

    /* addTabNoExit */
    public void addTabNoExit(String title, Icon icon, Component component, String tip) {
        super.addTab(title, icon, component, tip);
    }

    public void addTabNoExit(String title, Icon icon, Component component) {
        addTabNoExit(title, icon, component, null);
    }

    public void addTabNoExit(String title, Component component) {
        addTabNoExit(title, null, component);
    }

    /* Button */
    public class CloseButtonTab extends JPanel {
        private Component tab;

        public CloseButtonTab(final Component tab, String title, Icon icon) {
            this.tab = tab;
            setOpaque(false);
            FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 3, 3);
            setLayout(flowLayout);
            JLabel jLabel = new JLabel(title);
            jLabel.setIcon(icon);
            add(jLabel);
            JButton button = new JButton(new ImageIcon("Images\\672366-x-128.png"));
            button.setMargin(new Insets(0, 0, 0, 0));
            button.addMouseListener(new CloseListener(tab));
            add(button);
        }
    }
    /* ClickListener */
    public class CloseListener implements MouseListener
    {
        private Component tab;

        public CloseListener(Component tab){
            this.tab=tab;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() instanceof JButton){
                JButton clickedButton = (JButton) e.getSource();
                JTabbedPane tabbedPane = (JTabbedPane) clickedButton.getParent().getParent().getParent();
                if(JOptionPane.showConfirmDialog(null, "Voulez vous fermer ce diagramme ?","Fermeture du diagramme", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION){
					tabbedPane.remove(tab);
            }
        }}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }
    }
	
}