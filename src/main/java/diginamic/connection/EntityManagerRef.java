package diginamic.connection;

import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public final class EntityManagerRef {

	private static final String PERSISTENCE_NAME;
	private static EntityManager entityManager = null;
	static {
		ResourceBundle connection = ResourceBundle.getBundle("database");
		PERSISTENCE_NAME = connection.getString("persistenceUnit");
	}

	private EntityManagerRef() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_NAME).createEntityManager();
	}

	public static EntityManager getInstance() {
		if (entityManager == null || !entityManager.isOpen())
			new EntityManagerRef();

		return entityManager;
	}

	public void closedConnection() {
		entityManager.close();
	}
}
