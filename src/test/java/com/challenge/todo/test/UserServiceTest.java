package com.challenge.todo.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.challenge.todo.model.User;
import com.challenge.todo.repository.RoleRepository;
import com.challenge.todo.repository.UserRepository;
import com.challenge.todo.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoderMock;

    private UserService userServiceTest;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceTest = new UserService(mockUserRepository,
                                               mockRoleRepository,
                                               bCryptPasswordEncoderMock);
        user = User.builder()
                .id(1).email("test@gmail.com")
                .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
    }

    @Test
    public void testFindUserByEmail() {
        final String email = "test@gmail.com";
        final User result = userServiceTest.findUserByEmail(email);
        
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testSaveUser() {
        final String email = "test@gmail.com";
        User result = userServiceTest.saveUser(User.builder().build());

        assertEquals(email, result.getEmail());
    }
}
