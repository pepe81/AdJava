package serpis.ad;

import java.sql.*;

public class MySql 
{
	private static Connection connection;
	private static Statement stmt;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//Class.forName("com.mysql.jdbc.Driver"); necesario en versiones del driver tipo 3 o anterior
		System.out.println("Hola");
		String url = "jdbc:mysql://localhost/dbprueba?";
		String user = "root";
		String password = "sistemas";
		
		connection = DriverManager.getConnection(url, user, password);
		stmt = connection.createStatement();

	}
	public boolean insertar(String sql) throws SQLException, ClassNotFoundException
	{
		try
		{
			stmt.executeUpdate(sql);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public ResultSet select(String sql) throws SQLException, ClassNotFoundException
	{
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public boolean delete(String sql) throws SQLException, ClassNotFoundException
	{
		try
		{
			stmt.executeUpdate(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
