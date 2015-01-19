package com.pandasoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pumba30 on 19.01.2015.
 */
public class ParseSiteDemo {
    public static void main(String[] args) throws IOException {
        String line;
        ParseBashIm parseBashIm = new ParseBashIm();
        ArrayList<String> list = new ArrayList<String>();

        System.out.println("Введите номер страницы: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        //TODO проверка ввода (должны быть числа)
        while ((line = reader.readLine()) != null) {
            if (line.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            int numberPage = Integer.parseInt(line);

            parseBashIm.setPage(numberPage);
            System.out.println("---------PAGE " + numberPage + " --------------------");
            list = parseBashIm.getQuotes();
            int lengthList = list.size();
            for (int i = 0; i < lengthList; i++) {
                System.out.println("=" + (i + 1) + " ########\n"
                        + list.get(i) + "\n###################\n");
            }
        }

    }
}
