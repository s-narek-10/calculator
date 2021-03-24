import java.util.ArrayList;
import java.util.List;

public class ParsingStringIntoAnExpression {
    public List<String> parsing(String str){
        List<String> stack = new ArrayList<>();
        String chara = "";
        for (int i = 0; i<str.length(); i++){
            if(prioritet(str.charAt(i))==0){
                chara = chara + Character.toString(str.charAt(i));
            }else if (str.charAt(i)=='-'){
                if (i==0){
                    chara = chara + Character.toString(str.charAt(i));
                }else  if (prioritet(str.charAt(i-1))!=0&&prioritet(str.charAt(i-1))!=-1&&prioritet(str.charAt(i+1))==0){
                    chara = chara + Character.toString(str.charAt(i));
                }else {
                    if (chara != "") {
                        stack.add(chara);
                        chara = "";
                    }
                    stack.add(Character.toString(str.charAt(i)));
                }
            }else {
                if (chara != "") {
                    stack.add(chara);
                    chara = "";
                }
                stack.add(Character.toString(str.charAt(i)));
            }
        }
        if (chara!=""){
            stack.add(chara);
        }
        return stack;
    }
    public static int prioritet(char i){
        if(i == '*') return 3;
        if(i == '/') return 3;
        if(i == '+') return 2;
        if(i == '-') return 2;
        if(i == '(') return 1;
        if(i == ')') return -1;
        if(i == '.') return 0;
        return 0;
    }
}

