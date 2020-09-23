package com.mci.commonerrors.nullvalue.avoidnullpointerexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AvoidNullPointerException {

    /*
        NullPointerException 是 Java 代码中最常见的异常，我将其最可能出现的场景归为以下 5 种：
        - 参数值是 Integer 等包装类型，使用时因为自动拆箱出现了空指针异常；
        - 字符串比较出现空指针异常；
        - 诸如 ConcurrentHashMap 这样的容器不支持 Key 和 Value 为 null，强行 put null 的 Key 或 Value 会出现空指针异常；
        - A 对象包含了 B，在通过 A 对象的字段获得 B 之后，没有对字段判空就级联调用 B 的方法出现空指针异常；
        - 方法或远程服务返回的 List 不是空而是 null，没有进行判空就直接调用 List 的方法出现空指针异常。
     */

    private static Logger log = LoggerFactory.getLogger(AvoidNullPointerException.class);

    public static void main(String[] args) {
        String test = "1111";

        wrong(test);
        right(test);

        log.info("test");
    }

    public static int wrong(String test) {
        return wrongMethod(test.charAt(0) == '1' ? null : new FooService(),
                test.charAt(1) == '1' ? null : 1,
                test.charAt(2) == '1' ? null : "OK",
                test.charAt(3) == '1' ? null : "OK").size();
    }

    public static int right(String test) {
        return Optional.ofNullable(rightMethod(test.charAt(0) == '1' ? null : new FooService(),
                test.charAt(1) == '1' ? null : 1,
                test.charAt(2) == '1' ? null : "OK",
                test.charAt(3) == '1' ? null : "OK"))
                .orElse(Collections.emptyList()).size();
    }

    private static List<String> wrongMethod(FooService fooService, Integer i, String s, String t) {
        if (fooService.getBarService().bar().equals("OK")) // NullPointerException very difficult to locate this exception, try Arthas TODO
            System.out.println("bar service OK");
        return null;
    }

    private static List<String> rightMethod(FooService fooService, Integer i, String s, String t) {
        Optional.ofNullable(fooService)
                .map(FooService::getBarService)
                .filter(barService -> "OK".equals(barService.bar()))
                .ifPresent(result -> System.out.println("OK"));

        return new ArrayList<>();
    }

    static class FooService {
        private BarService barService;

        public BarService getBarService() {
            return barService;
        }

        public void setBarService(BarService barService) {
            this.barService = barService;
        }
    }

    class BarService {
        String bar() {
            return "bar OK";
        }
    }
}
