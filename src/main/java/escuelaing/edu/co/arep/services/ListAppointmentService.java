package escuelaing.edu.co.arep.services;

import escuelaing.edu.co.arep.MedAppointment;
import escuelaing.edu.co.arep.utils.MedAppointmentService;
import escuelaing.edu.co.arep.services.RESTService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Camilo Murcia
 */
public class ListAppointmentService implements RESTService{

    private MedAppointmentService medAppointmentService;
    
    public ListAppointmentService(MedAppointmentService medAppointmentService){
        this.medAppointmentService = medAppointmentService;
    }
    
    @Override
    public String response(String request) {
        ArrayList<MedAppointment> appointments = medAppointmentService.getAppointments();
        return "{\"appointments\":[" +
        appointments.stream()
                .map((MedAppointment medAppointment) -> String.format("{\"docname\":\"%s\", \"date\":\"%s\", \"type\":\"%s\"}",
                                                    medAppointment.getName(),
                                                    new SimpleDateFormat("yyyy-MM-dd").format(medAppointment.getDate()),
                                                    medAppointment.getType()))
                .collect(Collectors.joining(",")) +
        "]}";
    }
    public static String responseRecommended() {
        return "{\"appointments\":[{\"docname\":\"Pablo\",\"date\":\"2024-10-12\",\"type\":\"seguimiento\"},{\"docname\":\"Laura\",\"date\":\"2024-11-12\",\"type\":\"general\"}]}";
    }
    
}