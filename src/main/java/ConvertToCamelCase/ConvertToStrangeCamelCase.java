package ConvertToCamelCase;

import java.util.Scanner;

public class ConvertToStrangeCamelCase {

    private static char[] convertScannerToCharArray() {
        Scanner scanner = new Scanner(System.in);
        String stringByUser = scanner.nextLine();
        char[] stringToCharArray = stringByUser.toCharArray();
        return stringToCharArray;
    }

    private static String converterVer1() {
        int convertIndex = 0;

        char[] convertToStrangeCamelCase = convertScannerToCharArray();
        StringBuilder strangeCamelCase = new StringBuilder();

        for (int i = 0; i < convertToStrangeCamelCase.length; i++) {
            convertIndex++;
            if (convertIndex % 2 == 1) {
                strangeCamelCase.append(Character.toUpperCase(convertToStrangeCamelCase[i]));
            }
            if (convertIndex % 2 == 0) {
                strangeCamelCase.append(Character.toLowerCase(convertToStrangeCamelCase[i]));
            }
            if (convertToStrangeCamelCase[i] == ' ') {
                strangeCamelCase.append(convertToStrangeCamelCase[i]);
                convertIndex--;
            }
        }
        return String.valueOf(strangeCamelCase);
    }

    private static void normalCamelCase() {
        char[] convertToNormalCamelCase = convertScannerToCharArray();
        StringBuilder normalCamelCase = new StringBuilder();

        for (int i = 0; i < convertToNormalCamelCase.length; i++) {

            char appendChar = 0;

            if (convertToNormalCamelCase[i] == ' ') {
                i++;
                if (convertToNormalCamelCase[i] != ' ') {
                    appendChar = Character.toUpperCase(convertToNormalCamelCase[i]);
                    normalCamelCase.append(appendChar);
                }
            } else if (convertToNormalCamelCase[i] != ' ') {
                appendChar = Character.toLowerCase(convertToNormalCamelCase[i]);
                normalCamelCase.append(appendChar);
            }

        }

        System.out.println(normalCamelCase);
    }

    public static void main(String[] args) {

//        System.out.println(converterVer1());

        normalCamelCase();

    }

}
