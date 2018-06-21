package database;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager  {

    public static final Logger LOGGER= LoggerFactory.getLogger(DbManager.class);

    private static final String JDBC_DRIVER_HD = "jdbc:h2:./libraryDB";
    private static final String JDBC_DRIVER_SQLITe="jdbc:sqlite:bazadanych.db";

    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static ConnectionSource connectionSource;
    private static DatabaseConnection databaseConnection;

    public static void initDatabase(){
        createConnectionSource();
       // dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource(){
        try {
            connectionSource=new JdbcConnectionSource(JDBC_DRIVER_SQLITe);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource(){
        if(connectionSource==null){
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource(){
        if(connectionSource!=null){
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable(){
        try {
            TableUtils.createTableIfNotExists(connectionSource,Car.class );
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }

    }

    private static void dropTable(){
        try {
            TableUtils.dropTable(connectionSource,Car.class,true );
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static DatabaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public static void setDatabaseConnection(DatabaseConnection databaseConnection) {
        DbManager.databaseConnection = databaseConnection;
    }
}
