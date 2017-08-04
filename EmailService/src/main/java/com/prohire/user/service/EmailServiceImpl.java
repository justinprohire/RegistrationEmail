package com.prohire.user.service;

import com.prohire._domain.HireCompany;
import com.prohire.event.annotation.PHEventListener;
import com.prohire.event.annotation.PHEventType;
import com.prohire.service.PHServiceInvoker;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    public static final Logger LOGGER = Logger.getLogger(EmailServiceImpl.class);
    /**
     * This method will send an email to the address.
     *
     * @param emailAddress
     */
    @Override
    public void sendEmail(String emailAddress) {
        LOGGER.info(SERVICE_NAME + " : " + "email sent to " + emailAddress);
    }

    @Override
    public void setServiceInvoker(PHServiceInvoker phServiceInvoker) {

    }

    @PHEventListener(type = PHEventType.USER_UPDATE)
    public void logFromKafka(HireCompany hireCompany){
        LOGGER.info("KAFKA EMAIL SERVICE " + hireCompany.getShortCode());

    }

}
