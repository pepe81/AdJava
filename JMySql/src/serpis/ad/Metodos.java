package serpis.ad;

import java.math.BigDecimal;
import java.sql.*;
import java.text.DecimalFormat;

public class Metodos 
{
	Conexion conexion;
	static ResultSet rs;
	
	public Metodos()throws ClassNotFoundException,SQLException
	{
		conexion = new Conexion();
	}
	public boolean añadirArticulo(String nombre,Long categoria,BigDecimal precio)throws SQLException, ClassNotFoundException
	{
		String sql = "insert into articulo(nombre,categoria,precio)values("+"'"+nombre+"','"+categoria+"','"+precio+"')";
		return conexion.insertar(sql);
	}
	public void listarArticulos() throws SQLException, ClassNotFoundException
	{
		String sql = "select * form articulo order by 1";
		rs = conexion.select(sql);
		while (rs.next())
		{
			System.out.printf("id=%4s nombre=%s categoria=%s precio=%s \n",
					rs.getObject("id"),
					rs.getObject("nombre"),
					rs.getObject("categoria"),
					rs.getObject("precio"));
		}
		rs.close();
	}
	public void borrarArticulo(String id) throws SQLException, ClassNotFoundException
	{
		
	}
}
