package Uni;

import java.util.ArrayList;
import java.util.List;

/**
 * memory repo that implements some of the more generic methods of the interface
 * @param <T> a generic object type
 */
public abstract class IMemoryRepository<T> implements ICrudRepository<T> {
    protected List<T> repoList;

    /**
     * constructor initializing the list of each repository
     */
    public IMemoryRepository(){
        this.repoList = new ArrayList<>();
    }

    @Override
    /**
     * implementation of the function from the interface CRUDREPO
     */
    public T create(T obj){
        this.repoList.add(obj);
        return obj;
    }

    @Override
    /**
     * implementation of function from interface CRUDREPO
     */
    public List<T> getAll(){
        return this.repoList;
    }

    @Override
    /**
     * implemetation of function from interfavce CRUDREPO
     */
    public void delete(T obj){
        this.repoList.remove(obj);
    }

}
