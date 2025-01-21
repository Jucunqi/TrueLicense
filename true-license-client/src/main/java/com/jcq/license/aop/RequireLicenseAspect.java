package com.jcq.license.aop;


import com.jcq.license.LicenseVerify;
import com.jcq.license.annotataion.RequireLicense;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>License拦截</p>
 * <p>拦截 {@link com.jcq.license.annotataion.RequireLicense} 注解</p>
 *
 * @author : jucunqi
 * @since : 2025/1/15
 */
@Slf4j
@Aspect
@Component
public class RequireLicenseAspect {

    private final LicenseVerify licenseVerify;
    @Value("${license.enable}")
    private Boolean enableLicense;

    /**
     * 构造注入
     * @param licenseVerify License校验类
     */
    public RequireLicenseAspect(LicenseVerify licenseVerify) {
        this.licenseVerify = licenseVerify;
    }

    @Around("@annotation(requireLicense)")
    public Object switchSource(ProceedingJoinPoint point, RequireLicense requireLicense) throws Throwable {

        if (!requireLicense.value()) {
            return point.proceed();
        }
        if (!enableLicense) {
            log.info("接口：{}  ,不执行license验证", point.getSignature().getName());
            return point.proceed();
        }
        boolean verify = licenseVerify.verify();
        log.info("接口：{} , License验证结果：{}", point.getSignature().getName(), verify);
        if (verify) {
            return point.proceed();
        }

        throw new RuntimeException("License认证失败");
    }
}
