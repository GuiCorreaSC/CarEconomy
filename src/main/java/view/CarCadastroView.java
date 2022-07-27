package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JMenuItem;
import java.awt.ScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CarCadastroView extends JDialog {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTable table;
	private JButton btnNewButton;


	public CarCadastroView() {
		getContentPane().setForeground(Color.GREEN);
		setForeground(Color.BLACK);
		setBounds(100, 100, 450, 300);
		getContentPane().add(getTable(), BorderLayout.NORTH);
		getContentPane().add(getBtnNewButton(), BorderLayout.SOUTH);
		getContentPane().add(getPanel(), BorderLayout.WEST);
		getContentPane().add(getPanel_1(), BorderLayout.CENTER);

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setHgap(30);
			flowLayout.setVgap(6);
			panel.setBackground(Color.DARK_GRAY);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setForeground(Color.BLACK);
			FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\guitg\\Downloads\\preço-da-gasolina.gif"));
		}
		return lblNewLabel;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Login");
			btnNewButton.setForeground(Color.DARK_GRAY);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnNewButton;
	}
}
