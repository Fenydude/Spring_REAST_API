package com.bogurov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceSetting {
    @Value("${messageSource}")
    private String Basename;

    public String getBasename() {
        return Basename;
    }

    public void setBasename(String basename) {
        Basename = basename;
    }
}
