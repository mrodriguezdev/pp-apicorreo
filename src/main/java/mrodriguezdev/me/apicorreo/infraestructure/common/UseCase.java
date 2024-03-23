package mrodriguezdev.me.apicorreo.infraestructure.common;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.transaction.Transactional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ApplicationScoped
@Transactional
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
}
