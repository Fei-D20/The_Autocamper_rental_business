package com.Database.DAO;

import com.Database.DAO.Product.Camper.CamperDaoImpl;
import com.Domain.Product.Camper.Camper;
import com.Domain.Product.Camper.Mile;
import com.Domain.Product.Camper.Tank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-11.33
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class testMain {
    public static void main(String[] args) throws ParseException {
        CamperDaoImpl camperDao = new CamperDaoImpl();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2020-5-3";
        Date date = simpleDateFormat.parse(str);

        Camper camper = new Camper();
        camper.setCamperID(001);
        camper.setCamperType("good");
        camper.setRegisterYear(date);
        camper.setCategoryID(1);
        Tank tank = new Tank(1000, 1000);
        Mile mile = new Mile(0);
        camper.setMile(mile);
        camper.setTank(tank);

        System.out.println(camper);


        camperDao.add(camper);
    }
}
