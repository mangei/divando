package mangei.cashmanagement.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mangei.cashmanagement.gui.layout.VerticalLayout;

public class MainWindow extends JFrame {

	private JPanel sidePanel;
	private JPanel mainPanel;
	private WelcomeView welcomeView;
	private BuchungenView buchungenView;
	private JButton bWelcome;
	private JButton bBuchungen;
	
	public MainWindow() {
		sidePanel = createSidePanel();
		mainPanel = new JPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(sidePanel, BorderLayout.WEST);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		// Show welcome screen
		bWelcome.doClick();
		
		setSize(400, 400);
	}
	
	private JPanel createSidePanel() {
		
		JPanel p = new JPanel(new VerticalLayout());
		p.add(bWelcome = new JButton(new AbstractAction("Startseite") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(welcomeView == null) {
					welcomeView = new WelcomeView();
				}
				setMainPanel(welcomeView);
			}
		}));
		
		p.add(bBuchungen = new JButton(new AbstractAction("Buchungen") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(buchungenView == null) {
					buchungenView = new BuchungenView();
				}
				setMainPanel(buchungenView);
			}
		}));
		
		return p;
	}
	
	private void setMainPanel(JPanel panel) {
		mainPanel.removeAll();
		mainPanel.add(panel);
		mainPanel.validate();
		mainPanel.repaint();
	}
	
	
}
