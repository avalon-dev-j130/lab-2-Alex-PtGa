package ru.avalon.java.j30.labs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Alexandr Krasilnikov
 */
// создадим класс для чтения properties файла
public class UsernamePassword {

    // создадим строковую переменную, которая принимает путь где находится файл
    // и экземпляр класса Properties
private static final String CONFIG = "resurces/config.properties";
private final Properties config;
private String password;
private String user;
// конструктор класса будет считывать данные файла через ClassLoader
public UsernamePassword() throws IOException {
   try( FileInputStream file = new FileInputStream(CONFIG)){
    config = new Properties();
   config.load(file);
   user = config.getProperty("database.user");
   password = config.getProperty("database.password");
   }
//   ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//    try(InputStream stream = classLoader.getResourceAsStream(CONFIG)) {
       // config.load(stream);
   // }
}
// создадим метод, который будет возвращать username
    public String getUser() {
            return user;
    }
// создадим метод, который будет возвращать password     
    public String getPassword() {
            return password;
    }
    
}

