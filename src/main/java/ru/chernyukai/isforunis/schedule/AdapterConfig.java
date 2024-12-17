package ru.chernyukai.isforunis.schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Bean
    public YGTUAdapter ygtuAdapter() {
        return new YGTUAdapter(new YSTUSystem());
    }

    @Bean
    public YARGUAdapter yarguAdapter() {
        return new YARGUAdapter(new YARGUSystem());
    }

    @Bean
    public YGMUAdapter ygmuAdapter() {
        return new YGMUAdapter(new YGMUSystem());
    }
}
