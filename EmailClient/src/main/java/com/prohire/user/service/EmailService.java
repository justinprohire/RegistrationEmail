package com.prohire.user.service;

import com.prohire.service.ProhireService;
import com.prohire.service.annotation.PHEndpoint;
import com.prohire.service.annotation.PHEndpoints;
import com.prohire.service.annotation.PHService;
import com.prohire.service.annotation.PHServiceMethod;

@PHService(minor = 1,major = 1)
@PHEndpoints(endpoints = {
        @PHEndpoint(name = EmailService.EMAIL_SYNC_ENDPOINT,synchronous = true)
}
)
public interface EmailService extends ProhireService {

    public static final String EMAIL_SYNC_ENDPOINT ="emailServiceSync";
    public static final String EMAIL_ASYNC_ENDPOINT ="emailServiceAsync";
    public static final String EMAIL_METHOD ="sendEmail";

    public static final String SERVICE_NAME ="Email_Service";

    @PHServiceMethod(endPointName = EMAIL_SYNC_ENDPOINT,name = EMAIL_METHOD)
    void sendEmail(String emailAddress);

}
