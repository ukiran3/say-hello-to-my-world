import java.util.Arrays;
    import java.util.Scanner;


public class Factor
{
    
public static void main(String[] args)
{
Scanner kbinput = new Scanner(System.in);
StackOfInteger stack = new StackOfInteger();
System.out.print(
"Enter a positive integer: ");
int number = kbinput.nextInt();
System.out.println("The factors for " + number + " are");
int factor = 2;

while (factor <= number)
{
int i=0;
if (number % factor == 0) {
number /= factor;
stack.push(factor);
}
else {
factor++;
}
}
while (!stack.empty())
      System.out.println(stack.pop() + " ");  
}
}