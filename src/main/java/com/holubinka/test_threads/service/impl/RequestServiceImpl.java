package com.holubinka.test_threads.service.impl;

import com.holubinka.test_threads.dao.RequestInformationDao;
import com.holubinka.test_threads.model.RequestInformation;
import com.holubinka.test_threads.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestInformationDao requestInformationDao;

    @Autowired
    private RequestInformation requestInformation;

    @Override
    public void createRequest(HttpServletRequest request) {
        requestInformation.setMethod(request.getMethod());
        requestInformation.setUri(request.getRequestURI());
        requestInformation.setUrl(request.getRequestURL().toString());
        requestInformation.setQueryString(request.getQueryString());

        requestInformationDao.saveAndFlush(requestInformation);
    }
}
