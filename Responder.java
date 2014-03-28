import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
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
        return respuestas.get(aleatorio.nextInt(5));
    }

    public String generatePersonalResponse(String index){
        return respuestasPersonalizadas.get(index);
    }

    public boolean hayRespuesta(String index){
        return respuestasPersonalizadas.containsKey(index);
    }

    public String generarRespuesta(String input){
        String respuesta;
        if(hayRespuesta(input)){
            respuesta = generatePersonalResponse(input);
        }
        else{                    
            respuesta = generateResponseDefault();
        }
        return respuesta;
    }
}
