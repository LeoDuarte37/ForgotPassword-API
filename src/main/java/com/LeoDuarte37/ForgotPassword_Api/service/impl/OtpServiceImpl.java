package com.LeoDuarte37.ForgotPassword_Api.service.impl;

import com.LeoDuarte37.ForgotPassword_Api.service.OtpService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OtpServiceImpl implements OtpService {

    private final LoadingCache<String, Integer> otpCache;

    public OtpServiceImpl() {
        super();

        otpCache = CacheBuilder.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(new CacheLoader<>() {
                    @Override
                    public Integer load(String s) throws Exception {
                        return 0;
                    }
                });
    }

    @Override
    public Integer generateOtp(String key) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        otpCache.put(key, otp);

        return otp;
    }

    @Override
    public Integer getOtpByKey(String key) {
        return otpCache.getIfPresent(key);
    }

    @Override
    public void clearOtpFromCache(String key) {
        otpCache.invalidate(key);
    }

    @Override
    public boolean validateOtp(String key, Integer otp) {
        Integer cacheOtp = getOtpByKey(key);

        if (cacheOtp != null && cacheOtp.equals(otp)) {
            clearOtpFromCache(key);
            return true;
        }

        return false;
    }
}
