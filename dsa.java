import java.util.*;
public class dsa {
    void print(ArrayList<Integer> arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        dsa obj = new dsa();
        Scanner scanner = new Scanner(System.in);
        System.out.println("DSA");
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.print("Enter no.of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i =0;i<n;i++){
            arr.add(scanner.nextInt());
        }
        if(n>2){
            System.out.println("Element at index 2: "+arr.get(2));
        }

        System.out.println("Before Sorting: ");
        obj.print(arr);
        System.out.println("After Sorting: ");
        Collections.sort(arr);
        obj.print(arr);

        System.out.println("Before Reversing: ");
        obj.print(arr);
        System.out.println("After Reversing: ");
        Collections.reverse(arr);
        obj.print(arr);

        ArrayDeque <Integer> dearr = new ArrayDeque<>();
        dearr.add(10);
        dearr.add(20);
        dearr.add(23);

        dearr.pop();

        
        scanner.close();
    }
}
