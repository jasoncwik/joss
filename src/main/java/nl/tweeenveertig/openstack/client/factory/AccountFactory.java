package nl.tweeenveertig.openstack.client.factory;

import nl.tweeenveertig.openstack.client.Account;
import nl.tweeenveertig.openstack.client.Client;
import nl.tweeenveertig.openstack.client.impl.ClientImpl;
import nl.tweeenveertig.openstack.client.mock.ClientMock;
import org.apache.http.client.HttpClient;

public class AccountFactory {

    private AccountConfig config;

    private HttpClient httpClient;

    public void setConfig(AccountConfig config) {
        this.config = config;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Account createAccount() {
        Client client;
        if (config.isMock()) {
            client = new ClientMock().setAllowEveryone(true);
        } else {
            client = createClientImpl();
        }
        return client.authenticate(config.getTenant(), config.getUsername(), config.getPassword(), config.getAuthUrl());
    }

    protected ClientImpl createClientImpl() {
        ClientImpl client = new ClientImpl();
        if (this.httpClient != null) {
            client.setHttpClient(this.httpClient);
        }
        return client;
    }
}