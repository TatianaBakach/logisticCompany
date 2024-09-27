package by.senla.tatianabakach.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j

public class LoggingAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void isControllerAnnotation() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service) " +
            "|| within(by.senla.tatianabakach.service.*)")
    public void isServiceLayer() {
    }

    @Pointcut("this(org.springframework.data.repository.Repository)")
    public void isRepositoryLayer() {
    }

    @Pointcut("execution(* by.senla.tatianabakach.service.*Service.getById(*)) " +
            "EntityNotFoundException")
    public void isGetByIdServiceMethod() {
    }

    @Before("isGetByIdServiceMethod() " +
            "&& args(id) " +
            "&& this(service) " +
            "&& target(proxy)")
    public void addLoggingBeforeGetByIdMethod
            (JoinPoint joinPoint,
             Object id,
             Object service,
             Object proxy) {
        log.warn("aop: getByIdMethod: id: {}, service: {}, proxy: {}",
                id, service, proxy + " " + joinPoint.toShortString());
    }

    @Before("isControllerAnnotation() " +
            "&& @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void addLoggingBeforeGetMethod() {
        log.warn("aop: before any get method");
    }

    @AfterReturning(value = "isGetByIdServiceMethod()", returning = "result")
    public void addLoggingAfterReturningGetByIdMethod(Object result) {
        log.warn("aop: after returning getByIdMethod " + result);
    }

    @AfterThrowing(value = "isGetByIdServiceMethod()", throwing = "exception")
    public void addLoggingAfterThrowingGetByIdMethod(Throwable exception) {
        log.warn("aop: after trowing getByIdMethod " + exception.getClass());
    }

    @After("isGetByIdServiceMethod()")
    public void addLoggingAfterGetByIdMethod() {
        log.warn("aop: after any get method");
    }

    @Around("isGetByIdServiceMethod() && args(id)")
    public Object addLoggingAroundGetByIdMethod(ProceedingJoinPoint joinPoint, Object id) throws Throwable {
        log.warn("aop: @Around before any get method, id: {}", id);
        try {
            Object proceed = joinPoint.proceed();
            log.warn("aop: @Around after returning getByIdMethod " + proceed);
            return proceed;
        } catch (Throwable ex) {
            log.warn("aop: @Around after trowing getByIdMethod " + ex.getClass());
        } finally {
            log.warn("aop: @Around after any get method");
        }
        return id;
    }

}
