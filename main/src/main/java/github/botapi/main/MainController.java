package github.botapi.main;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
/**
 * @author straycamel
 */
@Slf4j
@RestController
@RequestMapping("/")
class MainController {
    @RequestMapping("start")
    public String showAll() {
        return "start success";
    }

    @RequestMapping("test")
    public String test() {
        testHandler();
        return "start success";
    }


    public void testHandler() {
        try {
            asyncVoid(99);
            asyncHandler2(999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Pair<String, Future<Boolean>>> asyncList = new ArrayList<>();
        log.info("begain");
        for (int i = 0; i < 10; i++) {
            Pair<String, Future<Boolean>> pair = null;
            try {
                pair = Pair.of("handler" + String.valueOf(i), asyncHandler(i));
            } catch (InterruptedException e) {
                log.info("debug async task pipeline updateTask error", e);
            }
            asyncList.add(pair);
        }
        List<Future<Boolean>> list = asyncList.stream().map(Pair::getRight).collect(Collectors.toList());
        CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()])).whenComplete((res, error) -> {
            if (error != null) {
                log.info("debug async task pipeline updateTask error", error);
            }
            log.info("debug async task pipeline updateTask");
        });


        List<Pair<String, CompletableFuture<Boolean>>> asyncList2 = new ArrayList<>();
        log.info("begain2");
        for (int i = 0; i < 10; i++) {
            Pair<String, CompletableFuture<Boolean>> pair = null;
            try {
                pair = Pair.of("handler" + i, CompletableFuture.completedFuture(handler(i)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asyncList2.add(pair);
        }

        List<CompletableFuture<Boolean>> list2 = asyncList2.stream().map(Pair::getRight).collect(Collectors.toList());
        CompletableFuture.allOf(list2.toArray(new CompletableFuture[list2.size()])).whenComplete((res, error) -> {
            log.info("debug async task pipeline updateTask2");
        });
    }


    public static void main(String[] args) {
        Random r = new Random();
        int batch = 6 / 3;
        int randomIndex = r.nextInt(batch - 1);
        for (int i = 0; i < 3; i++) {
            assert i != 2;
        }
    }
    @Async("asyncHandlerExecutor")
    public Future<Boolean> asyncHandler(Integer a) throws InterruptedException {
        log.info("a = " + a);
        Boolean res = handler(a);
        return CompletableFuture.completedFuture(res);
    }


    public Boolean handler(Integer a) throws InterruptedException {
        try {
            Thread.sleep(1000);
            assert a != 2 : "assert error";
        } catch (Throwable e) {
            log.info("skip error", e);
        }
        return true;
    }


    @Async("asyncHandlerExecutor")
    public void asyncVoid(Integer a) throws InterruptedException {
        log.info("a = " + a);
        handler(a);
    }


    @Async("asyncHandlerExecutor")
    public Future<Boolean> asyncHandler2(Integer a) throws InterruptedException {
        log.info("a = " + a);
        Boolean res = handler(a);
        return CompletableFuture.completedFuture(res);
    }

}
