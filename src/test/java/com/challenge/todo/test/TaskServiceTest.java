package com.challenge.todo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.challenge.todo.model.Task;
import com.challenge.todo.model.User;
import com.challenge.todo.repository.TaskRepository;
import com.challenge.todo.service.TaskService;

public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    private TaskService taskServiceTest;
    private Task task;

    @Before
    public void setUp() {
        initMocks(this);
        taskServiceTest = new TaskService(taskRepository);
        task = new Task(1, "Do something", new Date(), new Date(), 2, new User());

        Mockito.when(taskRepository.save(any()))
                .thenReturn(task);
    }

    @Test
    public void testSaveTask() {
        final String taskDescription = "Do something";
        Task result = taskServiceTest.saveTask(new Task());

        assertEquals(taskDescription, result.getDescription());
    }
}
