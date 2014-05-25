
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public static void time(){
        long a = System.currentTimeMillis();
        for(int cont = 1; cont <= 1000000; cont++){
            System.out.println(cont);
        }
        long b = System.currentTimeMillis();
        
        System.out.println("segundos: " + (b-a)/1000.0 + " minutos: " + (b-a)/60000.0);
    }
}
