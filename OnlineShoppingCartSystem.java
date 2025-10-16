/*
 * 🧩 Customized Problem: Online Shopping Cart System (Advanced Version)
🎯 Goal

Design an online shopping cart that uses:

Collections (List / Map)

Custom Exception

Any of these patterns: Observer, Decorator, Composite, Factory

🛒 Scenario

You’re designing an online shopping cart for an e-commerce app.
Customers can add or remove products, view total price, and get notified when changes occur.

Your system should:

Use a List<Product> to hold items.

Use Factory Pattern to create different product types (e.g., Electronics, Grocery, Clothing).

Use Decorator Pattern to apply extra features (e.g., Gift wrap, Express Delivery).

Use Observer Pattern to notify when cart is updated (e.g., total changed).

Use Composite Pattern for product bundles (e.g., Combo offers).

Throw ProductNotFoundException if a user tries to remove an item not in the cart.

🧱 Class Breakdown (Concept Plan)
Component	Description	Pattern
Product	Base class for all products	–
ProductFactory	Creates product objects (Electronics, Grocery, etc.)	Factory
ProductDecorator	Adds extra features (gift wrap, express delivery)	Decorator
ProductBundle	Contains multiple products as one	Composite
Cart	Stores product list and notifies observers on updates	Observer
CartObserver	Interface for observers (like TotalDisplay, Logger)	Observer
ProductNotFoundException	Custom exception for invalid removal	–
 */
interface Method{
    void play();
}
class Electronics implements Method{
    public void play(){
        System.out.println("Electronics Products");
    }
}
class Grocery implements Method{
    public void play(){
        System.out.println("Grocery Products");
    }
}
class Clothing implements Method{
    public void play(){
        System.out.println("Clothing products");
    }
}
class Factory{
     public Method method(String type){
        if(type.equalsIgnoreCase("E")){
            return new Electronics();
        }
        else if(type.equalsIgnoreCase("G")){
            return new Grocery();
        }
        else if(type.equalsIgnoreCase("C")){
          return new Clothing();
        }
        else{
            return null;
        }
     }
}
public class OnlineShoppingCartSystem {
    public static void main(String[] args) {
        Factory f = new Factory();
        Method m = f.method("e");
        m.play();
      
    }
}
