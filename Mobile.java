// 5. Mobile Phone Information:
// Create a MobilePhone class with attributes like brand, model, price, and storage capacity.
// Implement methods to display phone details, compare prices of two phones, and check if a phone meets specific requirements (e.g., minimum storage).
// Create an array of MobilePhone objects and find the phone with the highest storage capacity.

import java.lang.reflect.Array;
import java.util.ArrayList;

class MobilePhone {
    String brand , model;
    int price , storage;
    MobilePhone(String brand , String model , int price , int storage ){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.storage = storage;
    }
    void details(){
        System.out.println("brand and model " + this.brand + ", " +  this.model);
        System.out.println("storage " + this.storage);
        System.out.println("price " + this.price);
    }
    void compare(MobilePhone p1 , MobilePhone p2){
        if (p1.price < p2.price && p1.storage > p2.storage){
            System.out.println(p1.model + " is better because it have good price and storage");
        }
        else if (p2.price < p1.price && p2.storage > p1.storage){
            System.out.println(p2.model + " is better because it have good price and storage");
        }
        else {
            System.out.println("both are kinda normal ");
        }
    }
    void requirements(MobilePhone p1 , int storage , int price){
        if ( p1.price >= price && p1.storage >= storage ){
           System.out.println("it satisfies ur requirements");
        }
        else if (p1.price < price && p1.storage >= storage){
            System.out.println("price do not satisfies ur requirement");
        }
        else if (p1.storage < storage && p1.price >= price){
            System.out.println("it doesnt satisfies the given storage");
        }
        else if (p1.storage <storage && p1.price < price){
            System.out.println("its doesnt satiesfies anythin like the price and storage ");
        }

    }
}
public class Mobile {
    static MobilePhone highest_storage_Phone;
    public static void main(String[] args) {
        ArrayList<MobilePhone> phones = new ArrayList();
        MobilePhone p1 = new MobilePhone("samsung", "01", 20000, 24);
        MobilePhone p2 = new MobilePhone("iphone", "07", 10000, 12);
        MobilePhone p3 = new MobilePhone("nokia", "100", 1200, 24);
        MobilePhone p4 = new MobilePhone("qmobile", "11", 1100, 56);
        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);


        int storage =0;
        for(MobilePhone p:phones){
            if(p.storage > storage){
                highest_storage_Phone = p;
            }
        }
        System.out.println(highest_storage_Phone.model + " brand " + highest_storage_Phone.brand + " is the highest storage mob");


    }
    
}
