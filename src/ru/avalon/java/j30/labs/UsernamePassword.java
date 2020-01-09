package ru.avalon.java.j30.labs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Alexandr Krasilnikov
 */
// создадим класс для чтения properties файла
public class UsernamePassword {

    // создадим строчную переменную, которая принимает путь где находится файл
    // и экземпляр класса Properties
private static final String CONFIG = "resurces/config.properties";
private final Properties config = new Properties();

// конструктор класса будет считывать данные файла через ClassLoader
public UsernamePassword() throws IOException {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    try(InputStream stream = classLoader.getResourceAsStream(CONFIG)) {
        config.load(stream);
    }
}
// создадим метод, который будет возвращать username
    public String getUser() {
    String username = config.getProperty("database.user");
            return username;  
    }
// создадим метод, который будет возвращать password     
    public String getPassword() {
      String password = config.getProperty("database.password");
            return password;
    }
}

