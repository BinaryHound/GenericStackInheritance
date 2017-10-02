package genericstackinheritance;

/**
 *
 * @author lennardneuwirth
 */
public class TestClass {
    
    public static void main(String[] args){
        char[] chars;
        String s = "";
        GenericStackInheritance<String> genString = new GenericStackInheritance<>();
        
        genString.Push("abc");
        genString.Push("def");
        genString.Push("ghi");
        genString.Push("jkl");
        genString.Push("mno");
        System.out.println(genString.getSize());
        System.out.println(genString.toString());
        for(int i = 0; genString.getSize() > 0; i++){
            s = "";
            chars = genString.Pop().toCharArray();
            for(int j = chars.length - 1; j >= 0; j--){
                s += "" + chars[j];
            }
            System.out.println(s);
        }
        
    }
    
}
