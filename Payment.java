import java.util.*;
import java.lang.Thread;
public class Payment{
    private int paymentCode;
    private double totalAllPrice;
    
    public Payment(){}
    
    public Payment(int c, double t){
        this.paymentCode=c;
        this.totalAllPrice=t;
    }
    
    public void setPaymentCode(int c){this.paymentCode=c;}
    public void setTotalAllPrice(double t){this.totalAllPrice=t;}
    
    public int getPaymentCode(){return this.paymentCode;}
    public double getTotalAllPrice(){return this.totalAllPrice;}
    
    public void makePayment(){
        Scanner in = new Scanner(System.in);
        Scanner inline = new Scanner(System.in);
        double totalFr=0.00;
        if(this.paymentCode==1){
            System.out.print("Enter cash amount: RM ");
            double cash = in.nextDouble();
            totalFr = cash - this.totalAllPrice;
            System.out.println("Balance : RM "+totalFr);
            System.out.println("\n");
        }
        else if(this.paymentCode==2){
            System.out.print("Enter credit card number(12-digits): ");
            String ccNum = inline.nextLine();
            try{
                System.out.println("...");
                Thread.sleep(1000);
                System.out.println("..");
                Thread.sleep(1000);
                System.out.println(".");
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
            System.out.println("=====================================================");
            
            System.out.println("Transaction Successful!");
            System.out.println("Your credit card "+ccNum+" has been charged with RM "+this.totalAllPrice*0.9);
        }
    }
}