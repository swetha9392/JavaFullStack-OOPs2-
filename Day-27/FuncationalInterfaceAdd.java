
interface Add{
    int add(int a,int b);
}

public class FuncationalInterfaceAdd {
    public static void main(String[] args) {
         Add ad=(a,b)-> a + b;
         System.out.println("sum of two  nos:"+ad.add(10,20));
        
    }
    
}
