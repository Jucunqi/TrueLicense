package com.jcq.license.config;

import com.jcq.license.LicenseVerify;
import com.jcq.license.param.LicenseVerifyParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * License配置类
 * @author : jucunqi
 * @since : 2025/1/15
 */
@Configuration
public class LicenseConfig {

    /**
     * 证书subject
     */
    @Value("${license.subject}")
    private String subject;

    /**
     * 公钥别称
     */
    @Value("${license.publicAlias}")
    private String publicAlias;

    /**
     * 访问公钥库的密码
     */
    @Value("${license.storePass}")
    private String storePass;

    /**
     * 证书生成路径
     */
    @Value("${license.licensePath}")
    private String licensePath;

    /**
     * 密钥库存储路径
     */
    @Value("${license.publicKeysStorePath}")
    private String publicKeysStorePath;

    /**
     * 是否启用license认证
     */
    @Value("${license.enable}")
    private Boolean enableLicense;

    @Bean(initMethod = "install")
    public LicenseVerify licenseVerify() {
        LicenseVerifyParam param = new LicenseVerifyParam();
        param.setSubject(subject);
        param.setPublicAlias(publicAlias);
        param.setStorePass(storePass);
        param.setLicensePath(licensePath);
        param.setPublicKeysStorePath(publicKeysStorePath);
        return new LicenseVerify(param, enableLicense);
    }
}