package com.jcq.license.verify;

import com.jcq.license.LicenseVerify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class licenseVerifyTest {

    @Autowired
    private LicenseVerify licenseVerify;

    @Test
    public void veriryTest() {

        boolean verify = licenseVerify.verify();
        System.out.println(verify);

    }
}