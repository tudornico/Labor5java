package Uni;

import java.util.List;

/**
 * interface describing what a CRUD repo should do
 * @param <T> giving a generic T value for any type of value we may need
 */
public interface ICrudRepository<T> {
    /**
     * function creating an object of type T
     * @param obj  the instance of the object needed
     * @return returns the object created
     */
    T create(T obj);

    /**
     * function that can access the whole list of objects T
     * @return the list of objects T
     */
    List<T> getAll();

    /**
     * the function to change the previous object with a new one
     * @param obj the new object we want to update to
     * @return the object changed
     */
    T update(T obj);

    /**
     * function that deletes the object of type T from our repository list
     * @param obj
     */
    void delete(T obj);
}
