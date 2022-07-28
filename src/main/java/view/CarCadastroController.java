package view;

import java.util.Objects;

import javax.swing.JOptionPane;

import app.entidades.Car;
import app.serviços.CarServiceImpl;
import app.serviços.CarServiceInt;

public class CarCadastroController {

	private final CarCadastroView viewCadastro;
	private Integer codigoCarro;
	
    public Integer getcodigoCarro() {
        return codigoCarro;
    }

	public CarCadastroController(CarCadastroView view, Integer codigo) {
		this.viewCadastro = view;
		if (Objects.nonNull(codigo)) {
			buscaCarroPorCodigo(codigo);
		}
	}

	private void buscaCarroPorCodigo(Integer codigo) {
		final CarServiceInt service = new CarServiceImpl();
		try {
			final Car carro = service.consultaPorCod(codigo);
			if (Objects.nonNull(carro)) {
				viewCadastro.getTextField_Cod().setText(carro.getCodCar().toString());
				viewCadastro.getTextField_Modelo().setText(carro.getModelo());
				viewCadastro.getTextField_Motor().setText(carro.getModelo());
				viewCadastro.getTextField_Gasolina().setText(carro.getKmPlGas().toString());
				viewCadastro.getTextField_Etanol().setText(carro.getKmPlAlc().toString());
					
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salvarCarro(){
		final CarServiceInt service = new CarServiceImpl();
		try {
			final String PegaCodigo = viewCadastro.getTextField_Cod().getText();
	//		final String kmlGas = viewCadastro.getTextField_Gasolina().getText();
	//		final String kmlAlc = viewCadastro.getTextField_Etanol().getText();
			
			if (PegaCodigo.trim().isEmpty()) {
				final Car carro = new Car(
						viewCadastro.getTextField_Modelo().getText(),
						Double.valueOf(viewCadastro.getTextField_Motor().getText()),
						Double.valueOf(viewCadastro.getTextField_Gasolina().getText()),
						Double.valueOf(viewCadastro.getTextField_Etanol().getText()));
				codigoCarro = service.cadastrar(carro);
			} else {
				final Car carro = new Car(
						Integer.valueOf(PegaCodigo),
						viewCadastro.getTextField_Modelo().getText(),
						Double.valueOf(viewCadastro.getTextField_Motor().getText()),
						Double.valueOf(viewCadastro.getTextField_Gasolina().getText()),
						Double.valueOf(viewCadastro.getTextField_Etanol().getText()));
				service.editar(carro);
				codigoCarro = Integer.valueOf(PegaCodigo);
			}
			
		//	viewCadastro.setVisible(false);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(viewCadastro, "Erro ao cadastrar o cliente: " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
