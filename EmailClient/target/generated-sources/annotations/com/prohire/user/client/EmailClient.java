package com.prohire.user.client;

import com.prohire.service.annotation.PHServiceClient;
import com.prohire.user.service.EmailService;
import com.prohire.service.PHServiceInvoker;
import org.springframework.stereotype.Component;
import org.springframework.cache.annotation.Cacheable;

@Component
@PHServiceClient
public class EmailClient implements EmailService {

private PHServiceInvoker serviceInvoker;


	@Override
	public void sendEmail(final String emailAddress) {
		Class[] paramClasses = new Class[1];
		try {
			paramClasses[0] = Class.forName("java.lang.String");
		} catch(ClassNotFoundException cnfe) { throw new IllegalStateException(cnfe); }

		try {
			serviceInvoker.callSync("sendEmail", null, paramClasses, 60000, emailAddress);
		} catch(Throwable e){
			if(e instanceof com.prohire.service.exception.ProhireException) {
			com.prohire.service.exception.ProhireException pe = (com.prohire.service.exception.ProhireException) e;
				throw pe;
			} else {
			throw new IllegalStateException(e);
			}
		}
	}

	@Override
	public void setServiceInvoker(final PHServiceInvoker serviceInvoker) {
		this.serviceInvoker = serviceInvoker;
	}

}
