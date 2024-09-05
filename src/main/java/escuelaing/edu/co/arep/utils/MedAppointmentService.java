package escuelaing.edu.co.arep.utils;

import escuelaing.edu.co.arep.MedAppointment;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Camilo Murcia
 */
public class MedAppointmentService {
    private ArrayList<MedAppointment> appointments = new ArrayList<MedAppointment>();
    
    public ArrayList<MedAppointment> getAppointments(){
        return this.appointments;
    }    
    
    public void addMedAppointment(String docName, Date schDate, String appointmentType){
        appointments.add(new MedAppointment(docName, schDate, appointmentType));
    }
}
