package spel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class sp {


    public static void main(String[] args) throws IOException {
        //方式一
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\ideabymyself\\刷题\\src\\main\\resources\\spel.properties"));
        System.out.println(properties.getProperty("a"));

        //方式二
        InputStream inputStream = sp.class.getClassLoader().getResourceAsStream("spel.properties");
        properties.load(inputStream);
        System.out.println(properties.getProperty("a"));

        System.out.println();

    }






}
