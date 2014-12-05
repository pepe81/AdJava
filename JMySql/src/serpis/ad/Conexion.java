package serpis.ad;

import java.sql.*;

public class Conexion 
{
	private static Connection connection;
	private static Statement stmt;
	
	Conexion() throws ClassNotFoundException, SQLException 
	{
		//Class.forName("com.mysql.jdbc.Driver"); necesario en versiones del driver tipo 3 o anterior
		String url = "jdbc:mysql://localhost/dbprueba?";
		String user = "root";
		String password = "sistemas";
		
		connection = DriverManager.getConnection(url, user, password);
		stmt = connection.createStatement();
		
//		PreparedStatement preparedStatement = connection.prepareStatement("select * from categoria where id = ?");
//		preparedStatement.setLong(0, 7);
//		ResultSet rs = preparedStatement.executeQuery();
//		while(rs.next())
//			System.out.printf("id=%4s nombre=%s\n", rs.getObject("id"),rs.getObject("nombre"));
//		
//		rs.close();
//		preparedStatement.close();
//		connection.close();
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
