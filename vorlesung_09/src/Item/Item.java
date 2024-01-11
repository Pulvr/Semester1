package Item;

import Programm.Trainer;

public class Item {

    public String name;
    protected int count;
    protected Trainer owner;

    protected Item(String name, int count, Trainer owner){
        this.name = name;
        this.count = count;
        this.owner = owner;
    }


    public boolean use(){
        
        if (count >= 1){
            count --;
            System.out.println(owner.name+" benutzt "+ this.name);
            return true;
        }else{
            return false;
        }
    }

    public int getCount(){
        return this.count;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Item: "+this.name+" Anzahl: "+this.count;
    }
}
