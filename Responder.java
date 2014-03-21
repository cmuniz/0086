import java.util.ArrayList;
import java.util.Random;

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
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("That sounds interesting. Tell me more...");
        respuestas.add("Reinicia el router");
        respuestas.add("Sal y vuelve a entrar");
        respuestas.add("Consulta la documentacion");
        respuestas.add("Reinicia el ordenador");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return respuestas.get(aleatorio.nextInt(5));
    }
}
