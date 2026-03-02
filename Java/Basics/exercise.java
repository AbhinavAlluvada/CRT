import java.util.*;
public class exercise {
    void avg(int a , int b , int c){
        int avg1 = (a+b+c)/3;
        System.out.println("Average: "+avg1);
    }
    void oddsum(int n){
        int sum = 0;
        for(int i =0;i<n;i++){
            if(i%2 == 1){
                sum = sum + i;
            }
        }
        System.out.println("Sum of odd nums: "+sum);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        exercise obj = new exercise();
        obj.oddsum(n);
        scanner.close();

    }
    
}
