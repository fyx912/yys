package com.yys;

import com.yys.domain.User;
import com.yys.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConcurrenceTest {
    private  int sum = 1;
    private CountDownLatch count = new CountDownLatch(sum);



    @Test
    public void test(){
        for (int i = 0 ;i<sum ;i++){
            new Thread(new MyThread()).start();
            count.countDown();
        }
    }

    protected class MyThread implements Runnable{
        @Autowired
        private   UserService<User> userService;
        @Override
        public void run() {
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String userIterable = this.userService.count("123456");
            System.out.println(userIterable);
        }
    }
}
