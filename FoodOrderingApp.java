import java.util.*;
import java.io.*;
public class FoodOrderingApp{
    //global variable
    public static int count = 0;
    static int size = 0;
    static Customer[] cust = new Customer[999];//creates composite object as array of objects
    static Payment[] pay = new Payment[999];
    
    public static void main(String[] args)throws Exception{
        
        Scanner in = new Scanner(System.in);
        Scanner inline = new Scanner(System.in);
        
        int choice=0, adminChoice;
        int custCount=0;
        double totalSales=0.00;
        double totalPrice=0.00;
        int i = 0;
        
        System.out.println("Welcome to Food Ordering System.");
        do{
           System.out.printf("----------------------------------\n");
           System.out.printf("Choose options to proceed.\n");
           System.out.printf("----------------------------------\n");
           System.out.printf("Choice\t\tMenu\n");
           System.out.printf("----------------------------------\n");
           System.out.printf("1.\t\tUser\n");
           System.out.printf("2.\t\tAdmin\n");
           System.out.printf("3.\t\tExit\n");
           System.out.printf("----------------------------------\n");
        
           System.out.print("Enter Choice: ");
           choice = in.nextInt();
           
           if(choice==1){
               custCount++;//to find total customer
            
                System.out.print("Welcome user! \nEnter your name: ");
                String name = inline.nextLine();
                System.out.print("Enter date(DD/MM Format) of reservation: ");
                String date = inline.nextLine();
                System.out.print("Enter pax: ");
                int pax = in.nextInt();
                   
                cust[i++]= new Customer(name, date, pax);//creates new array
                   
                size = i;//to identify current array size
                
                int option;
                double price=0.0;
                do{
                    System.out.printf("----------------------------------\n");
                    System.out.printf("Choose options to proceed.\n");
                    System.out.printf("----------------------------------\n");
                    System.out.printf("Options\t\tMenu\n");
                    System.out.printf("----------------------------------\n");
                    System.out.printf("1.\t\tAdd Set\n");
                    System.out.printf("2.\t\tAdd AlaCarte\n");
                    System.out.printf("3.\t\tAdd Beverages\n");
                    System.out.printf("4.\t\tExit(Make Payment)\n");
                    System.out.printf("----------------------------------\n");
                    
                    System.out.print("Enter Choice: ");
                    option = in.nextInt();
                    
                    if(option == 1) {
                        price=SetOrder();
                        totalPrice=totalPrice+price;
                    }
                    else if(option == 2) {
                        price=AlaCarteOrder();
                        totalPrice=totalPrice+price;
                    }
                    else if(option == 3) {
                        price=BeveragesOrder();
                        totalPrice=totalPrice+price;
                    }
                    else if(option == 4) {
                        System.out.println("=====================================================");
                        System.out.println("\t\tMAKE PAYMENT");
                        System.out.println("Total: RM"+totalPrice);
                        System.out.println("=====================================================");
                        System.out.println("PAYMENT OPTIONS AVAILABLE ");
                        System.out.println("Option\t Payment");
                        System.out.println("1.\t Cash ");
                        System.out.println("2.\t Credit Card (10% OFF)");
                        System.out.print("Choose your payment method: ");
                        int paymentChoice = in.nextInt();
                                
                        pay[i] = new Payment(paymentChoice, totalPrice);//creates new payment object
                                
                        pay[i].makePayment();//invoke makePayment() function from Payment class
                        
                        totalSales=totalSales+totalPrice;//to find total sales
                            
                        break;
                    }
                        
                }while(option!=4);
                totalPrice=0.0; //reset totalPrice
            }
            else if(choice==2){
                System.out.print("Enter Username: ");
                String username = inline.nextLine();
                System.out.print("Enter Password: ");
                String password = inline.nextLine();
                if(username.equalsIgnoreCase("Ayam bakar")&&password.equalsIgnoreCase("123")){
                    System.out.println("Login as admin successful! Enter code for next actions.");
                    System.out.printf("----------------------------------\n");
                    System.out.printf("Choice\t\tMenu\n");
                    System.out.printf("----------------------------------\n");
                    System.out.printf("1.\t\tView Customers' Information\n");
                    System.out.printf("2.\t\tView Total Sales\n");
                    System.out.printf("----------------------------------\n");
                    System.out.print("Enter code: ");
                    adminChoice = in.nextInt();
                    if(adminChoice==1){
                        viewCustomersInfo(cust);
                    }
                    else if(adminChoice==2){
                        System.out.println("Total sales for the day is : RM"+totalSales);
                        System.out.println("Customers count : "+custCount);                            
                    }
                }
                else{
                    System.out.println("Invalid username or password! Returning to main menu...");
                }
            }
        }while(choice!=3);
        writeFile(cust);
        System.out.println("\nEnd of this program. Thank you for using Food Ordering System!");
    }
    
