package com.manager.donviphathanh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Donviphathanh.
 * <p>
 * Properties are configured in the application.yml file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private GateWay gateway;

    public GateWay getGateway() {
        return gateway;
    }

    public void setGateway(GateWay gateway) {
        this.gateway = gateway;
    }

    public static class GateWay {
        private String common;
        private String quytrinhdonvi;

        public String getCommon() {
            return common;
        }

        public void setCommon(String common) {
            this.common = common;
        }

        public String getQuytrinhdonvi() {
            return quytrinhdonvi;
        }

        public void setQuytrinhdonvi(String quytrinhdonvi) {
            this.quytrinhdonvi = quytrinhdonvi;
        }
    }
}
