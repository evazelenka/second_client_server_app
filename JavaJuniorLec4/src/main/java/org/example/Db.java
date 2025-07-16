package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void con(){
//        Connector connector = new Connector();
//        Session session = connector.getSession();
//        Magic magic =new Magic("Волшебнаястрела",10,0,0);
//        session.beginTransaction();
//        session.save(magic);
//        magic =new Magic("Молния",25,0,0);
//        session.save(magic);
//        magic =new Magic("Каменная кожа",0,0,6);
//        session.save(magic);
//        magic =new Magic("Жажда крови",0,6,0);
//        session.save(magic);
//        magic =new Magic("Жажда крови",0,6,0);
//        session.save(magic);
//        magic =new Magic("Проклятие", 0,-3, 0);
//        session.save(magic);
//        magic =new Magic("Лечение",-30, 0, 0);
//        session.save(magic);
//        session.getTransaction().commit();
//        session.close();

        Connector connector = new Connector();
        try (Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            List<Magic> magics = session.createQuery("FROM Magic", Magic.class).getResultList();
            magics.forEach(m ->{
                session.delete(m);
            });
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void con(String query) throws SQLException {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
            Statement statement = con.createStatement();
           statement.execute("delete from test.magic " +
                   "where id=1;");
//            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`;");
//            while (set.next()){
//                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
//            }
        }
    }
}
