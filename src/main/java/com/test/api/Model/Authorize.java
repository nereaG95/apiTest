package com.test.api.Model;

public class Authorize {

    String client_id;

    String redirect_uri;

    String response_type;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    String scope;

    public Authorize() {
    }

    public Authorize(String client_id, String redirect_uri, String response_type, String scope) {
        this.client_id = client_id;
        this.redirect_uri = redirect_uri;
        this.response_type = response_type;
        this.scope = scope;
    }
}
