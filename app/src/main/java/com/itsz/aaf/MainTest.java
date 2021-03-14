package com.itsz.aaf;

import android.provider.Settings;
import android.view.View;

/**
 * @author itsZ
 */
public class MainTest {
    public static void main(String[] args) {

        String property = System.getProperty("http.agent");
        System.out.println("--"+property);
//        System.out.println(maximum69Number(696));
//        System.out.println(maximum69Number(9696));
//        System.out.println(maximum69Number(9666));
    }

    private static int maximum69Number(int num) {

        String valueOf = String.valueOf(num);
        String first = valueOf.replaceFirst("6", "9");
        return Integer.parseInt(first);
    }
}
