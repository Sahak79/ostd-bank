package com.ostd.rest.service.impl;

import com.ostd.config.BasicTestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.apache.commons.codec.digest.DigestUtils;

import static org.junit.Assert.*;

public class AppUserDetailsServiceTest extends BasicTestConfig {

    private static final String USERNAME = "sahak.babayan";
    private static final String PASSWORD = "ostdpass";
    private static final String USERNAME_fail = "sahak";

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void loadUserByUsername_success() {

        UserDetails userDetails = userDetailsService.loadUserByUsername(USERNAME);
        assertNotNull(userDetails);
        String sha256Password = DigestUtils.sha256Hex(PASSWORD);
        assertEquals(sha256Password, userDetails.getPassword());
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_fail() {

        userDetailsService.loadUserByUsername(USERNAME_fail);

    }
}