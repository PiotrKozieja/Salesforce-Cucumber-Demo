package org.example.API.configs;

import okhttp3.*;

import java.io.IOException;
import java.util.List;

import io.restassured.http.Header;

public class HttpClient {
    private final OkHttpClient client = new OkHttpClient();

    public String post(String url, RequestBody body, List<Header> headers) {

        Request.Builder requestBuilder = new Request.Builder().url(url).post(body);
        for (Header header : headers) {
            requestBuilder.addHeader(header.getName(), header.getValue());
        }
        Request request = requestBuilder.build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String get(String uri, List<Header> headers) {
        Request.Builder requestBuilder = new Request.Builder().url(uri).get();
        for (Header header: headers) {
            requestBuilder.addHeader(header.getName(), header.getValue());
        }

        Request request = requestBuilder.build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
