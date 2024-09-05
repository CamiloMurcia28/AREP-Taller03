package escuelaing.edu.co.arep;

import escuelaing.edu.co.arep.annotations.ComponentScan;
import escuelaing.edu.co.arep.services.AddMedAppointmentService;
import escuelaing.edu.co.arep.services.ListAppointmentService;
import escuelaing.edu.co.arep.utils.MedAppointmentService;
import java.io.*;

@ComponentScan(basePackage = "escuelaing.edu.co.arep")
public class App {

    private static final MedAppointmentService medAppointmentService = new MedAppointmentService();
    
    /**
     * The main method of the application.
     * 
     * @param args Command-line arguments passed to the program.
     */
    public static void main(String[] args) throws IOException {
        // Set the static files location
        SparkServer.staticFileLocation("target/classes/webroot");

        // Define the Rest services
        SparkServer.get("/app/medAppointment", (req) ->{
            ListAppointmentService listAppointmentService =  new ListAppointmentService(medAppointmentService);
            String response = listAppointmentService.response(req);
            return response;
        });

        SparkServer.post("/app/addMedAppointment", (req) ->{
            AddMedAppointmentService addMedAppointmentService = new AddMedAppointmentService(medAppointmentService);
            String response = addMedAppointmentService.response(req);
            return response;
        });

        //Load the services with the mini Spring framework.
        SpringServer.getInstance();

        // Start the server
        try {
            if (!AREP.getInstance().isRunning())
                AREP.getInstance().start();
        } catch (Exception e) {
            System.err.println("Error en el servidor" + e.getMessage());
            System.exit(1);
        }

    }
}