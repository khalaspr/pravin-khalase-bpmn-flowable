package com.flowable;

import com.flowable.service.MailNotification;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class MailSender  implements JavaDelegate {

    @Autowired
    private MailNotification mailNotification;
    public void execute(DelegateExecution execution) {

        this.mailNotification.sendSuccessAlert();
    }

}
