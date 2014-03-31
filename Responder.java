import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{

    private Random aleatorio;
    private ArrayList<String> respuestas;
    private HashMap<HashSet<String>, String> respuestasPersonalizadas;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestasPersonalizadas = new HashMap<>();
        respuestasPorDefecto();
        respuestasPersonalizadas();
    }

    public void respuestasPorDefecto(){
        respuestas.add("That sounds interesting. Tell me more...");
        respuestas.add("Reinicia el router");
        respuestas.add("Sal y vuelve a entrar");
        respuestas.add("Consulta la documentacion");
        respuestas.add("Reinicia el ordenador");
    }

    public void respuestasPersonalizadas(){

        HashSet<String> set = new HashSet<>();
        set.add("windows");
        respuestasPersonalizadas.put(set, "Se trata de bug de windows, actualice su software");
        set = new HashSet<>();
        set.add("linux");
        respuestasPersonalizadas.put(set, "reconfigure el protocolo TCP/IP");   
        set = new HashSet<>();  
        set.add("internet");
        respuestasPersonalizadas.put(set, "se trata de un problema de su distribuidor de internet");
        set = new HashSet<>();
        set.add("linux");
        set.add("crash");
        respuestasPersonalizadas.put(set, "linux crash");
        set = new HashSet<>();
        set.add("linux");
        set.add("problem");
        respuestasPersonalizadas.put(set, "linux problem");
        set = new HashSet<>();
        set.add("linux");
        set.add("crash");
        set.add("problem");
        respuestasPersonalizadas.put(set, "linux crash problem");
        set = new HashSet<>();
        set.add("free");
        respuestasPersonalizadas.put(set, "free");
        set = new HashSet<>();
        set.add("app");
        respuestasPersonalizadas.put(set, "app");
        set = new HashSet<>();
        set.add("free");
        set.add("app");
        respuestasPersonalizadas.put(set, "free app");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponseDefault()
    {
        String respuesta;
        if(respuestas.size() > 0){
            respuesta = respuestas.remove(aleatorio.nextInt(respuestas.size()));
        }
        else{
            respuesta = "Lo siento, no he entendido la pregunta";
        }
        return respuesta;
    }

    public String generatePersonalResponse(HashSet<String> index){
        return respuestasPersonalizadas.get(index);
    }

    //     public boolean hayRespuesta(HashSet<String> palabras){
    //         boolean hayRespuesta = false;
    //         Iterator it = palabras.iterator();
    //         while(it.hasNext() && !hayRespuesta){
    //             hayRespuesta = respuestasPersonalizadas.containsKey(it.next());            
    //         }       
    //         return hayRespuesta;
    //     }

    public String generarRespuesta(HashSet<String> input){
        String respuesta = null;

        respuesta = generatePersonalResponse(input);            

        if(respuesta == null){   
            respuesta = generateResponseDefault();
        }
        return respuesta;
    }
}