    public static double SetOrder() {
        Scanner in = new Scanner(System.in);
        double price=0.00;
        SetMenu[] set = new SetMenu[3];
        for(int i=0;i<3;i++){
            System.out.printf("------------------------------------------------------\n");
            System.out.printf("Choose options to proceed.\n");
            System.out.printf("------------------------------------------------------\n");
            System.out.printf("Choice\t\tSet Menu\t\t\tPrice\n");
            System.out.printf("------------------------------------------------------\n");
            System.out.printf("1.\t\tSet Ayam Bakar\t\t\t18.00\n");
            System.out.printf("2.\t\tSet Ayam Buttermilk\t\t15.00\n");
            System.out.printf("3.\t\tSet Ikan Siakap 3 Rasa\t\t25.00\n");
            System.out.printf("4. \t\tBack to Main Menu\n");
            System.out.printf("------------------------------------------------------\n");
            
            System.out.print("Enter Choice: ");
            int setChoice = in.nextInt();
        
            if(setChoice==4){
                break;
            }
        
            System.out.print("Enter Quantity: ");
            int qty = in.nextInt();
                            
            set[i] = new SetMenu(setChoice,qty);
            //System.out.println("----" +set[i].getSetQty());
            price = price + set[i].calculatePrice();
            
            System.out.println("Total Set: RM"+price);
        }
        return price;
    }
    
    public static double AlaCarteOrder() { 
        Scanner in = new Scanner(System.in);
        double price=0.00;
        AlaCarteMenu[] alaCarte = new AlaCarteMenu[5];
        for(int i=0;i<5;i++){
            System.out.printf("---------------------------------------------\n");
            System.out.printf("Choose options to proceed.\n");
            System.out.printf("---------------------------------------------\n");
            System.out.printf("Choice\t\tAla Carte Menu\t\tPrice\n");
            System.out.printf("---------------------------------------------\n");
            System.out.printf("1.\t\tPasemboq\t\t10.00\n");
            System.out.printf("2.\t\tTelur Bistik\t\t 5.00\n");
            System.out.printf("3.\t\tTomyam\t\t\t10.00\n");
            System.out.printf("4.\t\tMaggi Goreng\t\t 8.00\n");
            System.out.printf("5.\t\tBack to Main Menu\n");
            System.out.printf("---------------------------------------------\n");
                            

            System.out.print("Enter Choice: ");
            int alaChoice = in.nextInt();
        
            if(alaChoice==5){
                break;
            }
        
            System.out.print("Enter Quantity: ");
            int qty = in.nextInt();
                            
            
            alaCarte[i] = new AlaCarteMenu(alaChoice,qty);
            //System.out.println("----" +set[i].getSetQty());
            price = price + alaCarte[i].calculatePrice();
            
            System.out.println("Total Ala Carte: RM"+price);
        }
        return price;
    }
    
    public static double BeveragesOrder() { 
        Scanner in = new Scanner(System.in);
        double price=0.00;
        BeverageMenu[] bev = new BeverageMenu[6];
        for(int i=0;i<6;i++){
            System.out.printf("---------------------------------------------\n");
            System.out.printf("Choose options to proceed.\n");
            System.out.printf("---------------------------------------------\n");
            System.out.printf("Choice\t\tBeverage Menu\t\tPrice\n");
            System.out.printf("---------------------------------------------\n");
            System.out.printf("1.\t\tTeh O Ais\t\t2.00\n");
            System.out.printf("2.\t\tMilo Ais\t\t3.00\n");
            System.out.printf("3.\t\tNeslo\t\t\t3.50\n");
            System.out.printf("4.\t\tBubblemilk Tea\t\t6.00\n");
            System.out.printf("5.\t\tJus Buah\t\t4.00\n");
            System.out.printf("6.\t\tBack to Main Menu\n");
            System.out.printf("---------------------------------------------\n");
                        
            System.out.print("Enter Choice: ");
            int bevChoice = in.nextInt();
        
            if(bevChoice==6){
                break;
            }
        
            System.out.print("Enter Quantity: ");
            int qty = in.nextInt();
            
            bev[i] = new BeverageMenu(bevChoice,qty);
            //System.out.println("----" +set[i].getSetQty()); - debugging
            price = price + bev[i].calculatePrice();
            
            System.out.println("Total Beverages: RM"+price);            
        }
        return price;
    }
    
    public static void readFile(Customer[] cust)throws Exception{
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("orderStatus.txt")));
        
            int i = 0;
            
            String data = br.readLine();
            while(data!=null){
                StringTokenizer parse = new StringTokenizer(data,";");
                String name = parse.nextToken();
                String date = parse.nextToken();
                int pax = Integer.parseInt(parse.nextToken());
            
                cust[i++] = new Customer(name, date, pax);
                data = br.readLine();
            }
            count = i;
            br.close();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void writeFile (Customer[] cust)throws Exception{
        try {
            
            PrintWriter pw = new PrintWriter(new FileWriter(new File("orderStatus.txt")));
            for (int x=0; x<size; x++) {
                pw.println(cust[x].toString());
            }
            
            pw.close();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void viewCustomersInfo(Customer[] cust)throws Exception{
        try{
            readFile(cust);
            System.out.println("Display all record(s)...");
            for (int x=0; x<size; x++) {
                System.out.println(cust[x].toString());
                System.out.println();         
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
