package ConvertToCamelCase;

import javafx.beans.binding.StringBinding;

import java.util.Scanner;

public class ConvertToStrangeCamelCase {


    private static String converterVer1(){
        int convertIndex = 0;

        Scanner scanner = new Scanner(System.in);
        String stringByUser = scanner.nextLine();
        char[] stringToCharArray = stringByUser.toCharArray();
        StringBuilder newCamelCase = new StringBuilder();

        for (int i = 0; i < stringToCharArray.length; i++) {
            convertIndex++;
            if (convertIndex % 2 == 1) {
                newCamelCase.append(Character.toUpperCase(stringToCharArray[i]));
            }
            if (convertIndex % 2 == 0) {
                newCamelCase.append(Character.toLowerCase(stringToCharArray[i]));
            }
            if (stringToCharArray[i] == ' ') {
                newCamelCase.append(stringToCharArray[i]);
                convertIndex--;
            }
        }
        return String.valueOf(newCamelCase);
    }

    public static void main(String[] args) {

        System.out.println(converterVer1());

    }

}
