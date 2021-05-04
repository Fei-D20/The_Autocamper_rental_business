package com.Database.JDBC;

import com.Database.JDBC.ConnectionUtil;
import com.Domin.RalativeOutSide.Bank;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @ author Fei Gu
 * @ create 2021-05-03-13.52
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class CRUD {

    @Test
    public void testInsert(){
        try {
            String sql = "INSERT INTO tbl_Bank(fld_BankID,fld_BankName) values (?,?) ";
            update(sql,1,"Nordea");
            update(sql,2,"DanskBank");
            update(sql,3,"SydDenmarkBank");
            System.out.println("Insert finished");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdate(){
        try {
            String sql = "update tbl_Bank set fld_BankName = ? where fld_BankID = ? ";
            update(sql,"DanskBank",1);
            System.out.println("update finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try {
            String sql = " delete from tbl_Bank where fld_BankID = ? ";
            update(sql,1);
            System.out.println("delete finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetINstance(){
        String sql = "select fld_BankID, fld_BankName from tbl_Bank where fld_BankID = ?";
        Bank bank = getInstance(Bank.class, sql, 1);
        System.out.println(bank);
    }

    @Test
    public void testGetTable(){
        String sql = "select * from tbl_Bank";
        getTable(sql);
    }

    public static void update(String sql,Object ...args) throws Exception { //sql 中占位符的个数与可变形参长度相同

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1 , args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConAndPS(connection,preparedStatement);
        }
    }

    public static <T> T getInstance(Class<T> clazz, String sql, Object ...args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }

            resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {

                    Object columnValue = resultSet.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConPSAndRS(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public static void getTable(String sql) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                System.out.print(metaData.getColumnName(i + 1) + "\t");
            }
            System.out.println();

            while (resultSet.next()) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(resultSet.getString(i + 1) + "\t");
                }
                System.out.println();
            }

            resultSet.beforeFirst();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.closeConPSAndRS(connection,preparedStatement,resultSet);
        }

    }
}
