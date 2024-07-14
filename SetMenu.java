public class SetMenu extends Menu {
    
    public SetMenu(){}
    
    public SetMenu(int c, int q){
        super(c,q);
    }
    
    public double calculatePrice(){
        double totalSet=0.0;
        if(super.getMenuCode()==1){
            totalSet=18.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==2){
            totalSet=15.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==3){
            totalSet=25.00*super.getMenuQty();
        }
        else{
            totalSet=0;
        }
        return totalSet;
    }
}