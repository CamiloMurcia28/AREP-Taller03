/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package is.escuelaing.edu.co.springeci;

/**
 *
 * @author camilo.murcia-e
 */
@RestController
public class HelloService {
    
    @GetMapping("/hello")
    public static String hello(){
        return "Hello World!";
    }
    @GetMapping("/hello1")
    public static String hello1(){
        return String.valueOf(Math.PI);
    }
    @GetMapping("/hello2")
    public static String hello2(){
        return "Hola Mundo!";
    }
    @GetMapping("/hello3")
    public static String hello3(){
        return "Zdravo svijete!";
    }
    
}
