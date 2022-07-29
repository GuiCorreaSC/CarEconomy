package view;

import java.awt.Dialog.ModalityType;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import app.entidades.Car;
import app.serviços.CarServiceImpl;
import app.serviços.CarServiceInt;

public class CarListaController {

	private final CarListaView view;
	
	
	protected CarListaController(CarListaView view) {
		this.view = view;
		SwingUtilities.invokeLater(this::buscaTodos);
	}

	private void buscaTodos() {
        try {
            limparTabela();
            final CarServiceInt service = new CarServiceImpl();
            List<Car> carros = service.consultaTudo();
            carros.forEach(this::adicionaNaTabela);
            getModeloTabela().fireTableDataChanged();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public void buscaPorNome(String text) {
		try {
			limparTabela();
            final CarServiceInt service = new CarServiceImpl();
			final List<Car> carros = service.consultaPorNome(text);
			carros.forEach(this::adicionaNaTabela);
			view.getTextField().setText("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void limparTabela() {
		final DefaultTableModel model = getModeloTabela();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		model.fireTableDataChanged();
	}

	private DefaultTableModel getModeloTabela() {
		return (DefaultTableModel) view.getTable().getModel();
	}

	private void adicionaNaTabela(Car carros) {
		getModeloTabela().addRow(new Object[] { 
				carros.getCodCar(),
				carros.getModelo(),
				carros.getMotor(),
				carros.getKmPlGas(),
				carros.getKmPlAlc() });
	}

	public Integer abreCadastroCarro(Integer codigo) {
		final CarCadastroView dialog = new CarCadastroView(view, codigo);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		dialog.setModalityType(ModalityType.DOCUMENT_MODAL);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		return dialog.getController().getcodigoCarro();
	}

	public void abreNovoCadastroCarro() {
		Integer codigoCliente = abreCadastroCarro(null);
		buscaTodos();
		if (Objects.nonNull(codigoCliente)) {
			selecionaCarroNaTabela(codigoCliente);
		}
	}

	public void editarCarro() {
		final int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(view, "Selecione um veicúlo na lista acima", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		} else {
			final Integer codigoCarro = (Integer) getModeloTabela().getValueAt(selectedRow, 0);

			abreCadastroCarro(codigoCarro);
			buscaTodos();
			selecionaCarroNaTabela(codigoCarro);
		}
	}

	private void selecionaCarroNaTabela(final Integer codigoCarro) {
		for (int i = 0; i < getModeloTabela().getRowCount(); i++) {
			final Integer cod = (Integer) getModeloTabela().getValueAt(i, 0);
			if (cod.equals(codigoCarro)) {
				view.getTable().setRowSelectionInterval(i, i);
				view.getTable().requestFocusInWindow();
				break;
			}
		}
	}

	public void excluirCarro() {
		final int selectedRow = view.getTable().getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(view, "Selecione um veicúlo na lista acima para excluir", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		} else {
			final Integer codigoCarro = (Integer) getModeloTabela().getValueAt(selectedRow, 0);
			try {
				final int confirm = JOptionPane.showConfirmDialog(view,
						"Deseja realmente excluir o veicúlo selecionado?", "Confirmação", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					final CarServiceInt service = new CarServiceImpl();
					service.excluir(codigoCarro);
					limparTabela();
					buscaTodos();
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(view, "Erro ao excluir o veicúlo: " + e.getMessage(), "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}