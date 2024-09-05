package escuelaing.edu.co.arep;
import escuelaing.edu.co.arep.utils.MedAppointmentService;
import escuelaing.edu.co.arep.services.ListAppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

public class ListAppointmentServiceTest {

    private MedAppointmentService medAppointmentService;
    private ListAppointmentService listAppointmentService;

    @BeforeEach
    public void setUp() {
        medAppointmentService = new MedAppointmentService();
        listAppointmentService = new ListAppointmentService(medAppointmentService);
    }

    @Test
    void testResponse_EmptyList() {
        String request = "";
        String response = listAppointmentService.response(request);
        assertEquals("{\"appointments\":[]}", response);
    }

    @Test
    void testResponse_WithExercises() {
        medAppointmentService.addMedAppointment("Daniel", new Date(2023-05-11),"General");
        medAppointmentService.addMedAppointment("John", new Date(2023-06-11),"Prioritaria");
        String request = ""; 
        String response = listAppointmentService.response(request);
        
        assertEquals("{\"appointments\":[{\"docname\":\"Daniel\", \"date\":\"1969-12-31\", \"type\":\"General\"},{\"docname\":\"John\", \"date\":\"1969-12-31\", \"type\":\"Prioritaria\"}]}", response);
    }
}