package com.APP.Controller.Client;

import com.Database.DAO.User.ClientDaoImpl;
import com.Domain.User.Client;
import com.Module.Register.RegisterClient;
import com.UI.ClientUI.UI_ClientRegister;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * @ author Fei Gu
 * @ create 2021-05-04-14.34
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description
 * @ Version
 */
public class Controller_ClientRegister {

    public EventHandler<MouseEvent> gotoClientRegister(Stage stage){
        EventHandler<MouseEvent> mouseEventEventHandler = event -> UI_ClientRegister.clientRegisterPage(stage);

        return mouseEventEventHandler;
    }

    public EventHandler<MouseEvent> ClientRegister(Client client){
        EventHandler<MouseEvent> mouseEventEventHandler = event -> {
            RegisterClient.setNewClientID();
            ClientDaoImpl clientDao = new ClientDaoImpl();
            clientDao.add(client);
            System.out.println(client.toString());
        };

        return mouseEventEventHandler;
    }


    public ChangeListener<String> clientRegisterName(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setName(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterPassWord(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setPassword(Integer.parseInt(newValue));
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterAddress(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setAddress(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterEmail(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setEmail(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterPhoneNo(){
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setPhoneNo(Integer.parseInt(newValue));
            System.out.println(newValue);
        };
        return changeListener;
    }



}
