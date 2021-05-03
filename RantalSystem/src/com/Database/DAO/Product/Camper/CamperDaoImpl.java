package com.Database.DAO.Product.Camper;

import com.Database.JDBC.ConnectionUtil;
import com.Domin.Product.Camper.Camper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * @ author Fei Gu
 * @ create 2021-05-03-23.09
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class CamperDaoImpl implements CamperDao{
    @Override
    public void add(Camper camper) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql =
                "insert into " +
                        "tbl_CAMPER " +
                        "(fld_CamperID, fld_CamperRegisterYear, fld_CamperType, fld_CategoryID, fld_FullTankStatus) " +
                        "values (?,?,?,?,?))";
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,camper.getCamperID());
//            preparedStatement.setInt(2,camper.getRegisterYear());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Camper camper) {

    }

    @Override
    public void delete(int camperID) {

    }

    @Override
    public Camper getCamper(int camperID) {
        return null;
    }

    @Override
    public List<Camper> getAll() {
        return null;
    }
}
