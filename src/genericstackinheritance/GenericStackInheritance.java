package genericstackinheritance;
import java.util.ArrayList;
/**
 *
 * @author lennardneuwirth
 * @param <E>
 */
//    Creates a Stack using Inheritance of the ArrayList Generic. 

public class GenericStackInheritance<E> extends ArrayList<E> {

    //Instantiate a new arrayList.
    ArrayList<E> list = new ArrayList<>();
    
    //Take an object as a parameter and add it to the list.
    public void Push(E o){
        list.add(o);
    }
    
    //Look at the first item of the list.
    public E Peek(){
        return list.get(list.size() - 1);
    }
    
    //Return the first item of the list, and remove that item from the list.
    public E Pop(){
        E o = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return o;
    }
    
    //Get the size of the list.
    public int getSize(){
        return list.size();
    }
    
    //Override the ArrayList is empty to call this version.
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    //Override the toString call to make it more accurate for this list.
    @Override
    public String toString(){
        return "Stack: " + list.toString();
    }
}
