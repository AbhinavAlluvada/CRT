import java.util.*;
public class sorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array size: ");
        int n = scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i =0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
                for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        

        scanner.close();
    }
}
