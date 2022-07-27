package app.entidades;

public class car {
	
	private Integer codCar;
	private String modelo;
	private Double motor;
	private Double kmPlGas;
	private Double kmPlAlc;
	
	public car(String modelo, Double motor) {
		super();
		this.modelo = modelo;
		this.motor = motor;
	}

	public car(String modelo, Double motor, Double kmPlGas, Double kmPlAlc) {
		super();
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
		return "car [codCar=" + codCar + ", modelo=" + modelo + ", motor=" + motor + ", kmPlGas=" + kmPlGas
				+ ", kmPlAlc=" + kmPlAlc + "]";
	}
	
	
	
	
	

}
