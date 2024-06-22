import java.util.*;
//import java.lang.*;
public class GuessNumber {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Y to START THE GAME ");
        char ch=sc.next().charAt(0);
        System.out.println("------------GAME STARTS---------------");
        double rand=Math.random()*50;
        int c=0;
        while(ch=='Y'||ch=='y'){
            System.out.print("Enter a Number (between 1 to 50):- ");
            int n=sc.nextInt();
            if(n>50) {
                System.out.println("OUT OF RANGE ...TRY AGAIN");
                continue;
            }
            System.out.println("");
            if(n == (int) rand){
                System.out.println("Match FOUND !!!!!");
                System.out.println("You earned 1 point !!!");
                c++;
                System.out.println("Do you want to continue (Y/N)");
                ch=sc.next().charAt(0);
                rand=Math.random()*10;
            }
            else{
                System.out.println("Match NOT FOUNND ");
                if(n<(int)rand) System.out.println("Entered number is LOWER than the targeted number !!");
                else System.out.println("Entered number is HIGHER than the targeted number !!");
                System.out.println(" ");
                continue;
            }
        }
        System.out.println("Your Total Points :"+c);
        System.out.println("-------------GAME ENDS--------------");
        sc.close();
    }
}


