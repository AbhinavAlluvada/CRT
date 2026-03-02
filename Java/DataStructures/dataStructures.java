import java.util.*;
public class dataStructures{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(20);
        ArrayDeque<Integer> deqarr = new ArrayDeque<>();
        deqarr.add(15);
        deqarr.add(25);
        HashSet<Integer> hash = new HashSet<>();
        hash.add(10);
        hash.add(20);
        LinkedHashSet<Integer> linkhash = new LinkedHashSet<>();
        linkhash.add(10);
        linkhash.add(30);
        PriorityQueue<Integer> prior = new PriorityQueue<>();
        for(int i =0;i<100;i++){
            if(i%3 ==0 || i%5==0){
                prior.add(i);
            }
        }
        for(int i : prior){
            System.out.print(i+" ");
            if(i %10 ==0) System.out.println();
        }
        System.out.println();
        scanner.close();
    }
}