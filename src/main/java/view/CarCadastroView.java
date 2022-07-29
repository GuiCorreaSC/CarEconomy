package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CarCadastroView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel_Btn;
	private JButton btnSalvar;
	private JButton btnLimparTudo;
	private JPanel panel_title;
	private JPanel panel_3;
	private JPanel panel_Cad;
	private JTextField textField_Modelo;
	private JPanel panel_4;
	private JTextField textField_Motor;
	private JTextField textField_Gasolina;
	private JTextField textField_Etanol;

	private CarCadastroController controlador;
	private JTextField textField_Cod;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;

	public CarCadastroView() {
		getContentPane().setBackground(Color.WHITE);
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		setSize(new Dimension(650, 450));
		setBackground(new Color(0, 0, 0));

		getContentPane().setForeground(Color.GREEN);
		getContentPane().add(getPanel_botoes(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_title(), BorderLayout.NORTH);
		getContentPane().add(getPanel_3(), BorderLayout.EAST);
		getContentPane().add(getPanel_Cad(), BorderLayout.CENTER);
		getContentPane().add(getPanel_Codigo(), BorderLayout.WEST);
		setForeground(Color.BLACK);
		setBounds(1000, 1000, 720, 440);

	}

	public CarCadastroView(Window owner, Integer codigo) { /// talvez precise commitar
		super(owner);
		setBounds(100, 100, 720, 440);
		getContentPane().add(getPanel_botoes(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_title(), BorderLayout.NORTH);
		getContentPane().add(getPanel_3(), BorderLayout.EAST);
		getContentPane().add(getPanel_Cad(), BorderLayout.CENTER);
		getContentPane().add(getPanel_Codigo(), BorderLayout.WEST);
		this.controlador = new CarCadastroController(this, codigo);
	}

	public JPanel getPanel_botoes() {
		if (panel_Btn == null) {
			panel_Btn = new JPanel();
			FlowLayout fl_panel_Btn = (FlowLayout) panel_Btn.getLayout();
			fl_panel_Btn.setHgap(10);
			panel_Btn.setBorder(new EmptyBorder(5, 5, 0, 5));
			panel_Btn.setBackground(Color.DARK_GRAY);
			panel_Btn.add(getBtnSalvar());
			panel_Btn.add(getBtnNewButton_1_1());
		}
		return panel_Btn;
	}

	public JButton getBtnSalvar() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Salvar");
			btnNewButton.addActionListener(e -> controlador.salvarCarro());
		}
		return btnNewButton;
	}

	public JButton getBtnNewButton_1_1() {
		if (btnLimparTudo == null) {
			btnLimparTudo = new JButton("Limpar tudo");
			btnLimparTudo.setBackground(Color.GRAY);
			btnLimparTudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnLimparTudo;
	}

	public JPanel getPanel_title() {
		if (panel_title == null) {
			panel_title = new JPanel();
			panel_title.setBackground(Color.DARK_GRAY);
			panel_title.setForeground(Color.RED);
			GridBagLayout gbl_panel_title = new GridBagLayout();
			gbl_panel_title.columnWidths = new int[] { 0, 0 };
			gbl_panel_title.rowHeights = new int[] { 0, 0, 0 };
			gbl_panel_title.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel_title.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			panel_title.setLayout(gbl_panel_title);
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 0;
			panel_title.add(getLblNewLabel_1(), gbc_lblNewLabel_1);
		}
		return panel_title;
	}

	public JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setVgap(50);
			flowLayout.setHgap(50);
			panel_3.setBackground(Color.DARK_GRAY);
		}
		return panel_3;
	}

	public JPanel getPanel_Cad() {
		if (panel_Cad == null) {
			panel_Cad = new JPanel();
			panel_Cad.setBackground(Color.DARK_GRAY);
			GridBagLayout gbl_panel_Cad = new GridBagLayout();
			gbl_panel_Cad.columnWidths = new int[] { 0, 383, 0, 0 };
			gbl_panel_Cad.rowHeights = new int[] { 10, 19, 19, 0, 19, 0, 0, 0, 0, 0, 0 };
			gbl_panel_Cad.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel_Cad.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_Cad.setLayout(gbl_panel_Cad);
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 1;
			gbc_lblNewLabel_2.gridy = 0;
			panel_Cad.add(getLblNewLabel_2(), gbc_lblNewLabel_2);
			GridBagConstraints gbc_textField_Modelo = new GridBagConstraints();
			gbc_textField_Modelo.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Modelo.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Modelo.gridx = 1;
			gbc_textField_Modelo.gridy = 1;
			panel_Cad.add(getTextField_Modelo(), gbc_textField_Modelo);
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 1;
			gbc_lblNewLabel_3.gridy = 2;
			panel_Cad.add(getLblNewLabel_3(), gbc_lblNewLabel_3);
			GridBagConstraints gbc_textField_Motor = new GridBagConstraints();
			gbc_textField_Motor.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Motor.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Motor.gridx = 1;
			gbc_textField_Motor.gridy = 3;
			panel_Cad.add(getTextField_Motor(), gbc_textField_Motor);
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 1;
			gbc_lblNewLabel_4.gridy = 4;
			panel_Cad.add(getLblNewLabel_4(), gbc_lblNewLabel_4);
			GridBagConstraints gbc_textField_Gasolina = new GridBagConstraints();
			gbc_textField_Gasolina.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Gasolina.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Gasolina.gridx = 1;
			gbc_textField_Gasolina.gridy = 5;
			panel_Cad.add(getTextField_Gasolina(), gbc_textField_Gasolina);
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 6;
			panel_Cad.add(getLblNewLabel_5(), gbc_lblNewLabel_5);
			GridBagConstraints gbc_textField_Etanol = new GridBagConstraints();
			gbc_textField_Etanol.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Etanol.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Etanol.gridx = 1;
			gbc_textField_Etanol.gridy = 7;
			panel_Cad.add(getTextField_Etanol(), gbc_textField_Etanol);
		}
		return panel_Cad;
	}

	public JTextField getTextField_Modelo() {
		if (textField_Modelo == null) {
			textField_Modelo = new JTextField();
			textField_Modelo.setColumns(10);
		}
		return textField_Modelo;
	}

	public JPanel getPanel_Codigo() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[] { -5, 50 };
			gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 50 };
			gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_4.setLayout(gbl_panel_4);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel_4.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_textField_Cod = new GridBagConstraints();
			gbc_textField_Cod.anchor = GridBagConstraints.WEST;
			gbc_textField_Cod.insets = new Insets(0, 0, 5, 0);
			gbc_textField_Cod.gridx = 0;
			gbc_textField_Cod.gridy = 1;
			panel_4.add(getTextField_Cod(), gbc_textField_Cod);
		}
		return panel_4;
	}

	public JTextField getTextField_Motor() {
		if (textField_Motor == null) {
			textField_Motor = new JTextField();
			textField_Motor.setColumns(10);
		}
		return textField_Motor;
	}

	public JTextField getTextField_Gasolina() { // campo gas
		if (textField_Gasolina == null) {
			textField_Gasolina = new JTextField();
			textField_Gasolina.setColumns(10);
		}
		return textField_Gasolina;
	}

	public JTextField getTextField_Etanol() { // campo etanol
		if (textField_Etanol == null) {
			textField_Etanol = new JTextField();
			textField_Etanol.setColumns(10);
		}
		return textField_Etanol;
	}

	public JTextField getTextField_Cod() {
		if (textField_Cod == null) {
			textField_Cod = new JTextField();
			textField_Cod.setColumns(10);
		}
		return textField_Cod;
	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Código");
		}
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("PREENCHA OS CAMPOS");
			lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		}
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("Modelo");
		}
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Motor L/CC");
		}
		return lblNewLabel_3;
	}

	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Gasolina KM/L");
		}
		return lblNewLabel_4;
	}

	public JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("Etanol KM/L ");
		}
		return lblNewLabel_5;
	}

	public CarCadastroController getController() {
		return controlador;
	}
}
