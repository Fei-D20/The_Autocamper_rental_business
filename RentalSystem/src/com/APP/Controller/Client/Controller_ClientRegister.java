package com.APP.Controller.Client;

import com.Database.DAO.User.ClientDaoImpl;
import com.Domain.User.Client;
import com.Module.Register.RegisterClient;
import com.UI.ClientUI.UI_ClientFrontPage;
import com.UI.ClientUI.UI_ClientRegister;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu
 * @ create 2021-05-04-14.34
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description this is the controller base on the ui Client register page
 * @ Version
 */
public class Controller_ClientRegister {

    /**
     * goto the client register page
     * @param pane client front page
     * @return action
     */
    public EventHandler<MouseEvent> gotoClientRegister(Pane pane) {
        EventHandler<MouseEvent> mouseEventEventHandler = event -> pane.getChildren().setAll(UI_ClientRegister.clientRegisterPage(pane));

        return mouseEventEventHandler;
    }

    /**
     * go back to client front page
     * @param pane client front page
     * @return action
     */
    public EventHandler<MouseEvent> gotoClientFrontPage(Pane pane) {
        EventHandler<MouseEvent> mouseEventEventHandler = event -> pane.getChildren().setAll(UI_ClientFrontPage.clientFrontPage(pane));

        return mouseEventEventHandler;
    }

    /**
     * this is the methods rigister new client
     * @param client
     * @return
     */
    public EventHandler<MouseEvent> clientRegister(Client client) {
        EventHandler<MouseEvent> mouseEventEventHandler = event -> {
            RegisterClient.setNewClientID();
            ClientDaoImpl clientDao = new ClientDaoImpl();
            clientDao.add(client);
            System.out.println(client.toString());
            /*
             * right here should have a pop window show the rigister is successful,
             * and have a confirm button to confirm and go back to login page.
             */
        };

        return mouseEventEventHandler;
    }


    public ChangeListener<String> clientRegisterName() {
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setName(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterPassWord() {
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setPassword(Integer.parseInt(newValue));
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterAddress() {
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setAddress(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterEmail() {
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setEmail(newValue);
            System.out.println(newValue);
        };
        return changeListener;
    }

    public ChangeListener<String> clientRegisterPhoneNo() {
        ChangeListener<String> changeListener = (observable, oldValue, newValue) -> {
            RegisterClient.getNewClient().setPhoneNo(Integer.parseInt(newValue));
            System.out.println(newValue);
        };
        return changeListener;
    }


}
