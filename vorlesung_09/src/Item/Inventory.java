package Item;

import Programm.Trainer;
import Pokemon.Pokemon;
import java.util.List;
import java.util.ArrayList;

public class Inventory 
{
    private Trainer owner; // Dem Inventar einen Trainer zuordnen
    private List<Item> items = new ArrayList<Item>();   //eine neue Liste vom Typ Item erzeugen
    private int maxSize = 100 ; // auf 100 gelegt, da es keine Vorgabe gab

    //Im Konstruktor dem Inventar einen neuen Trainer zuorden
    public Inventory(Trainer trainer)
    {
        this.owner = trainer;
    }

    //Item Anzahl für ALLE Items insgesamt zurückgeben
    public int getItemCount()
    {
        int count = 0;
        for ( Item i : items)
        {
            count += i.getCount();
        }
        return count;
    }

    //Wenn die erlaubte Gesamtzahl nicht überschritten wird, Item adden
    public void add(Item item)
    {
        if ( getItemCount() < maxSize)
        {
            this.items.add(item);
        }
    }

    //Item verwenden, wenn man mehr als 0 hat und es einen owner gibt
    public boolean use(Item i)
    {
        if (i.getCount()>0 && owner!= null)
        {
            i.use();
            checkForZeroCount();
            return true;
        }
        else
        {
            return false;
        }
    }

    //Wie use, nur das man ein Pokemon mitübergeben kann
    public boolean use (Item i, Pokemon p)
    {
        if (i.getCount() > 0 && p != null)
        {
            i.use();
            checkForZeroCount();
            System.out.println(owner.name+" hat "+ i.getName() +" auf "+ p.getName() + " angewandt");
            return true;
        }
        else
        {
            return false;
        }
    }

    //Alle Items eines gewissen Typs werden entfernt
    //Dafür wird ein Item übergeben, der name des Items mit jedem Namen der Items in der Liste verglichen
    public void drop(Item i)
    {
        for (int x = 0 ; x < items.size(); x++)
        {
            if (i.getName().equals( items.get(x).getName() ))
            {
                items.remove(x);
            }
        }
    }

    //Bei der Suche wird der Name als String übergeben, und ein Item zurückgegeben. 
    //Sobald das Item gefunden wurde, wird die Methode per return beendet
    public Item search(String name)
    {
        for (int x = 0 ; x < items.size(); x++)
        {
            if (name.equals( items.get(x).getName() ))
            {
                return items.get(x);
            }
        }
        return null;
    }

    //Item aus der Liste entfernen, wenn der Count 0 ist. 
    public void checkForZeroCount()
    {
        for ( int x = 0 ; x < items.size(); x++)
        {
            if (items.get(x).getCount()==0)
            {
                items.remove(x);
            }
        }
    }

    //Strinbuilder um eine einigermaßen vernünftige Ansicht der Items zu bekommen
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Item i : items)
        {
            builder.append("Item => "); 
            builder.append(i.getName());
            builder.append(" : ");
            builder.append(i.getCount());
            builder.append("\n");
        }
        return builder.toString();
    }

}
