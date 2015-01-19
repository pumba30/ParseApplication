package com.pandasoft;

import java.util.ArrayList;

/**
 * Created by pumba30 on 19.01.2015.
 */
public class ParseSiteDemo {
    public static void main(String[] args) {

        ParseBashIm parseBashIm = new ParseBashIm();
        ArrayList<String> list = new ArrayList<String>();

        parseBashIm.setPage(1);
        System.out.println("---------PAGE 1--------------------");
        list = parseBashIm.getQuotes();
        int lengthList = list.size();
        for (int i = 0; i < lengthList; i++) {
            System.out.println("##" + (i + 1) + " ########\n"
                    + list.get(i) + "\n###################\n");
        }

        System.out.println("---------PAGE 2--------------------");
        parseBashIm.setPage(2);
        list = parseBashIm.getQuotes();

        lengthList = list.size();

        for (int i = 0; i < lengthList; i++) {
            System.out.println("######## " + "Цитата № " + (i + 1)
                    + " ########\n" + list.get(i) + "\n###################\n");
        }
    }
}
