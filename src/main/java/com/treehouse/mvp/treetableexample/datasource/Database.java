/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample.datasource;

import com.treehouse.mvp.treetableexample.Item;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author hanus
 */
public class Database {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/knihy";
    
    static final String USER = "postgres";
    static final String PASS = "user";
    private static final Logger LOGGER = Logger.getLogger( Database.class.getName() );
    private int rec;
    
    public Database() {
        rec = 0;
        LOGGER.log(Level.INFO, "Database constructor created");
    }
    
    public void saveDataToDatabase(List<Item> listOfItems) throws SQLException {
        Connection conn = null;
        QueryRunner qr = new QueryRunner();
        DbUtils.loadDriver(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        try {
            
            for (Item item : listOfItems) {
                
                rec += qr.update(conn,
                    "INSERT INTO items(jmeno,cena) VALUES (?,?)",
                    item.getJmeno(),
                    item.getCena()
                );
                
            }
            
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            DbUtils.close(conn);
        }
    }
    
}
