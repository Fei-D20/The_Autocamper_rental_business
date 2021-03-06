package com.Module.Register;

import com.Domain.User.Client;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu
 * @ create 2021-05-05-10.56
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description this is the singleton patten to make only one client when we need insert new client though the UI
 * @ Version
 */
public class RegisterClient {
    private static Client newClient = new Client();

    private RegisterClient() {
    }


    public static Client getNewClient() {
        return newClient;
    }

    public static void setNewClientID() {
        /*
         * this is a simple and unique way to identify the customer but there is a not easy way to find the specific
         * user so I should make a searching method to find the ClientID.
         */
        newClient.setClientID(newClient.hashCode());
    }

}
