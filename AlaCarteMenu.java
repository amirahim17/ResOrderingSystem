public class AlaCarteMenu extends Menu{
    
    public AlaCarteMenu(){}
    
    public AlaCarteMenu(int c, int q){
        super(c,q);
    }
    
    public double calculatePrice(){
        double totalAla=0.0;
        if(super.getMenuCode()==1){
            totalAla=10.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==2){
            totalAla=5.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==3){
            totalAla=10.00*super.getMenuQty();
        }
        else if(super.getMenuCode()==4){
            totalAla=8.00*super.getMenuQty();
        }
        else{
            totalAla=0.0;
        }
        return totalAla;
    }
}