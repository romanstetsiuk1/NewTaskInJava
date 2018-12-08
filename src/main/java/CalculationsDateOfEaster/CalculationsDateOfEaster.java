package CalculationsDateOfEaster;

import java.util.Scanner;

public class CalculationsDateOfEaster {

    public static void main(String[] args) {
        int a, b, c, d, e, f, g, h, i, k, l, m, p;
        int mounth, day;
        String mounthOfEaster;

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        a = year % 19;
        b = Math.round(year / 100);
        c = year % 100;
        d = Math.round(b / 4);
        e = b % 4;
        f = Math.round((b + 8) / 25);
        g = Math.round((b - f + 1) / 3);
        h = (19 * a + b - d - g + 15) % 30;
        i = Math.round(c / 4);
        k = c % 4;
        l = (32 + 2 * e + 2 * i - h - k) % 7;
        m = Math.round(a + 11 * h + 22 * l) / 451;
        p = (h + l - 7 * m + 114) % 31;

        day = p + 1;
        mounth = (h + l - 7 * m + 114) / 31;

        if (mounth == 4) {
            mounthOfEaster = "apil";
        } else {
            mounthOfEaster = "march";
        }

        System.out.println("Data of Easer in " + year + " is: " + day + " " + mounthOfEaster + " " + year);

    }

}
