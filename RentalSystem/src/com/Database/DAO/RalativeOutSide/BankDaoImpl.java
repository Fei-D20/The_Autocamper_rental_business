package com.Database.DAO.RalativeOutSide;

import com.Database.JDBC.CRUD;
import com.Domain.RelativeOutSide.Bank;
import org.junit.Test;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-08.12
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class BankDaoImpl implements BankDao {
    @Test
    public void testAddBank() {
        Bank bank1 = new Bank();
        bank1.setBankID(5);
        bank1.setBankName("EASVBank");

        add(bank1);
//        getAll();
    }

    @Test
    public void testDeleteGet() {
        getInstance(5);
        delete(5);
        getAll();

    }

    @Override
    public void add(Bank bank) {
        try {
            String sql = "INSERT INTO tbl_Bank(fld_BankID,fld_BankName) values (?,?) ";
            CRUD.update(sql, bank.getBankID(), bank.getBankName());
            System.out.println("Insert finished");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Bank bank) {
        try {
            String sql = "update tbl_Bank set fld_BankName = ? where fld_BankID = ? ";
            CRUD.update(sql, bank.getBankName(), bank.getBankID());
            System.out.println("update finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = " delete from tbl_Bank where fld_BankID = ? ";
            CRUD.update(sql, id);
            System.out.println("delete finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInstance(int id) {
        String sql = "select fld_BankID, fld_BankName from tbl_Bank where fld_BankID = ?";
        CRUD.getInstance(sql, id);

    }

    @Override
    public void getAll() {
        String sql = "select * from tbl_Bank";
        CRUD.getTable(sql);
    }
}
