package com.pandasoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pumba30 on 17.01.2015.
 */
public class ParseBashIm {

    public static final String url = "http://bash.im/";
    // public static final String url = "http://bashorg.org/";
    //private String regexp = "<div class=\"quote\">(.*?)</div>";

    private String regexp = "<div class=\"text\">(.*?)</div>";
    private int page; //по умолчанию парсим главную страничку
    private String buff;

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
            //структура ссылки на страницы сайта выглядит так [ http://bash.im/index/2/ ]
            URL urlSite = new URL(url + "index/" + page);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlSite.openStream(), "windows-1251"));

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
    ArrayList<String> getQuotes() {
        buff = getBuff();
        ArrayList<String> quotes = new ArrayList<String>();
        if (buff.length() > 0) {
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(buff);
            String res = "";
            while (matcher.find()) {
                res = matcher.group(1);
                res = res.replace("<br />", "/n");
                res = res.replaceAll("&quot;", "");
                quotes.add(res);
            }
        }
        return quotes;
    }
}
