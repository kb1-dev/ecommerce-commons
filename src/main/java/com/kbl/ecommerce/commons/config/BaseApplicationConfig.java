package com.kbl.ecommerce.commons.config;

import org.springframework.context.annotation.Bean;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseApplicationConfig {

    @Bean
    public JsonMapper jsonMapper() {
        return JsonMapper.builder()
                .disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
                .build();
    }
}
