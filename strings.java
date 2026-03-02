import java.util.*;
public class strings {
    void string(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.next();
        scanner.nextLine();
        System.out.println("String one word entered: "+str );
        System.out.print("Enter a new String: ");
        String str2 = scanner.nextLine();
        System.out.println("String entered: "+str2);
        scanner.close();
    }
    void strlen(String str){
        for(int i =0;i<str.length();i++){
            System.out.print(str.charAt(i) +" ");
        }
        System.out.println();
    }
    boolean eq(String str, String str2){
        if(str.equals(str2)){
            return true;
        }
        return false;
    }
    void test(){
        StringBuffer str3 = new StringBuffer("Hell");
        String str5 = new String(str3);
        StringBuilder str4 = new StringBuilder("Hell");
        String str6 = new String(str4);
        if(str5 != str6 ){
            System.out.println("Hell yeah!");
        }
        if(str5.equals(str6)){
            System.out.println("Bingo!");
        }
    }
    void sample(){
        Scanner scanner = new Scanner(System.in);
        int n = 12345;
        String str = Integer.toString(n);
        System.out.println(str);
        for(int i =0;i<str.length();i++){
            System.out.println(str.charAt(i));
        }
        scanner.close();
    }
    int strcumlen(String[] strarr){
        int len = 0;
        for(String str: strarr){
            for(int i =0;i<str.length();i++){
                len++;
            }
        }
        return len;
    }
    String username(String email){
        String result ="";
        for(int i =0;i<email.length();i++){
            if(email.charAt(i) == '@'){
                break;
            }
            result += email.charAt(i);
        }
        return result;
    }
    StringBuilder rev(StringBuilder Str){
        StringBuilder reverse = new StringBuilder();
        int n = Str.length();
        for(int i =n-1;i>=0;i-- ){
            reverse.append(Str.charAt(i));
        }
        return reverse;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        strings obj = new strings();
        // System.out.print("Enter size of array: ");
        // int n = scanner.nextInt();
        // scanner.nextLine();
        // String[] str = new String[n];
        // for(int i =0;i<n;i++){
        //     str[i] = scanner.nextLine();
        // }
        // int result = obj.strcumlen(str);
        // System.out.println("Cummulative Length of the String Array: "+result);
        StringBuilder email = new StringBuilder("harsha777@gmail.com");
        StringBuilder result = obj.rev(email);
        System.out.println("Reverse: "+result);
        scanner.close();
    }
}
