public class transpose{
    void print(int arr[][]){
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        transpose obj = new transpose();
        System.out.println("Before Transpose: ");
        obj.print(arr);
        for(int i = 0;i<3;i++){
            for(int j =i;j<3;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("After Transpose: ");
        obj.print(arr);
    }
}