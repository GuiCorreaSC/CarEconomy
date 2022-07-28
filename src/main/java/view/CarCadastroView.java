package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class CarCadastroView extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel panel_Btn;
	private JButton btnSalvar;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnListarTodos;
	private JButton btnProcurar;
	private JPanel panel_title;
	private JPanel panel_3;
	private JPanel panel_Cad;
	private JTextPane txtpnModelo;
	private JTextField textField_Modelo;
	private JTextPane txtpnMotor;
	private JPanel panel_4;
	private JTextField textField_Motor;
	private JTextPane txtpnMotor_1;
	private JTextPane txtpnMotor_1_1;
	private JTextField textField_Gasolina;
	private JTextField textField_Etanol;
	private JTextPane txtpnPreenchaOsCampos;

	private CarCadastroController controlador;
	private JTextPane txtpnCdigo;
	private JTextField textField_Cod;

	public CarCadastroView() {
		setBackground(new Color(0, 0, 0));
		getContentPane().setForeground(Color.GREEN);
		getContentPane().add(getPanel_2(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_2_1(), BorderLayout.NORTH);
		getContentPane().add(getPanel_3(), BorderLayout.EAST);
		getContentPane().add(getPanel_1_1(), BorderLayout.CENTER);
		getContentPane().add(getPanel_4(), BorderLayout.WEST);
		setForeground(Color.BLACK);
		setBounds(1000, 1000, 720, 440);

	}

	public JPanel getPanel_2() {
		if (panel_Btn == null) {
			panel_Btn = new JPanel();
			FlowLayout fl_panel_Btn = (FlowLayout) panel_Btn.getLayout();
			fl_panel_Btn.setHgap(10);
			panel_Btn.setBorder(new EmptyBorder(5, 5, 0, 5));
			panel_Btn.setBackground(Color.DARK_GRAY);
			panel_Btn.add(getBtnSalvar());
			panel_Btn.add(getBtnNewButton_1_1());
			panel_Btn.add(getBtnExcluir());
			panel_Btn.add(getBtnListarTodos());
			panel_Btn.add(getBtnProcurar());
		}
		return panel_Btn;
	}

	public JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(e -> controlador.salvarCarro());
		}
		btnSalvar.setBackground(Color.GRAY);
		return btnSalvar;
	}

	public JButton getBtnNewButton_1_1() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBackground(Color.GRAY);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnEditar;
	}

	public JButton getBtnExcluir() {
		if (btnExcluir == null) {
			btnExcluir = new JButton("Excluir");
			btnExcluir.setBackground(Color.GRAY);
		}
		return btnExcluir;
	}

	public JButton getBtnListarTodos() {
		if (btnListarTodos == null) {
			btnListarTodos = new JButton("Listar todos");
			btnListarTodos.setBackground(Color.GRAY);
		}
		return btnListarTodos;
	}

	public JButton getBtnProcurar() {
		if (btnProcurar == null) {
			btnProcurar = new JButton("Procurar");
			btnProcurar.setBackground(Color.GRAY);
			btnProcurar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnProcurar;
	}

	public JPanel getPanel_2_1() {
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
			GridBagConstraints gbc_txtpnPreenchaOsCampos = new GridBagConstraints();
			gbc_txtpnPreenchaOsCampos.gridx = 0;
			gbc_txtpnPreenchaOsCampos.gridy = 1;
			panel_title.add(getTxtpnPreenchaOsCampos(), gbc_txtpnPreenchaOsCampos);
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

	public JPanel getPanel_1_1() {
		if (panel_Cad == null) {
			panel_Cad = new JPanel();
			panel_Cad.setBackground(Color.DARK_GRAY);
			GridBagLayout gbl_panel_Cad = new GridBagLayout();
			gbl_panel_Cad.columnWidths = new int[] { 0, 383, 0, 0 };
			gbl_panel_Cad.rowHeights = new int[] { 10, 19, 19, 0, 19, 0, 0, 0, 0 };
			gbl_panel_Cad.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel_Cad.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_Cad.setLayout(gbl_panel_Cad);
			GridBagConstraints gbc_txtpnModelo = new GridBagConstraints();
			gbc_txtpnModelo.anchor = GridBagConstraints.NORTH;
			gbc_txtpnModelo.insets = new Insets(0, 0, 5, 5);
			gbc_txtpnModelo.gridx = 1;
			gbc_txtpnModelo.gridy = 0;
			panel_Cad.add(getTxtpnModelo(), gbc_txtpnModelo);
			GridBagConstraints gbc_textField_Modelo = new GridBagConstraints();
			gbc_textField_Modelo.anchor = GridBagConstraints.NORTH;
			gbc_textField_Modelo.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Modelo.gridx = 1;
			gbc_textField_Modelo.gridy = 1;
			panel_Cad.add(getTextField_Modelo(), gbc_textField_Modelo);
			GridBagConstraints gbc_txtpnMotor = new GridBagConstraints();
			gbc_txtpnMotor.anchor = GridBagConstraints.NORTH;
			gbc_txtpnMotor.fill = GridBagConstraints.VERTICAL;
			gbc_txtpnMotor.insets = new Insets(0, 0, 5, 5);
			gbc_txtpnMotor.gridx = 1;
			gbc_txtpnMotor.gridy = 2;
			panel_Cad.add(getTxtpnMotor(), gbc_txtpnMotor);
			GridBagConstraints gbc_textField_Motor = new GridBagConstraints();
			gbc_textField_Motor.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Motor.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Motor.gridx = 1;
			gbc_textField_Motor.gridy = 3;
			panel_Cad.add(getTextField_Motor(), gbc_textField_Motor);
			GridBagConstraints gbc_txtpnMotor_1 = new GridBagConstraints();
			gbc_txtpnMotor_1.anchor = GridBagConstraints.NORTH;
			gbc_txtpnMotor_1.insets = new Insets(0, 0, 5, 5);
			gbc_txtpnMotor_1.fill = GridBagConstraints.VERTICAL;
			gbc_txtpnMotor_1.gridx = 1;
			gbc_txtpnMotor_1.gridy = 4;
			panel_Cad.add(getTxtpnMotor_1(), gbc_txtpnMotor_1);
			GridBagConstraints gbc_textField_Gasolina = new GridBagConstraints();
			gbc_textField_Gasolina.insets = new Insets(0, 0, 5, 5);
			gbc_textField_Gasolina.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Gasolina.gridx = 1;
			gbc_textField_Gasolina.gridy = 5;
			panel_Cad.add(getTextField_Gasolina(), gbc_textField_Gasolina);
			GridBagConstraints gbc_txtpnMotor_1_1 = new GridBagConstraints();
			gbc_txtpnMotor_1_1.insets = new Insets(0, 0, 5, 5);
			gbc_txtpnMotor_1_1.fill = GridBagConstraints.VERTICAL;
			gbc_txtpnMotor_1_1.gridx = 1;
			gbc_txtpnMotor_1_1.gridy = 6;
			panel_Cad.add(getTxtpnMotor_1_1(), gbc_txtpnMotor_1_1);
			GridBagConstraints gbc_textField_Etanol = new GridBagConstraints();
			gbc_textField_Etanol.insets = new Insets(0, 0, 0, 5);
			gbc_textField_Etanol.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_Etanol.gridx = 1;
			gbc_textField_Etanol.gridy = 7;
			panel_Cad.add(getTextField_Etanol(), gbc_textField_Etanol);
		}
		return panel_Cad;
	}

	public JTextPane getTxtpnModelo() {
		if (txtpnModelo == null) {
			txtpnModelo = new JTextPane();
			txtpnModelo.setEnabled(false);
			txtpnModelo.setEditable(false);
			txtpnModelo.setFont(new Font("Calibri", Font.BOLD, 12));
			txtpnModelo.setBackground(Color.DARK_GRAY);
			txtpnModelo.setForeground(Color.GRAY);
			txtpnModelo.setText("Modelo:");
		}
		return txtpnModelo;
	}

	public JTextField getTextField_Modelo() {
		if (textField_Modelo == null) {
			textField_Modelo = new JTextField();
			textField_Modelo.setColumns(30);
		}
		return textField_Modelo;
	}

	public JTextPane getTxtpnMotor() {
		if (txtpnMotor == null) {
			txtpnMotor = new JTextPane();
			txtpnMotor.setEnabled(false);
			txtpnMotor.setEditable(false);
			txtpnMotor.setFont(new Font("Calibri", Font.BOLD, 12));
			txtpnMotor.setBackground(Color.DARK_GRAY);
			txtpnMotor.setForeground(Color.GRAY);
			txtpnMotor.setText("Motor L/CC");
		}
		return txtpnMotor;
	}

	public JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBackground(Color.DARK_GRAY);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[] { -5, 50 };
			gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 50 };
			gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_4.setLayout(gbl_panel_4);
			GridBagConstraints gbc_txtpnCdigo = new GridBagConstraints();
			gbc_txtpnCdigo.anchor = GridBagConstraints.WEST;
			gbc_txtpnCdigo.insets = new Insets(0, 0, 5, 0);
			gbc_txtpnCdigo.fill = GridBagConstraints.VERTICAL;
			gbc_txtpnCdigo.gridx = 0;
			gbc_txtpnCdigo.gridy = 0;
			panel_4.add(getTxtpnCdigo(), gbc_txtpnCdigo);
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

	public JTextPane getTxtpnMotor_1() {
		if (txtpnMotor_1 == null) {
			txtpnMotor_1 = new JTextPane();
			txtpnMotor_1.setEnabled(false);
			txtpnMotor_1.setEditable(false);
			txtpnMotor_1.setFont(new Font("Calibri", Font.BOLD, 12));
			txtpnMotor_1.setBackground(Color.DARK_GRAY);
			txtpnMotor_1.setForeground(Color.GRAY);
			txtpnMotor_1.setText("Gasolina KM/L");
		}
		return txtpnMotor_1;
	}

	public JTextPane getTxtpnMotor_1_1() {
		if (txtpnMotor_1_1 == null) {
			txtpnMotor_1_1 = new JTextPane();
			txtpnMotor_1_1.setEnabled(false);
			txtpnMotor_1_1.setEditable(false);
			txtpnMotor_1_1.setFont(new Font("Calibri", Font.BOLD, 12));
			txtpnMotor_1_1.setBackground(Color.DARK_GRAY);
			txtpnMotor_1_1.setForeground(Color.GRAY);
			txtpnMotor_1_1.setText("Etanol KM/L ");
		}
		return txtpnMotor_1_1;
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

	public JTextPane getTxtpnPreenchaOsCampos() {
		if (txtpnPreenchaOsCampos == null) {
			txtpnPreenchaOsCampos = new JTextPane();
			txtpnPreenchaOsCampos.setText("PREENCHA OS CAMPOS");
			txtpnPreenchaOsCampos.setForeground(Color.GRAY);
			txtpnPreenchaOsCampos.setFont(new Font("Calibri", Font.BOLD, 12));
			txtpnPreenchaOsCampos.setEnabled(false);
			txtpnPreenchaOsCampos.setEditable(false);
			txtpnPreenchaOsCampos.setBackground(Color.DARK_GRAY);
		}
		return txtpnPreenchaOsCampos;
	}

	public JTextPane getTxtpnCdigo() {
		if (txtpnCdigo == null) {
			txtpnCdigo = new JTextPane();
			txtpnCdigo.setEditable(false);
			txtpnCdigo.setForeground(Color.GRAY);
			txtpnCdigo.setBackground(Color.DARK_GRAY);
			txtpnCdigo.setText("Código");
		}
		return txtpnCdigo;
	}

	public JTextField getTextField_Cod() {
		if (textField_Cod == null) {
			textField_Cod = new JTextField();
			textField_Cod.setColumns(10);
		}
		return textField_Cod;
	}
}
