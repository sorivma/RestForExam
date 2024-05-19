package com.example.restforexam.controller.info;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceInfo {
    private String status;
    private Long timestamp;
    private String serviceName;
    private MemoryInfo memoryInfo;
}
