package com.zeynepyldrm.service;

import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LeakyBucketService {

    @Getter
    private final int capacity = 20; // Kovanın kapasitesi
    @Getter
    private int currentWater;

    private long lastLeakTime; // Son sızdırma zamanı


    @Scheduled(fixedRate = 10000)
    public void leakRequestFromBucket() {
        int leakRate = 5;
        if (currentWater > 0 && currentWater < leakRate) {
            currentWater = 0;
        }
        if (currentWater >= leakRate) {
            currentWater -= leakRate;
            lastLeakTime = new Date().getTime();
        }
    }

    public synchronized boolean addRequestBucket(){
        if (capacity > currentWater) {
            currentWater++;
            return true;
        }
        return false;
    }
}

