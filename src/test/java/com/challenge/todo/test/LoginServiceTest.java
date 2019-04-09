package com.challenge.todo.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.challenge.todo.controller.LoginController;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginServiceTest {

    @Autowired
    private LoginController loginController;

    @Before
    public void setup() {
        //Security data
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    public void given_callLogin_willReturn_loginViewName() {
        // WHen
        ModelAndView modelAndView = loginController.login();

        // Return
        assertEquals("login", modelAndView.getViewName());
    }

    @Test
    public void given_callHome_willReturn_homeViewName() {
        // WHen
        ModelAndView modelAndView = loginController.home();

        // Return
        assertEquals("admin/home", modelAndView.getViewName());
    }

}
