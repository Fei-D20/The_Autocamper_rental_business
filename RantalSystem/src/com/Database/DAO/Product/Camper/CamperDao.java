package com.Database.DAO.Product.Camper;

import com.Domin.Product.Camper.Camper;

import java.util.List;

/**
 * @ author Fei Gu
 * @ create 2021-05-03-23.06
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public interface CamperDao {
    public void add(Camper camper);
    public void update(Camper camper);
    public void delete(int camperID);
    public Camper getCamper(int camperID);
    public List<Camper> getAll();
}
