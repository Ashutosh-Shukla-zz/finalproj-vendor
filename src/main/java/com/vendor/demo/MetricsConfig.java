package com.vendor.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

  @Bean
  MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
    return registry -> registry.config()
        .meterFilter(MeterFilter.deny(id -> {
          String uri = id.getTag("uri");
          return uri != null && uri.startsWith("/actuator");
        }))
        .meterFilter(MeterFilter.deny(id -> {
          String uri = id.getTag("uri");
          return uri != null && uri.contains("favicon");
        }));
  }
}