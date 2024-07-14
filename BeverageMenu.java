public class BeverageMenu extends Menu {
    
    public BeverageMenu(){}
    
    public BeverageMenu(int c, int q){
        super(c,q);
    }
    
    public double calculatePrice(){
        double totalBev=0.0;
        if(super.getMenuCode()==1){
            totalBev=2.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==2){
            totalBev=3.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==3){
            totalBev=3.50*super.getMenuQty();
        }
        else if(super.getMenuCode()==4){
            totalBev=6.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==5){
            totalBev=4.00*super.getMenuQty();
        }
        else{
            totalBev=0.0;
        }
        return totalBev;
    }
}