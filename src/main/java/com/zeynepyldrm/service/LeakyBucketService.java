package com.zeynepyldrm.service;

import lombok.Getter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LeakyBucketService {

    @Getter
    private final int capacity = 20; // Kovanın kapasitesi
    private final int leakRate = 5; // Sızma hızı (birim zamanda boşaltılacak su miktarı)
    @Getter
    private int currentWater; // Şu anki su miktarı
    private long lastLeakTime; // Son sızdırma zamanı


    @Scheduled(fixedRate = 10000)
    public void leakRequestFromBucket() {
        if (currentWater > 0 && currentWater < leakRate) {
            currentWater = 0;
            System.out.println("kovadan request bosaltıldı" + lastLeakTime);
        }
        if (currentWater >= leakRate) {
            currentWater -= leakRate;
            lastLeakTime = new Date().getTime();
            System.out.println("kovadan request bosaltıldı" + lastLeakTime);
        }


    }

    public synchronized void addRequestBucket(){
        if (capacity > currentWater) {
            currentWater++;
            System.out.println("kovaya request geldi");
        } else {
            System.out.println("kovaya request atılamadı. kova doldu");
        }
    }
}

