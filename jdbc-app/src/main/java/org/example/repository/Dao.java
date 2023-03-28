package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T create(T t);

    List<T> findAll();

    Optional<T> findById(long id);

    T update(T t);

    /**
     * Update list of records
     *
     * @param t list of records to update
     * @return list of updated record ids
     */
    int[] update(List<T> t);

    /**
     * Delete selected record
     *
     * @param t record to delete
     * @return number of deleted records
     */
    int delete(T t);
}
