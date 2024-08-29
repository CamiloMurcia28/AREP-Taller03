/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package is.escuelaing.edu.co.springeci;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author camilo.murcia-e
 */
public class SpringECI {

    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, IllegalAccessException, InvocationTargetException {
        Class c = Class.forName(args[0]);
        Map<String, Method> services = new HashMap();
        
        //Cargar componentes
        if(c.isAnnotationPresent(RestController.class)){
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods){
                if(m.isAnnotationPresent(GetMapping.class)){
                    String key = m.getAnnotation(GetMapping.class).value();
                    services.put(key, m);
                }
            }
        }
        //Codigo quemado para ejemplo
        
        URL serviceurl = new URL("http://localhost:8080/App/hello");
        String path = serviceurl.getPath();
        System.out.println("Path: " + path);
        String serviceName = path.substring(4);
        System.out.println("Service name: " + serviceName);
        
        Method ms = services.get(serviceName);
        System.out.println("Respuesta Servicio: " + ms.invoke(null));
        
        URL serviceurl1 = new URL("http://localhost:8080/App/hello1");
        String path1 = serviceurl1.getPath();
        System.out.println("Path: " + path1);
        String serviceName1 = path1.substring(4);
        System.out.println("Service name: " + serviceName1);
        
        Method ms1 = services.get(serviceName1);
        System.out.println("Respuesta Servicio: " + ms1.invoke(null));
        
        URL serviceurl2 = new URL("http://localhost:8080/App/hello2");
        String path2 = serviceurl2.getPath();
        System.out.println("Path: " + path2);
        String serviceName2 = path2.substring(4);
        System.out.println("Service name: " + serviceName2);
        
        Method ms2 = services.get(serviceName2);
        System.out.println("Respuesta Servicio: " + ms2.invoke(null));
        
        URL serviceurl3 = new URL("http://localhost:8080/App/hello3");
        String path3 = serviceurl3.getPath();
        System.out.println("Path: " + path3);
        String serviceName3 = path3.substring(4);
        System.out.println("Service name: " + serviceName3);
        
        Method ms3 = services.get(serviceName3);
        System.out.println("Respuesta Servicio: " + ms3.invoke(null));
        
    }
}
 