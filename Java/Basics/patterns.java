
public class patterns{
    void  butter(int n){
for(int i =0;i<n;i++){
            for(int j =0;j<=i;j++){
                System.out.print("* ");
            }
            for(int k =i;k<(2*n-i-2);k++){
                System.out.print("  ");
            }
            for(int l =0;l<=i;l++){
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i =n-2;i>=0;i--){
            for(int j =0;j<=i;j++){
                System.out.print("* ");
            }
            for(int k =i;k<(2*n-i-2);k++){
                System.out.print("  ");
            }
            for(int l =0;l<=i;l++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args){
        int n = 4;
        patterns obj = new patterns();
        obj.butter(n);
        
    }
}