package genericstackinheritance;
import java.util.ArrayList;
/**
 *
 * @author lennardneuwirth
 */
public class TestClass {
    
    public static void main(String[] args){
        
        //simple data holders.
        char[] chars;
        String s = "";
        
        //Instantiating a new instance of the ArrayList stack.
        GenericStackInheritance<String> genString = new GenericStackInheritance<>();
        
        //Adding some strings to the list.
        genString.Push("abc");
        genString.Push("def");
        genString.Push("ghi");
        genString.Push("jkl");
        genString.Push("mno");
        
        //Checking to see if the stack works.
        System.out.println(genString.getSize());
        System.out.println(genString.toString());
        
        //Takes the stack and makes all of the strings return backwards for fun.
        for(int i = 0; genString.getSize() > 0; i++){
            s = "";
            chars = genString.Pop().toCharArray();
            for(int j = chars.length - 1; j >= 0; j--){
                s += "" + chars[j];
            }
            System.out.println(s);
        }
        
    }
    
    //Takes in an ArrayList and returns a non-duplicate list back.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> nonDupList = new ArrayList<>();
        for(E item : list){
            if(!(nonDupList.contains(item))){
                nonDupList.add(item);
            }
        }
        return nonDupList;
    }
    
}
