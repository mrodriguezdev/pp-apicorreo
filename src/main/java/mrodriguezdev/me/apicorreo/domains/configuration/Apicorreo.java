package mrodriguezdev.me.apicorreo.domains.configuration;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "apicorreo")
public interface Apicorreo {

    String personalEmail();

    String bussinesEmail();

    String webAppDomain();
}
