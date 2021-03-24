import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecks {
    public void ex(String str) {
        Pattern p = Pattern.compile("[^*+./^)(_0-9-]");
        Matcher m = p.matcher(str);

        if (m.find()) {
            throw new InputMismatchException("Ввод не допустимого символа...");
        }
        for (int i = 0;i<str.length();i++){
            if (i==0) {
                if (prioritet(str.charAt(i)) != 1) {
                    if (prioritet(str.charAt(i)) != 0) {
                        throw new InputMismatchException("Первый символ не допустим...");
                    }
                }
            }
            if (prioritet(str.charAt(i))>1){
                if (str.charAt(i)=='-'){
                    if (prioritet(str.charAt(i-1))>1){
                        if (prioritet(str.charAt(i+1))!=0){
                            throw new InputMismatchException("Введено подряд арифметические символы...");
                        }
                    }
                }else if (prioritet(str.charAt(i-1))>=1){
                    throw new InputMismatchException("Введено подряд арифметические символы...");
                }
            }
        }
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
