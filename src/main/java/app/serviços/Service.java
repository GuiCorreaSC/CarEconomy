package app.serviços;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

	public Connection getConnection() throws SQLException {
		final String url = "jdbc:postgresql://localhost:5432/appEconomy";
		return DriverManager.getConnection(url, "postgres", "postgres");
	}
	
    public int max(String tabela, String coluna) throws SQLException {
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        String.format("select max(%s) maior from %s", coluna, tabela));
                ResultSet resultSet = preparedStatement.executeQuery()
                ) {
            if (resultSet.next()) {
                return resultSet.getInt("maior");
            }
            return 0;
        }
    }




}
