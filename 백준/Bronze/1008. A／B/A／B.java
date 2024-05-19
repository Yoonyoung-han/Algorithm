import java.util.Scanner;
public class Main{
    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
   
        scanner.close();
        System.out.print(A/B);
    }
}