
//@FunctionalInterface
interface Calculate{
    void operation(int a, int b);
}
public class amdaExpressionFunctionalInterface{
    public static void main(String[] args){
        Calculate cc=(int a,int b)->{
        System.out.println("Sum: "+(a+b));
        System.out.println("Subtraction: "+(a-b));
        System.out.println("Multiplication: "+(a*b));
        System.out.println("Division "+(a/b));
        };
        cc.operation(10,20);
    }
}