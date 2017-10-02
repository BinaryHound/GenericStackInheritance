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
        //Simple test of the new method.
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("a");
        list2.add("b");
        list2.add("c");
        System.out.println(removeDuplicates(list2));
        
        //Testing of matrix max.
        Integer[][] ints = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println(TestClass.<Integer>Max(ints));
        
        //Testing of the binarySearch.
        Integer[] doubles = {1, 2, 3, 4, 7, 8, 9};
        System.out.println(binarySearch(doubles, 8));
        System.out.println(binarySearch(doubles, 5));
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
    
    //Performs a linear search for the key. Using Generics.
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key){
        for(int i = 0; i < list.length - 1; i++){
            if(list[i].compareTo(key) == 0){
                return i;
            }
        }
        return -1;
    }
    
    //Static method to return the maximum number using the comparable interface.
    /*
    If the compareTo method returns something < 0 then it means the number
    is less than the number compared.
      */
    public static <E extends Comparable<E>> E max(E[] list){
        if(list.length == 1){
            return list[0];
        }else{
            E maxNum = list[0];
            for(int i = 1; i < list.length - 1; i++){
                if(maxNum.compareTo(list[i]) <= 0){
                    maxNum = list[i];
                }
            }
            return maxNum;
        }
    }
    
    //Takes in a matrix, and finds the biggest value in the said matrix.
    //Extends the Comparable interface for help with generic comparisons, or
    //natural ordering of values.
    public static <E extends Comparable<E>> E Max(E[][] matrix){
        if(matrix.length == 1 && matrix[0].length == 1){
            return matrix[0][0];
        }else {
            int max1 = 0, max2 = 0;
            for(int outer = 0; outer < matrix.length; outer++){
                for(int inner = 0; inner < matrix[outer].length; inner++){
                    if(matrix[max1][max2].compareTo(matrix[outer][inner]) <= 0){
                        max1 = outer;
                        max2 = inner;
                    }
                }
            }
            return matrix[max1][max2];
        }
    }
    
    //Performs a binary search of the list. Needs an ordered list.
    //Returns the index position of the number looked for.
    //Returns a negative index position of where the value SHOULD be if not found.
    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
        int low, mid, high;
        if(list.length == 1 && list[0] == key){
            return 0;
        }else {
            low = 0;
            high = list.length - 1;
            while(low < high){
                mid = (low + high) / 2;
                if(list[mid].compareTo(key) > 0){
                    high = mid - 1;
                } else if(list[mid].compareTo(key) == 0){
                    return mid;
                } else if(list[mid].compareTo(key) < 0){
                    low = mid + 1;
                }
            }
        }
        return -low - 1;
    }
}
