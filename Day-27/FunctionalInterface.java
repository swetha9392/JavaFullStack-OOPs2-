

//@FunctionalInterface
interface Greetings{
    void sayHi(String msg);

    

}
class B implements Greetings{
    public void sayHi(String msg){
        System.out.println("message :"+ msg);
    }
}
public class FunctionalInterface {
    
    public static void main(String[] args) {
        Greetings greet=(msg)->System.out.println("Greetings!"+msg);
        greet.sayHi("swetha");
        
    }
}
