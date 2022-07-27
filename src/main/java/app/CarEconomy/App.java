package app.CarEconomy;

import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, 
				"Como calcular o consumo “pela bomba”? \r\n"
				+ "É possível calcular o consumo de combustível do carro na hora de abastecer o carro seguindo alguns passos simples.\r\n Confira:"
				+ "\r\n"
				+ "Encher o tanque de combustível do veículo. \r\n"
				+ "Anotar a quilometragem atual ou zerar o hodômetro parcial. \r\n"
				+ "Rodar com o carro no percurso escolhido. \r\n"
				+ "Completar o tanque novamente (de preferência no mesmo posto, para que a média tenha mais precisão). \r\n"
				+ "Anotar a quilometragem atual ou o hodômetro parcial e a quantidade de litros usado para completar o tanque novamente. "
				);
		//Calcular quanto faz por litro Gasolina
		Double kplGas = 700.0 / 50.0;
		
		//Calcular quanto faz por litro Alcool
		Double kplAlc = 500.0 / 50.0;
		
		//Calcular combustivel que vale mais a pena pelo preço x rendimento:
		Double rend = 10.2 / 14.6; // calcular quanto o carro rende no alcool em relação a gasolina
		System.out.printf("rendimento: %.2f%n", rend * 100);
		System.out.println();
		Double preco = 4.62 / 5.97; // calcular o preço do alcool em relação da gasolina
		System.out.printf("preço: %.2f%n", preco * 100);
		System.out.println((rend >= preco) ? "Etanois nele" : "Abasteça com Mijolina");

	}
}
