package com.flowable;

import com.flowable.model.Person;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class CallExternalSystemDelegate implements JavaDelegate {

    public void execute(DelegateExecution execution) {

        System.out.println("Approving the task....");

    }

}
