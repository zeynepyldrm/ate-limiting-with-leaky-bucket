package com.zeynepyldrm.service;

import org.springframework.stereotype.Service;

@Service
public class LeakyBucketService {
    private final int capacity = 100; // Kovanın kapasitesi
    private final int leakRate = 10; // Sızma hızı (birim zamanda boşaltılacak su miktarı)
    private int currentWater; // Şu anki su miktarı
    private long lastLeakTime; // Son sızdırma zamanı

    

}
