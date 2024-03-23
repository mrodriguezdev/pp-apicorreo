package mrodriguezdev.me.apicorreo.infraestructure.configuration;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "apicorreo")
public interface Apicorreo {
    String personalEmail();
    String bussinesEmail();
    WebApp webApp();
    interface WebApp {
        String domain();
    }
}
