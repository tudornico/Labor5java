package Repo;

import java.util.List;

public interface DatabaseRepositry<T> {

    List<T> getFromDataBase();

    boolean restoreToDataBase();
}
