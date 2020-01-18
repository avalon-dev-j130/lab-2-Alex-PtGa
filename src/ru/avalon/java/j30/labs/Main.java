package ru.avalon.java.j30.labs;

import java.io.FileInputStream;
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
   private static final String CONFIG = "src\\resources\\config.properties";
   
    public static void main(String[] args) throws SQLException, IOException {
        /* 
         * TODO #01 Подключите к проекту все библиотеки, необходимые для соединения с СУБД.
         */
        try (Connection connection = getConnection()) {
            System.out.println("есть соединение...");
            ProductCode code = new ProductCode("MO", 'N', "Movies");
            code.save(connection);
            printAllCodes(connection);

            code.setCode("MV");
            code.save(connection);
            printAllCodes(connection);
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
        String url = "jdbc:derby://localhost:1527/JavaDb_2";
        System.out.println("есть url...");
        return url;
        
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
        Properties configs = new Properties();
        try (FileInputStream file = new FileInputStream(CONFIG)) {

            configs.load(file);
        }
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
        Properties usnamePas = getProperties();

        String user = usnamePas.getProperty("database.user").trim();          
        String password = usnamePas.getProperty("database.password").trim();   // от лишних пробелов

        return DriverManager.getConnection(url, user, password);
    }
}