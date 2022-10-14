import java.util.Objects;
class IceCream {
    public int bill;
    public String flavour;
    public String scoops;
    public String toppings;
    public int quantity;

    public void setFlavour(String flavour){
        this.flavour=flavour;
        if(Objects.equals(flavour, "Vanilla") || Objects.equals(flavour, "Peppermint")){
            bill+=70;
        }
        if(Objects.equals(flavour, "Chocolate") || Objects.equals(flavour, "Pineapple") || Objects.equals(flavour, "Oreo")){
            bill+=100;
        }
        if(Objects.equals(flavour, "Strawberry") || Objects.equals(flavour, "Almond") || Objects.equals(flavour, "Raspberry")){
            bill+=80;
        }
    }
     public void setScoops(String scoops){
         this.scoops=scoops;
         if(Objects.equals(scoops, "1")){
             bill+=100;
         }
         else if(Objects.equals(scoops, "2")){
             bill+=150;
         }
         else if(Objects.equals(scoops, "3")){
             bill+=200;
         }
         else if(Objects.equals(scoops, "4")){
             bill+=250;
         }

     }
     public void setToppings(String toppings){
         this.toppings=toppings;
         if(Objects.equals(toppings, "Chocolate Chips") || Objects.equals(toppings, "Sprinkles")){
             bill+=60;
         }
         if(Objects.equals(toppings, "Caramel")){
             bill+=50;
         }
         if(Objects.equals(toppings, "Oreos")){
             this.bill+=80;
         }
     }
     public void setQuantity(int quantity){
        this.quantity =quantity;
        bill*=quantity;
     }
     public int generateBill(){
        return this.bill;
     }
}
