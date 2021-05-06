package com.Database.DAO;


/**
 * @ author Fei Gu
 * @ create 2021-05-04-08.07
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface Dao<T> {
    public void add(T t);

    public void update(T t);

    public void delete(int id);

    public void getInstance(int id);

    public void getAll();
}
