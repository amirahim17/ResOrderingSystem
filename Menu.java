abstract class Menu{
    //attributes
    protected int menuCode;
    protected int menuQty;
    
    //default constructor
    public Menu(){}
    
    //normal constructor
    public Menu(int c, int q){
        this.menuCode=c;
        this.menuQty=q;

    }
    
    //mutator
    public void setMenuCode(int c){this.menuCode=c;}
    public void setMenuQty(int q){this.menuQty=q;}    
    
    //accessor
    public int getMenuCode(){return this.menuCode;}
    public int getMenuQty(){return this.menuQty;}
    
    public double calculatePrice(){
        double total = 0.0;
        return total;
    }
}