package com.xubo.votesystem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Author xubo
 * @Date 2022/7/7 15:50
 * JUC 之 CountDownLatch
 */
public class CountDownLatchTest {

    private final static Random random = new Random();

    static class SearchTask implements Runnable {
        private Integer id;
        private CountDownLatch latch;

        public SearchTask(Integer id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("开始寻找" + id + "活动");
            int seconds = random.nextInt(10);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println("花了" + seconds + "s,找到了" + id + "活动");
        }
    }

    public static void main(String[] args) {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        CountDownLatch countDownLatch = new CountDownLatch(idList.size());
        for (Integer id : idList) {
            Thread thread = new Thread(new SearchTask(id, countDownLatch));
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
