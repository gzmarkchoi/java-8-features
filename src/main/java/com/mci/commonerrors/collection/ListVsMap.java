package com.mci.commonerrors.collection;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListVsMap {
    /*
        - 搜索 ArrayList 的时间复杂度是 O(n)，而 HashMap 的 get 操作的时间复杂度是 O(1)
        - 要对大 List 进行单值搜索的话，可以考虑使用 HashMap，其中 Key 是要搜索的值，Value 是原始对象，
          会比使用 ArrayList 有非常明显的性能优势
     */
    public static void main(String[] args) throws InterruptedException {
        int elementCount = 1000000;
        int loopCount = 1000;
        Instant start = Instant.now();
        Object list = listSearch(elementCount, loopCount);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        System.out.println("ArrayList search: " + timeElapsed);

        start = Instant.now();
        Object map = mapSearch(elementCount, loopCount);
        finish = Instant.now();
        timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Map search: " + timeElapsed);

        TimeUnit.HOURS.sleep(1);
    }

    private static Object listSearch(int elementCount, int loopCount) {
        List<Order> list = IntStream.rangeClosed(1, elementCount).mapToObj(i -> new Order(i)).collect(Collectors.toList());
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Order result = list.stream().filter(order -> order.getOrderId() == search).findFirst().orElse(null);
            // Assert.assertTrue(result != null && result.getOrderId() == search);
        });

        return list;
    }

    private static Object mapSearch(int elementCount, int loopCount) {
        Map<Integer, Order> map = IntStream.rangeClosed(1, elementCount).boxed().collect(Collectors.toMap(Function.identity(), i -> new Order(i)));
        IntStream.rangeClosed(1, loopCount).forEach(i -> {
            int search = ThreadLocalRandom.current().nextInt(elementCount);
            Order result = map.get(search);
            // Assert.assertTrue(result != null && result.getOrderId() == search);
        });

        return map;
    }

    static class Order {
        private int orderId;

        public Order(int orderId) {
            this.orderId = orderId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    }
}
