package Guava.GuavaTest.src.othertest;

import com.google.common.base.Strings;

/**
 * Create on 2017/9/5
 */
public class StringsTest {
    public static void main(String[] args) {
        String is = null;
        String str = "whelweoowo \n ewiohewe \nwew    \n   \n\t\ndsdsdstoor@12#:";
        if(Strings.isNullOrEmpty(is)){
            System.out.println(" Strings: is is Empty");
        }else{
            System.out.println("Strings: is is not Empty");
        }
        int i = 0;
        while(i<3) {
            if (i == 1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
            i++;
        }
        /*
        if(is.isEmpty()){
            System.out.println("String: is is Empty");
        }else{
            System.out.println("String: is is not Empty");
        }
        */
        if(str.contains("toor")){
            System.out.println("-------------------------");
            System.out.println(str);
        }else{

        }
    }
}
