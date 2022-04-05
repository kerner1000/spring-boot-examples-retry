package com.github.kerner1000.examples.springboot.retry;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    /**
     * Do not call from within this class. Will not work.
     *
     * @throws Exception always throws an exception for demo purposes
     */
    @Retryable(value = Exception.class)
    public void retryMethod() throws Exception {
        System.out.println("throwing exception to retry");
        throw new Exception();
    }

    public void notRetryMethod() {
        System.out.println("normal method");
    }

    @Recover
    public void recover(Exception exception) {
        System.out.println("failed to recover from " + exception);
    }
}
