public class overload{
    int add(int a , int b){
        return a+b;
    }
    int add(int a , int b , int c){
        return a+b+c;
    }
static class overide extends overload{
    @Override
    int add(int a , int b){
        return a+b;
    }
    void add(){
        System.out.println("Hello World!");
    }
}
public static void main(String[] args) {
    overload obj = new overload();
    int result = obj.add(10,20);
    int result2 = obj.add(12,23,34);//Overloading

    overide obj2 = new overide();
    obj2.add();
    int result3 = obj2.add(100,200);//Overriding
    System.out.println("Result: "+ result3);


    System.out.println("Add with 2 vars: "+ result);
    System.out.println("Add with 3 vars: "+ result2);
}
}



