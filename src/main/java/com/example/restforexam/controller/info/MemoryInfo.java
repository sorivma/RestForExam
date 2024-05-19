package com.example.restforexam.controller.info;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemoryInfo {
    private long totalMemory;
    private long freeMemory;
    private long usedMemory;
    private long maxMemory;
}
