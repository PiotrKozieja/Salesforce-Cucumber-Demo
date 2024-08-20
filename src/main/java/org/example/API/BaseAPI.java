package org.example.API;


import io.restassured.http.Header;
import okhttp3.FormBody;
import org.example.API.configs.Body;
import org.example.API.configs.HttpClient;
import org.example.API.configs.Routes;
import org.example.utilities.EnvConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseAPI {
    private enum CRUD {GET, DELETE, UPDATE, CREATE}

    ;
    private String salesForceAuthToken;
    private HttpClient http = new HttpClient();
    private Header oauthHeader;
    private String baseUri;
    private final String CLIENT_ID = EnvConfig.get("CLIENT_ID");
    private final String CLIENT_SECRET = EnvConfig.get("CLIENT_SECRET");
    private final String SALESFORCE_USERNAME = EnvConfig.get("USERNAME_SALESFORCE");
    private final String SALESFORCE_PASSWORD = EnvConfig.get("PASSWORD_SALESFORCE");

    public void makeConnectionUsingSalesforceConnectedApp() {
        String loginURL;
        FormBody.Builder bodyBuilder = new FormBody.Builder()
                .add("client_id", CLIENT_ID)
                .add("client_secret", CLIENT_SECRET);

        loginURL = Routes.LOGIN_URL;
        bodyBuilder.add("grant_type", "password");
        bodyBuilder.add("username", SALESFORCE_USERNAME);
        bodyBuilder.add("password", SALESFORCE_PASSWORD);

        loginURL += Routes.OAUTH2_GRANT_SERVICE;

        List<Header> headers = new ArrayList<>();
        String response = http.post(loginURL, bodyBuilder.build(), headers);

        if (response == null) {
            throw new IllegalArgumentException("Response is null");
        }

        String loginInstanceURL = null;

        try {
            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();
            this.salesForceAuthToken = jsonObject.getString("access_token");
            loginInstanceURL = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        System.out.println("Connection with Salesforce API established");
        baseUri = loginInstanceURL + Routes.DATA_ENDPOINT + Routes.API_VERSION;
        oauthHeader = new Header("Authorization", "OAuth " + this.salesForceAuthToken);

    }

    protected JSONObject createObject(String objectName, JSONObject createObject) {
        String endpointUri = "/sobjects/" + objectName;

        return new JSONObject(Objects.requireNonNull(performCRUD(endpointUri, CRUD.CREATE, createObject)));
    }

    protected JSONObject getObject(String objectName, String objectId) {
        String endpointUri = "/sobjects/" + objectName + "/" + objectId;

        return new JSONObject(Objects.requireNonNull(performCRUD(endpointUri, CRUD.GET, new JSONObject())));
    }

    private String performCRUD(String endpointURI, CRUD crud, JSONObject body) {
        if (oauthHeader == null) {
            makeConnectionUsingSalesforceConnectedApp();
        }

        String uri = baseUri + endpointURI;
        List<Header> headers = new ArrayList<>();
        headers.add(oauthHeader);

        switch (crud) {
            case GET -> {
                return http.get(uri, headers);
            }
            case CREATE -> {
                Body requestBody = new Body();
                requestBody.create("application/json", body.toString());
                return http.post(uri, requestBody.getRequestedBody(), headers);
            }
            default -> {
                return null;
            }

        }
    }
}
