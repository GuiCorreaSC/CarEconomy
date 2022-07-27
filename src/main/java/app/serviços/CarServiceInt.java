package app.serviços;

import java.sql.SQLException;
import java.util.List;

import app.entidades.Car;

public interface CarServiceInt {

	int cadastrar(Car car) throws SQLException; 
	int excluir(Integer codigo) throws SQLException; 
	int editar(Car car) throws SQLException; 
	
	Car consultaPorCod(Integer codigo) throws SQLException;
	List<Car> consultaPorNome(String modelo) throws SQLException;
	List<Car> consultaTudo() throws SQLException;
	
	
}
