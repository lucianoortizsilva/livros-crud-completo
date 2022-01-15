package com.lucianoortizsilva.crud.seguranca.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.lucianoortizsilva.crud.seguranca.autenticacao.User;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class AuthenticationUtil {

	public static User getCurrentUser() {
		try {
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication authentication = context.getAuthentication();
			return (User) authentication.getPrincipal();
		} catch (final Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

}