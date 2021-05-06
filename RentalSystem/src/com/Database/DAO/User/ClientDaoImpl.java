package com.Database.DAO.User;

import com.Database.JDBC.CRUD;
import com.Domain.User.Client;
import org.junit.Test;

/**
 * @ author Fei Gu
 * @ create 2021-05-05-11.26
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class ClientDaoImpl implements ClientDao {

    @Test
    public void testAdd() {
        Client client = new Client();
        client.setClientID(3);
        client.setName("Fei Gu3");
        client.setAddress("Odense3");
        client.setEmail("feix0033@easv365.dk2");
        client.setPhoneNo(12345678);

        add(client);
    }

    @Test
    public void testUpdate() {
        Client client = new Client();
        client.setClientID(001);
        client.setName("Fei Gu update ");
        client.setAddress("Odense update");
        client.setEmail("feix0033@easv365.dk update");
        client.setPhoneNo(87654321);

        update(client);

    }

    @Test
    public void testDelete() {
        delete(1);

    }

    @Test
    public void testGetInstance() {
        getInstance(1);
    }

    @Test
    public void testGetAll() {
        getAll();
    }


    @Override
    public void add(Client client) {

        try {
            String sql = "insert into tbl_Client (fld_ClientID, fld_Name, fld_Address, fld_EmailAddress, fld_PhoneNo) values (?,?,?,?,?)";

            int clientID = client.getClientID();
            String name = client.getName();
            String address = client.getAddress();
            String email = client.getEmail();
            int phoneNo = client.getPhoneNo();

            CRUD.update(sql, clientID, name, address, email, phoneNo);
            System.out.println("Add database table Client successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client client) {
        try {
            String sql = "update tbl_Client set fld_Name = ? , fld_Address = ?, fld_EmailAddress = ? , fld_PhoneNo = ? where fld_ClientID = ?";

            int clientID = client.getClientID();
            String name = client.getName();
            String address = client.getAddress();
            String email = client.getEmail();
            int phoneNo = client.getPhoneNo();

            CRUD.update(sql, name, address, email, phoneNo, clientID);
            System.out.println("Update database table Client is successful! ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "delete from tbl_Client where fld_ClientID = ?";
            CRUD.update(sql, id);
            System.out.println("Delete database table Client is successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getInstance(int id) {
        String sql = "select fld_ClientID, fld_Name, fld_Address, fld_EmailAddress, fld_PhoneNo from tbl_Client where fld_ClientID = ?";
        CRUD.getInstance(sql, id);
    }

    @Override
    public void getAll() {
        String sql = "select * from tbl_Client";
        CRUD.getTable(sql);
    }

}
