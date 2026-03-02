#include <stdio.h>
#include <string.h>
#include <ctype.h>
int operator(char ch){
    return (ch =='+' || ch == '-' || ch == '*' || ch == '/');
}
int isvaild(char ch[]){
    int i , open = 0;
    int len = strlen(ch);
    if(operator(ch[0]))
    return 0;
    if(operator(ch[len-2]))
    return 0;
    for(int i =0;i<len;i++){
        if(operator(ch[i]) && operator(ch[i++])){
            return 0;
        }
        if(ch[i] == '(')
    open++;
    if(ch[i] == ')')
    open--;
    if(open<0 || open!=0){
        return 0;
    }
    else{
        return 1;
    }
    }

}
int main(){
    char ch[100];
    fgets(ch,sizeof(ch),stdin);
    if(isvaild(ch))
    printf("True");
    else
    printf("False");
    return 0;
}