package ru.avalon.java.j30.labs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "DEV-OCPJP. Подготовка к сдаче сертификационных экзаменов серии Oracle
 * Certified Professional Java Programmer"
 * <p>
 * Тема: "JDBC - Java Database Connectivity"
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Main {

    /**
     * Точка входа в приложение
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        /* 123458959
         * TODO #01 Подключите к проекту все библиотеки, необходимые для соединения с СУБД.
         */
        try (Connection connection = getConnection()) {
//            ProductCode code = new ProductCode("MO", 'N', "Movies");
//            code.save(connection);
//            printAllCodes(connection);
//
//            code.setCode("MV");
//            code.save(connection);
//            printAllCodes(connection);
        }
        /*
         * TODO #14 Средствами отладчика проверьте корректность работы программы
         */
    }

    /**
     * Выводит в кодсоль все коды товаров
     *
     * @param connection действительное соединение с базой данных
     * @throws SQLException
     */
    private static void printAllCodes(Connection connection) throws SQLException {
        Collection<ProductCode> codes = ProductCode.all(connection);
        for (ProductCode code : codes) {
            System.out.println(code);
        }
    }

    /**
     * Возвращает URL, описывающий месторасположение базы данных
     *
     * @return URL в виде объекта класса {@link String}
     */
    private static String getUrl() {
        /*
         * TODO #02 Реализуйте метод getUrl
         */
        String url = "jdbc:derby://localhost:1527/Lab#2";  
        System.out.println("есть соединение...");
        return url;
        // jdbc:derby://localhost:1527/Lab#2 [Sample on SAMPLE]
      //  final String CONFIGS = "resurces/config.properties";
      //  return CONFIGS;
    }

    /**
     * Возвращает параметры соединения
     *
     * @return Объект класса {@link Properties}, содержащий параметры user и
     * password
     */
  
    private static Properties getProperties() throws IOException {
/*
         * TODO #03 Реализуйте метод getProperties
         */    
        
// создадим экземпляр класса UsernamePassword и вызовем его методы 
      // через строковые параметры user и password
//       UsernamePassword db = new UsernamePassword();
//       String user = db.getUser();      // будет строка юзера
//       String password = db.getPassword();  // будет строка пароля
 // создадим экземпляр класса  Properties
       Properties configs = new Properties();
 
// через экземпляр класса вызовем метод, который получит параметры user и password
//       configs.getProperty(user, password);
// возвратим созданный экземпляр соглассно задания
       return configs;             
}
/**
 * Возвращает соединение с базой данных Sample
 *
 * @return объект типа {@link Connection}
 * @throws SQLException
 */
private static Connection getConnection() throws SQLException, IOException {
        /*
         * TODO #04 Реализуйте метод getConnection
         */
        String url = getUrl();
//        Properties usnamePas = getProperties();
       String user = "sample";
       String password = "sample";
       
       return DriverManager.getConnection(url, user, password);
    }    
}
