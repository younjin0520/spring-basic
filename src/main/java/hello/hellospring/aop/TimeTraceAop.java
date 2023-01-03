package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect //AOP 사용
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")    //코드 적용할 곳 타겟팅
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed(); //다음 메서드로 진행됨
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString()+" "+timeMs + "ms");
        }
    }
}
