package com.pandasoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by pumba30 on 17.01.2015.
 */
public class ParseBashIm {

    public static final String url = "http://bash.im";
    private String regexp = "<div class=\"quote\">(.*?)</div>";
    private int page = 0;
    private String buff = "";

    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(String regexp) {
        this.regexp = regexp;
    }

    public int getPage() {
        return page;
    }

    //установка номера страницы сайта , которую надо распарсить,
    //поумолчанию парсит главную сайта
    public void setPage(int page) {
        this.page = page;
    }

    //возвращает контент сайта, который парсим
    private String getBuff() {
        String line = "";
        String buff = "";

        try {
            URL hp = new URL(url + "page/" + page);
            BufferedReader reader = new BufferedReader(new InputStreamReader(hp.openStream(), "windows-1251"));

            while ((line = reader.readLine()) != null) {
                buff = buff + line;

            }
            reader.close();
        } catch (MalformedURLException e) {
            System.err.println("Error " + e);

        } catch (IOException e) {
            System.err.println("Error " + e);
        }
        return buff;
    }

    //получаем список цитат с сайта
}
