package escuelaing.edu.co.arep.controller;

import escuelaing.edu.co.arep.annotations.Component;
import escuelaing.edu.co.arep.annotations.RequestMapping;
import escuelaing.edu.co.arep.annotations.RequestParam;
import escuelaing.edu.co.arep.services.ListAppointmentService;
import escuelaing.edu.co.springeci.GetMapping;
import escuelaing.edu.co.springeci.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camilo.murcia-e
 */
@Component
@RestController
public class MedAppoController {
    
    @RequestMapping(path = "/show/list", method = "GET")
    public static String getMedAppointment(String calledServiceURI){
        return ListAppointmentService.responseRecommended();
    }
    
    @GetMapping(value = "/show/greeting")
    public static String showName(@RequestParam(value = "name", defaultValue = "CamiloMurcia") String name){
        return "Bienvenido " + name;
    }
    
}
