import java.util.*;
public class D2Arrays{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter no of rows: ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter no of cols: ");
        int col = scanner.nextInt();
        scanner.nextLine();
        int arr[][] = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                System.out.print("Element at row ("+i+") and col ("+j+"): ");
                arr[i][j] = scanner.nextInt();
            }
        }
        for(int i =0;i<row;i++){
            for(int j =0;j<col ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}