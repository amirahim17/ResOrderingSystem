public class Customer{
    //attributes
    private String name;
    private String date;
    private int pax;
    
    //default constructor
    public Customer(){}
    
    //normal constructor
    public Customer(String n, String d, int p){
        this.name=n;
        this.date=d;
        this.pax=p;
    }
    
    //mutator or setter for each
    public void setName(String n){this.name=n;}
    public void setDate(String d){this.date=d;}
    public void setPax(int p){this.pax=p;}
    
    //mutator for all
    public void setCustomer(String n, String d, int p){
        this.name=n;
        this.date=d;
        this.pax=p;
    }
    
    
    
    //accessor or retriever
    public String getName(){return this.name;}
    public String getDate(){return this.date;}
    public int getPax(){return this.pax;}
    
    //display all
    public String toString(){
        return "Name   :"+this.name+"\n"+
               "Date   :"+this.date+"\n"+
               "Pax    :"+this.pax+"\n";
    }
}