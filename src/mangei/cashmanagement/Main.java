package mangei.cashmanagement;

import javax.swing.JFrame;

import mangei.cashmanagement.gui.MainWindow;

public class Main {
	public static void main(String[] args) {
		MainWindow w = new MainWindow();
		w.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		w.setVisible(true);
	}
}
