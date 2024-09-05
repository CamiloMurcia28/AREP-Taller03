/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.arep;

import escuelaing.edu.co.arep.annotations.ComponentLoader;
import escuelaing.edu.co.arep.annotations.RequestMapping;
import escuelaing.edu.co.springeci.GetMapping;
import escuelaing.edu.co.springeci.RestController;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author camilo.murcia-e
 */
public class SpringServer {
    
    private static SpringServer instance;
    private ComponentLoader components;
    private final Map<String, Method> getRoutes = new HashMap<>();
    private final Map<String, Method> postRoutes = new HashMap<>();
    
    
    /**
     * Private constructor for the SantaSpark class.
     */
    private SpringServer(){
        this.components = new ComponentLoader(App.class);
        saveMappings();
    }
    
    /**
     * Method to set the static file location.
     * 
     * @param path The path of the static file location.
     */
    private void saveMappings() {
         for (Class<?> cls : components.getClasscomponents()) {
            if(cls.isAnnotationPresent(RestController.class)){
                for (Method method : cls.getDeclaredMethods()) {
                    String path;
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        path = method.getAnnotation(RequestMapping.class).path();
                    }else{
                        path = method.getAnnotation(GetMapping.class).value();
                    }
                    getRoutes.put(path,method);
                }
            }
        }
    }
    
    /**
     * 
     * Method to find the mapping method.
     * @param path   The path of the route.
     * @return The method of the route.
     */
    public static Method findMappingMethod(String path) {
        Method method = null;
        SpringServer springServer = getInstance();
        if(springServer.getRoutes.containsKey(path)){
            method = springServer.getRoutes.get(path);
        }
        return method;
    }
    
    
    /**
     * 
     * Method to get the instance of the SparkServer class.
     * @return The instance of the SparkServer class.
     */
    public static SpringServer getInstance(){
        if(instance == null){
            instance = new SpringServer();
        }
        return instance;
    }
    
}
