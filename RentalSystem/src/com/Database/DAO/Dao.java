package com.Database.DAO;


import java.util.List;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-08.07
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface Dao<T> {
    public  void add(T t);
    public  void update(T t);
    public  void delete(int id);
    public  T getInstance(int id);
    public  void getAll();
}
