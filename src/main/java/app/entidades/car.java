package app.entidades;

public class Car {
	
	private Integer codCar;
	private String modelo;
	private Double motor;
	private Double kmPlGas;
	private Double kmPlAlc;
	
	public Car(String modelo, Double motor) {
		this.modelo = modelo;
		this.motor = motor;
	}

	public Car(String modelo, Double motor, Double kmPlGas, Double kmPlAlc) {
		this.modelo = modelo;
		this.motor = motor;
		this.kmPlGas = kmPlGas;
		this.kmPlAlc = kmPlAlc;
	}
	
	public Car(Integer codCar,String modelo, Double motor, Double kmPlGas, Double kmPlAlc) {
		this.codCar = codCar;
		this.modelo = modelo;
		this.motor = motor;
		this.kmPlGas = kmPlGas;
		this.kmPlAlc = kmPlAlc;
	}

	public Integer getCodCar() {
		return codCar;
	}

	public void setCodCar(Integer codCar) {
		this.codCar = codCar;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getMotor() {
		return motor;
	}

	public void setMotor(Double motor) {
		this.motor = motor;
	}

	public Double getKmPlGas() {
		return kmPlGas;
	}

	public void setKmPlGas(Double kmPlGas) {
		this.kmPlGas = kmPlGas;
	}

	public Double getKmPlAlc() {
		return kmPlAlc;
	}

	public void setKmPlAlc(Double kmPlAlc) {
		this.kmPlAlc = kmPlAlc;
	}

	@Override
	public String toString() {
		return "\nCódigo: " + codCar + ",\nModelo: " + modelo + ",\nMotor: " + motor + ",\nKms/L de gasolina: " + kmPlGas
				+ ",\nKms/L de Etanol: " + kmPlAlc + ".";
	}
	
	
	
	
	

}
