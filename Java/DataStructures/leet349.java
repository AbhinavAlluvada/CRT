import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class leet349 {
    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<>();
        int[] arr = {4,9,5};
        for(int i : arr){
            nums1.add(i);
        }

        ArrayList <Integer> nums2 = new ArrayList<>();
        int[] arr2 = {9,4,9,8,4,2};
        for(int i : arr2){
            nums2.add(i);
        }

        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i =0;i<nums1.size();i++){
            for(int j =0;j<nums2.size();j++){
                if(nums1.get(i) == nums2.get(j)){
                    set.add(nums1.get(i));
                }
            }
        }

        for(int i: set){
            result.add(i);
        }

        System.out.println("Final Output of Intersection Arrays: ");
        System.out.print("[ ");
        for(int i : result){
            System.out.print(i+" ");
        }
        System.out.println("]");
    }
}
