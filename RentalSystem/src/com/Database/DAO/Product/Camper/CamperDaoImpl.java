package com.Database.DAO.Product.Camper;

import com.Database.JDBC.CRUD;
import com.Domain.Product.Camper.Camper;
import com.Domain.Product.Camper.Mile;
import com.Domain.Product.Camper.Tank;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ author Fei Gu
 * @ create 2021-05-03-23.09
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class CamperDaoImpl implements CamperDao{
//    @Test
//    public void testAdd() throws ParseException {
//        CamperDaoImpl camperDao = new CamperDaoImpl();
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String str = "2020-5-3";
//        Date date = simpleDateFormat.parse(str);
//
//        Camper camper = new Camper();
//        camper.setCamperID(001);
//        camper.setCamperType("bigCamper");
//        camper.setRegisterYear(date);
//        camper.setCategoryID(001);
//        Tank tank = new Tank(1000, 1000);
//        Mile mile = new Mile(0);
//        camper.setMile(mile);
//        camper.setTank(tank);
//
//        System.out.println(camper);
//
//
//        camperDao.add(camper);
//
//
//    }
    @Override
    public void add(Camper camper) {

        String sql = "insert into tbl_Camper (fld_CamperID, fld_CamperRegisterYear, fld_CamperType, fld_CategoryID, fld_FullTankStatus) values (?,?,?,?,?)";

        int camperID = camper.getCamperID();
        String camperType = camper.getCamperType();
        int categoryID = camper.getCategoryID();
        boolean fullTankStatue = camper.getTank().checkFullTank();
        String tankStatue = String.valueOf(fullTankStatue);
        Date registerYear = camper.getRegisterYear();
        java.sql.Date date = new java.sql.Date(registerYear.getTime());

//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try{
//
//            connection = ConnectionUtil.getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setInt(1,camper.getCamperID());
//            preparedStatement.setDate(2,new java.sql.Date(camper.getRegisterYear().getTime()));
//            preparedStatement.setString(3,camper.getCamperType());
//            preparedStatement.setInt(4,camper.getCategoryID());
//            preparedStatement.setBoolean(5,camper.getTank().checkFullTank());
//
//            preparedStatement.execute();
//
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            ConnectionUtil.closeConAndPS(connection,preparedStatement);
//        }

        try {
            CRUD.update(sql,camperID,date,camperType,categoryID,tankStatue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Camper camper) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Camper getInstance(int id) {
        return null;
    }

    @Override
    public void getAll() {
    }
}
