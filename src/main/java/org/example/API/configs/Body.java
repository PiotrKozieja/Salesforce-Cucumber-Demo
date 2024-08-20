package org.example.API.configs;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Body {

    private RequestBody requestBody;

    public void create(String contentType, String jsonBody) {
        this.requestBody = RequestBody.create(
                jsonBody, MediaType.parse(contentType));
    }

    public RequestBody getRequestedBody() {
        return this.requestBody;
    }
}
