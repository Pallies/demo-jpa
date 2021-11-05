package diginamic.services.dao;

import java.util.List;

/**
 * The Interface IDao.
 *
 * @param <T> the generic type
 * @param <U> the generic type
 */
public interface IDao<T,U> {

	/**
	 * Insert.
	 *
	 * @param object the object
	 * @return the t
	 */
	public T insert(T object);
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();
	
	/**
	 * Find.
	 *
	 * @param object the object
	 * @return the t
	 */
	public T find(T object);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the t
	 */
	public T findById(U id);
	
	/**
	 * Update.
	 *
	 * @param object1 the object 1
	 * @param object2 the object 2
	 * @return the t
	 */
	public T update(T object1,T object2);
	
	/**
	 * Delete.
	 *
	 * @return the t
	 */
	public T delete(T object);
}
