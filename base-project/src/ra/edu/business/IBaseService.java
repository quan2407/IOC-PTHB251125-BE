package ra.edu.business;

import java.util.List;

public interface IBaseService<T,ID> {
    void add(T t);
    void delete(ID id);
    void update(T t,ID id);
    T findById(ID id);
    List<T> findAll();
    void sort();
}
