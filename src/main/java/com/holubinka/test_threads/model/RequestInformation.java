package com.holubinka.test_threads.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class RequestInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String method;

    private String uri;

    private String queryString;

    public RequestInformation(String url, String method, String uri, String queryString) {
        this.url = url;
        this.method = method;
        this.uri = uri;
        this.queryString = queryString;
    }

    public RequestInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }
}
