package app.serviços;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import app.entidades.Car;

public class CarServiceImpl extends Service implements CarServiceInt {

	private void setKmPLParameter(PreparedStatement preparedStatement, int parameterIndex, Double valor)
			throws SQLException {
		if (Objects.nonNull(valor)) {
			preparedStatement.setDouble(parameterIndex, valor);
		} else {
			preparedStatement.setNull(parameterIndex, java.sql.Types.NULL);
		}
	}

	@Override
	public int cadastrar(Car car) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(
						"insert into car_cad (car_cod, car_nom, kpl_gas, kpl_alc, car_mot) values (?, ?, ?, ?, ?)")) {

			Integer novoCodigo = car.getCodCar();
			if (Objects.isNull(novoCodigo)) {
				novoCodigo = max("car_cad", "car_cod") + 1;
			}

			preparedStatement.setInt(1, novoCodigo);
			preparedStatement.setString(2, car.getModelo());
			setKmPLParameter(preparedStatement, 3, car.getKmPlGas());
			setKmPLParameter(preparedStatement, 4, car.getKmPlAlc());
			preparedStatement.setDouble(5, car.getMotor());

			preparedStatement.executeUpdate();

			return novoCodigo;
		}
	}

	@Override
	public int excluir(Integer codigo) throws SQLException {

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from car_cad where car_cod = ?")) {
			preparedStatement.setInt(1, codigo);
			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public int editar(Car car) throws SQLException {

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(
				"update car_cad set car_nom = ?, kpl_gas = ?, kpl_alc = ?, car_mot = ? where car_cod = ?");
		{
			preparedStatement.setString(1, car.getModelo());
			setKmPLParameter(preparedStatement, 2, car.getKmPlGas());
			setKmPLParameter(preparedStatement, 3, car.getKmPlAlc());
			preparedStatement.setDouble(4, car.getMotor());
			preparedStatement.setInt(5, car.getCodCar());


			return preparedStatement.executeUpdate();
		}
	}

	@Override
	public Car consultaPorCod(Integer cod) throws SQLException {
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from car_cad where car_cod = ?")) {
			preparedStatement.setInt(1, cod);

			try (ResultSet result = preparedStatement.executeQuery()) {
				if (result.next()) {
					return resultCar(result);
				}
			}
			return null;
		}
	}

	@Override
	public List<Car> consultaPorNome(String modelo) throws SQLException {
		List<Car> listaNome = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from car_cad where car_nom ilike ?")) {
			preparedStatement.setString(1, "%" + modelo + "%");
			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					listaNome.add(resultCar(result));
				}
			}

			return listaNome;
		}
	}

	@Override
	public List<Car> consultaTudo() throws SQLException {
		List<Car> listaTudo = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from car_cad order by car_cod")) {

			try (ResultSet result = preparedStatement.executeQuery()) {
				while (result.next()) {
					listaTudo.add(resultCar(result));

				}
			}
		}

		return listaTudo;
	}

	private Car resultCar(ResultSet result) throws SQLException {
		return new Car(result.getInt("car_cod"), result.getString("car_nom"), result.getDouble("car_mot"),
				result.getDouble("kpl_gas"), result.getDouble("kpl_alc"));
	}
}
