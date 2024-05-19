package com.example.restforexam.controller;

import com.example.restforexam.controller.info.MemoryInfo;
import com.example.restforexam.controller.info.ServiceInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public ServiceInfo getHealth() {
        Runtime runtime = Runtime.getRuntime();

        return ServiceInfo.builder()
                .status("UP")
                .timestamp(System.currentTimeMillis())
                .serviceName(this.getClass().getName())
                .memoryInfo(MemoryInfo.builder()
                        .freeMemory(runtime.freeMemory())
                        .usedMemory(runtime.totalMemory() - runtime.freeMemory())
                        .totalMemory(runtime.totalMemory())
                        .maxMemory(runtime.maxMemory())
                        .build())
                .build();
    }
}
