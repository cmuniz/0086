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
    private HashMap<String, String> respuestasPersonalizadas;
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
        respuestasPersonalizadas.put("windows", "Se trata de bug de windows, actualice su software");
        respuestasPersonalizadas.put("linux", "reconfigure el protocolo TCP/IP");        
        respuestasPersonalizadas.put ("internet", "se trata de un problema de su distribuidor de internet");
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

    public String generatePersonalResponse(String index){
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
        Iterator<String> it = input.iterator();

        while(it.hasNext() && respuesta == null){
            //             respuesta = respuestasPersonalizadas.get(it.next());
            respuesta = generatePersonalResponse(it.next());            
        }  

        if(respuesta == null){   
            respuesta = generateResponseDefault();
        }
        return respuesta;
    }
}
