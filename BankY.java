import java.util.*;
public class BankY{
    static Scanner sc=new Scanner(System.in);
    HashMap<String, Integer> mapp = new HashMap<>();
    HashMap<String, Double> mapb = new HashMap<>();
    public void createAccount(){
        System.out.println("Enter your Account Number- ");
        String str=sc.next();
        System.out.println("Enter a 4-digit transaction pin to secure your account- ");
        int pin=sc.nextInt();
        System.out.println("Enter the initial amount to be credited-  ");
        double bal =sc.nextDouble();
        if(mapp.containsValue(pin)) {
            System.out.println("Create an Unique Pin !!");
            return;
        }
        mapp.put(str, pin);
        mapb.put(str, bal);
        System.out.println("CREATED ACCOUNT SUCCESSFULLY !!!!");
        System.out.println(" ");
    }
    public void withdraw(){
        System.out.println("Enter your Account Number- ");
        String str=sc.next();
        if(mapb.containsKey(str) && mapp.containsKey(str)){
            System.out.println("Enter a 4-digit transaction pin- ");
            double pin=sc.nextDouble();
            if(mapp.get(str)==pin){
                System.out.println("Enter the amount to be debited");
                double bal=sc.nextDouble();
                if(mapb.get(str)>=bal){
                   double newBal=mapb.get(str)-bal;
                    mapb.replace(str,newBal);
                    System.out.println("DEBITED RS."+bal+"SUCESSFULLY !!");
                    System.out.println(" ");
                }
                else{
                    System.out.println("INSUFFICIENT BALANCE !!");
                    System.out.println(" ");
                }
            }
            else{
                System.out.println("PIN NOT MATCHED !!!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!!");
            System.out.println(" ");
        }
    }

    public void deposit(){
        System.out.println("Enter your Account Number- ");
        String str=sc.next();
        if(mapp.containsKey(str)){
            System.out.println("Enter your 4-digit transaction pin- ");
            double pin=sc.nextDouble();
            if(mapp.get(str)==pin){
                System.out.println("Enter the amount to be deposited");
                double bal=sc.nextDouble();
                if(bal<0.00) {
                    System.out.println("Wrong format !!!");
                    System.out.println(" ");
                    return;
                }
                if(mapb.containsKey(str)){
                   double newBal=mapb.get(str)+bal;
                    mapb.replace(str,newBal);
                    System.out.println("DEPOSITED RS."+bal+"SUCESSFULLY !!");
                    System.out.println(" ");
                }
                
            }
            else{
                System.out.println("PIN NOT MATCHED !!!");
                System.out.println(" ");
            }
            
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!!");
            System.out.println(" ");
        }
    }
    public void transfer(){
        System.out.println("Enter the Sender's Account Number- ");
        String sac=sc.next();
        System.out.println("Enter the Receiver's Account Number- ");
        String rac=sc.next();
        if(mapp.containsKey(sac) && mapb.containsKey(rac)){
            System.out.println("Enter the 4-Digit pin to proceed- ");
            int pin =sc.nextInt();
            if(mapp.get(sac)==pin){
                System.out.println("Enter the Amount to be transferred- ");
                double bal=sc.nextDouble();
                if(mapb.get(sac)>=bal){
                    double newBal=mapb.get(sac)-bal;
                    mapb.replace(sac, newBal);
                    double newBalr=mapb.get(rac)+bal;
                    mapb.replace(rac, newBalr);
                    System.out.println("TRANSFERRED RS."+bal+"SUCESSFULLY");
                }
                else{
                    System.out.println("INSUFFICIENT AMOUNT ");
                    System.out.println(" ");
                }
            }
            else{
                System.out.println("WRONG PIN !!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND !!");
        }
    }

    public void display(){
        System.out.println("Enter Your Account Number- ");
        String str=sc.next();
        if(mapp.containsKey(str)){
            System.out.println("Enter 4-Digit Transaction Pin- ");
            int pin=sc.nextInt();
            if (mapp.get(str)==pin) {
                System.out.println("CURRENT MONEY = "+mapb.get(str)+". ");
                System.out.println(" ");
            }
            else{
                System.out.println("WRONG PIN!!");
                System.out.println(" ");
            }
        }
        else{
            System.out.println("ACCOUNT NOT FOUND!!!");
            System.out.println(" ");
        }

    }
    public static void main(String[] args) {
        BankY t=new BankY();
        while(true){
            System.out.println("--------------MENU-------------------");
            System.out.println("PRESS 1 TO CREATE AN ACCOUNT");
            System.out.println("PRESS 2 TO DEPOSIT MONEY IN THE ACCOUNT");
            System.out.println("PRESS 3 TO WITHDRAW MONEY FROM THE ACCOUNT");
            System.out.println("PRESS 4 TO TRANSFER MONEY TO ANOTHER ACCOUNT");
            System.out.println("PRESS 5 TO DISPLAY BALANCE");
            System.out.println("PRESS 6 TO EXIT");
            System.out.println(" ");
            System.out.println("Enter your Choice : ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    t.createAccount();
                    break;
                case 2:
                    t.deposit();
                    break;
                case 3:
                    t.withdraw();
                    break;
                case 4:
                    t.transfer();
                    break;
                case 5:
                    t.display();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter a Valid Choice !!");
            }
        }
        
    }
}