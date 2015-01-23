package serpis.ad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateCategoria 
{
	private static EntityManagerFactory entityManagerFactory;
	private static List<Categoria> categorias;
	private static Categoria categoria;
	
	public static void main(String[] args) 
	{
		entityManagerFactory = Persistence.createEntityManagerFactory("serpis.ad.jpa.mysql");
		
		showCategorias();
		System.out.println("Añado categorias");
		persistNuevasCategorias();
		
		showCategorias();
		deleteCategorias();
		//updateCategorias();
		
		entityManagerFactory.close();
	}
	public static void persistNuevasCategorias()
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		categoria = new Categoria();
		categoria.setNombre("Hibernate "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		entityManager.persist(categoria);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public static void showCategorias()
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		categorias = entityManager.createQuery("from Categoria", Categoria.class).getResultList();
		for(Categoria categoria:categorias)
			System.out.printf("id = %d nombre=%s\n",categoria.getId(),categoria.getNombre());
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public static void updateCategorias()
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Categoria categoria = selectCategorias(entityManager);
		System.out.println("Introduce el nuevo nombre: ");
		Scanner tcl = new Scanner(System.in);
		String nombre = tcl.nextLine();
		categoria.setNombre(nombre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public static void deleteCategorias()
	{
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.remove(selectCategorias(entityManager));
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	public static Categoria selectCategorias(EntityManager entityManager)
	{
		System.out.println("Introduce el Id: ");
		Scanner tcl = new Scanner(System.in);
		long id = tcl.nextLong();
		Categoria categoria = entityManager.find(Categoria.class, id);
		tcl.close();
		return categoria;
	}
}
