package serpis.ad;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public class Menu 
{
	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
		Scanner tcl = new Scanner(System.in);
		int select;
		String id;
		String nombre;
		long categoria;
		BigDecimal precio;
		Metodos metodos = null;
		
		do
		{
			System.out.println("***Menú Artículos***");
			System.out.println("0. Salir");
			System.out.println("1. Nuevo");
			System.out.println("2. Editar");
			System.out.println("3. Eliminar");
			System.out.println("4. Listar");
			select = tcl.nextInt();
			tcl.nextLine();
			
			switch(select)
			{
				case 1:
					System.out.println("Introduce el nombre del artículo: ");
					nombre = tcl.nextLine();
					System.out.println("Introduce la categoría del artículo: ");
					categoria = tcl.nextLong();
					System.out.println("Introduce el precio del artículo: ");
					precio = tcl.nextBigDecimal();
					
					metodos.añadirArticulo(nombre, categoria, precio);
					break;
				case 2:
					System.out.println("Introduce el id del artículo: ");
					break;
				case 3:
					System.out.println("Introduce el id del artículo: ");
					break;
				case 4:
					System.out.println("Introduce el id del artículo: ");
					break;
				case 0:
					System.out.println("Saliendo del sistema");
					break;
			}
		}
		while(select!=0);
	}

}
