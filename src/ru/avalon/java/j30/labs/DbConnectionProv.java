package ru.avalon.java.j30.labs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Alexandr Krasilnikov
 */
// создадим класс для чтения properties файла

// - вариант через FileInputStream

//public class DbConnectionProv {
//
//    // создадим строковую переменную, которая принимает путь где находится файл
//    // и экземпляр класса Properties
//private static final String CONFIG = "resurces/config.properties";
//private final Properties config;
//private String password;
//private String user;
//// конструктор класса будет считывать данные файла через ClassLoader
//public DbConnectionProv() throws IOException {
//   try( FileInputStream file = new FileInputStream(CONFIG)){
//    config = new Properties();
//   config.load(file);
//   user = config.getProperty("database.user");
//   password = config.getProperty("database.password");
//   }
////   ClassLoader classLoader = ClassLoader.getSystemClassLoader();
////    try(InputStream stream = classLoader.getResourceAsStream(CONFIG)) {
//       // config.load(stream);
//   // }
//}
//// создадим метод, который будет возвращать username
//    public String getUser() {
//            return user;
//    }
//// создадим метод, который будет возвращать password     
//    public String getPassword() {
//            return password;
//    }
//    
//}
// -**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//-**//

public class DbConnectionProv {

private static final String CONFIG = "resurces/config.properties";
private final Properties configs = new Properties();

// конструктор класса будет считывать данные файла через ClassLoader
public DbConnectionProv() throws IOException {
ClassLoader classLoad = getClass().getClassLoader();
    try(InputStream stream = classLoad.getResourceAsStream(CONFIG)){
    configs.load(stream);
   }
}
// создадим метод, который будет возвращать username
private String getUrl()     {
    return configs.getProperty("database.driver") + "://" +
           configs.getProperty("database.host") + ":" +
           configs.getProperty("database.port") + "/" +
           configs.getProperty("database.name");          
}

public Connection getConnection() throws SQLException {
    String username = configs.getProperty("database.user");
    String password = configs.getProperty("database.password");
    String url = getUrl();
    
    return DriverManager.getConnection(url, username, password);
    }   
}

