import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.maintenance.entity.User;

public class UsersTest {

	public static void main(String[] args) {
		
		User user1=new User();
		user1.setEmail("piya1223@gjkhjk");
		user1.setFullName("piya");
		user1.setPassword("jhkh");
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Home Maintenance System");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("Users has been created");
	}
}
