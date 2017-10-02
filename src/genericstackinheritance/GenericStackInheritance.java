package genericstackinheritance;
import java.util.ArrayList;
/**
 *
 * @author lennardneuwirth
 * @param <E>
 */
//    Creates a Stack using Inheritance of the ArrayList Generic. 

public class GenericStackInheritance<E> extends ArrayList<E> {

    ArrayList<E> list = new ArrayList<>();
    
    public void Push(E o){
        list.add(o);
    }
    public E Peek(){
        return list.get(list.size() - 1);
    }
    public E Pop(){
        E o = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return o;
    }
    public int getSize(){
        return list.size();
    }
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    @Override
    public String toString(){
        return "Stack: " + list.toString();
    }
}
