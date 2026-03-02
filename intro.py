temp = 12321
n =temp
rev =0
while n!=0:
    digit = n%10
    rev = rev*10 + digit
    n//=10
if temp == rev:
    print("Hell Yeah")
else:
    print("Nah!")