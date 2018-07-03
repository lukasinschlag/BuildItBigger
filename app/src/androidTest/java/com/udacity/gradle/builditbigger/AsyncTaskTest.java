package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void getJokeFromAsyncTask() {
        try {
            String joke = new EndpointAsyncTask().execute().get();
            Assert.assertNotNull(joke);
            Assert.assertNotEquals("", joke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
