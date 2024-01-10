package com.lite.thinking.store.security;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {

    public String encodedPassword(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    public boolean verifyEncodedPassword(final String rawPassword, final String encodedPassword)
    {
    	final String password = encodedPassword(rawPassword);    	
    	return password.equals(encodedPassword);
    }

}