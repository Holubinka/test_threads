package com.holubinka.test_threads.model;

import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;

@Entity
@Table(name = "request_log")
public class RequestInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String remoteHost;

    private String method;

    private String uri;

    public RequestInformation(HttpServletRequest request) {
        this.url = request.getRequestURL().toString();
        this.remoteHost = request.getRemoteHost();
        this.method = request.getMethod();
        this.uri = request.getRequestURI();
    }

    public RequestInformation(String url, String remoteHost, String method, String uri) {
        this.url = url;
        this.remoteHost = remoteHost;
        this.method = method;
        this.uri = uri;
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

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
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
}
