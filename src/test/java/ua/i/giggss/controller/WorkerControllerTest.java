package ua.i.giggss.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import ua.i.giggss.model.Worker;
import ua.i.giggss.service.WorkerService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorkerControllerTest {

    @Mock
    private WorkerService workerService;
    @InjectMocks
    private WorkerController workerController;

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new ExtendedModelMap();
    }

    @Test
    public void listWorkers() throws Exception {
        List<Worker> expectedWorker = asList();
        when(workerService.listWorkers()).thenReturn(expectedWorker);
        assertEquals("workers", workerController.listWorkers(model));
        assertSame(expectedWorker, model.asMap().get("listWorkers"));
    }

    @Test
    public void removeWorker() throws Exception {
        String result = workerController.removeWorker(13);
        assertEquals("redirect:/workers", result);
    }

    @Test
    public void editWorker() throws Exception {
        List<Worker> expectedWorker = asList();
        when(workerService.listWorkers()).thenReturn(expectedWorker);
        assertEquals("workers", workerController.listWorkers(model));
        assertSame(expectedWorker, model.asMap().get("listWorkers"));
    }

    @Test
    public void addWorker() throws Exception {
        Worker worker = new Worker();
        String result = workerController.addWorker(worker);
        assertEquals("redirect:/workers", result);
    }

}