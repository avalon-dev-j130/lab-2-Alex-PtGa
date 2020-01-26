package ru.avalon.java.j30.labs;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * Класс описывает представление о коде товара и отражает соответствующую
 * таблицу базы данных Sample (таблица PRODUCT_CODE).
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class ProductCode {

    /**
     * Код товара
     */
    private String code;
    /**
     * Кода скидки
     */
    private char discountCode;
    /**
     * Описание
     */
    private String description;

    /**
     * Основной конструктор типа {@link ProductCode}
     *
     * @param code код товара
     * @param discountCode код скидки
     * @param description описание
     */
    public ProductCode(String code, char discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }

    /**
     * Инициализирует объект значениями из переданного {@link ResultSet}
     *
     * @param set {@link ResultSet}, полученный в результате запроса,
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample.
     */
    private ProductCode(ResultSet set) {
        /*
         * TODO #05 реализуйте конструктор класса ProductCode
         */
        try {
            code = set.getString("PROD_CODE");
            discountCode = set.getString("DISCOUNT_CODE").charAt(0);
            description = set.getString("DESCRIPTION");
        } catch (SQLException ex) {
            System.out.println("Ошибка создания ProductCode из Resultset");
        }
    }

    /**
     * Возвращает код товара
     *
     * @return Объект типа {@link String}
     */
    public String getCode() {
        return code;
    }

    /**
     * Устанавливает код товара
     *
     * @param code код товара
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Возвращает код скидки
     *
     * @return Объект типа {@link String}
     */
    public char getDiscountCode() {
        return discountCode;
    }

    /**
     * Устанавливает код скидки
     *
     * @param discountCode код скидки
     */
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }

    /**
     * Возвращает описание
     *
     * @return Объект типа {@link String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Устанавливает описание
     *
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Хеш-функция типа {@link ProductCode}.
     *
     * @return Значение хеш-кода объекта типа {@link ProductCode}
     */
    @Override
    public int hashCode() {
        /*
         * TODO #06 Реализуйте метод hashCode
         */
        return Objects.hash(code, discountCode, description);
    }

    @Override
    public boolean equals(Object obj) {
        /*
         * TODO #07 Реализуйте метод equals
         */
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProductCode) {
            ProductCode other = (ProductCode) obj;
            return (this.code.equals(other.code))
                    && (this.discountCode == other.discountCode)
                    && (this.description.equals(other.description));
        }
        return false;
    }

    /**
     * Возвращает строковое представление кода товара.
     *
     * @return Объект типа {@link String}
     */
    @Override
    public String toString() {
        /*
         * TODO #08 Реализуйте метод toString
         */
        return "Product_Code{" + "code=" + code + ", discountCode="
                + discountCode + ", description=" + description + "}";
    }

    /**
     * Возвращает запрос на выбор всех записей из таблицы PRODUCT_CODE базы
     * данных Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getSelectQuery(Connection connection) throws SQLException {
        /*
         * TODO #09 Реализуйте метод getSelectQuery
         */
        String query = "SELECT * FROM PRODUCT_CODE";    // формирование запроса
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("Выбраны все коды базы данных...");
        return pst;
    }

    /**
     * Возвращает запрос на добавление записи в таблицу PRODUCT_CODE базы данных
     * Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getInsertQuery(Connection connection) throws SQLException {
        /*
         * TODO #10 Реализуйте метод getInsertQuery
         */
        String query = "insert into PRODUCT_CODE(PROD_CODE, DISCOUNT_CODE, DESCRIPTION) "
                + "values(?, ?, ?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("Добавлены все коды базы данных...");
        return pst;
    }

    /**
     * Возвращает запрос на обновление значений записи в таблице PRODUCT_CODE
     * базы данных Sample
     *
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getUpdateQuery(Connection connection) throws SQLException {
        /*
         * TODO #11 Реализуйте метод getUpdateQuery
         */
        String query = "UPDATE PRODUCT_CODE SET DISCOUNT_CODE = ?, DESCRIPTION = ? WHERE  PROD_CODE = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("Все значения обновлены....");
        return pst;
//        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Преобразует {@link ResultSet} в коллекцию объектов типа
     * {@link ProductCode}
     *
     * @param set {@link ResultSet}, полученный в результате запроса,
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample
     * @return Коллекция объектов типа {@link ProductCode}
     * @throws SQLException
     */
    public static Collection<ProductCode> convert(ResultSet set) throws SQLException {
        /*
         * TODO #12 Реализуйте метод convert
         */

        Collection<ProductCode> collection = new LinkedList<>();
       
        while (set.next()) {
            collection.add(new ProductCode(set));
        }
        return collection;
//       throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Сохраняет текущий объект в базе данных.
     * <p>
     * Если запись ещё не существует, то выполняется запрос типа INSERT.
     * <p>
     * Если запись уже существует в базе данных, то выполняется запрос типа
     * UPDATE.
     *
     * @param connection действительное соединение с базой данных
     */
//-----------------------------------------------------------------------------------------

    public void save(Connection connection) throws SQLException {
        /*
         * TODO #13 Реализуйте метод save
         */
        System.out.println("Соединение в save: " + connection);
        Statement st = null;
        try {
            st = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("Ошибка создания st " + ex.getMessage());
        }
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            rs = st.executeQuery("SELECT * FROM PRODUCT_CODE WHERE PROD_CODE =  'code'");

        } catch (SQLException ex) {
            //           Logger.getLogger(ProductCode.class.getName()).log(Level.SEVERE, null, ex);
 
            System.out.println("Ошибка ...что то в " + ex.getMessage());
        }
        try {
            st.close();
            if (rs.next()) {
                // есть такой продукт - делаем UPDATE
                pst = getUpdateQuery(connection);
                pst.setString(1, code);

                pst.setString(2, String.valueOf(discountCode)); // .setDouble(2, discountCode);
                pst.setString(3, description);
            } else {
                // нет такого в базе - делаем INSERT
                pst = getInsertQuery(connection);
                pst.setString(1, code);
                pst.setString(2, String.valueOf(discountCode));
                pst.setString(3, description);
            }
            pst.executeUpdate();
            pst.close();
 //           st.close();
        } catch (SQLException ex) {
            //           Logger.getLogger(ProductCode.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ошибка в ...."+ ex.getMessage());
        }
    }
//--------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------

    /**
     * Возвращает все записи таблицы PRODUCT_CODE в виде коллекции объектов типа
     * {@link ProductCode}
     *
     * @param connection действительное соединение с базой данных
     * @return коллекция объектов типа {@link ProductCode}
     * @throws SQLException
     */
    public static Collection<ProductCode> all(Connection connection) throws SQLException {

        PreparedStatement statement = getSelectQuery(connection);
        {
            ResultSet result = statement.executeQuery();
            {
                return convert(result);
            }
        }
    }
}
