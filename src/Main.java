import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        ParsingStringIntoAnExpression parsingStringIntoAnExpression = new ParsingStringIntoAnExpression();
        MathematicalCalculations mathematicalCalculations = new MathematicalCalculations();
        ValidationChecks validationChecks = new ValidationChecks();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        validationChecks.ex(str);

        System.out.println(parsingStringIntoAnExpression.parsing(str));
        System.out.println(mathematicalCalculations.Calculat(parsingStringIntoAnExpression.parsing(str)));
    }
}
