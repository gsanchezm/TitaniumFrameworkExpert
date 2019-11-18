package com.titanium.framework.utils;

import com.titanium.framework.base.DataBaseManagementSystemEnum;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import static com.titanium.framework.config.Constants.QUERIES_DIR;

public class DataBaseUtil {

    private static Connection conn = null;
    private static Properties p = new Properties();
    private static BufferedReader reader = null;
    private static Statement stmt;

    public static Connection getConnection(DataBaseManagementSystemEnum dbms) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        switch (dbms){
            case MYSQL:
                //Load MySql driver class
                Class.forName(getDataBaseProp().getProperty("MySql_Driver")).newInstance();
                //Create a connection
                conn = DriverManager.getConnection(getDataBaseProp().getProperty("MySql_Host"));
                break;
            case MSSQLSERVER:
                //Load Microsoft SQL server driver class
                Class.forName(getDataBaseProp().getProperty("MsSql_Driver")).newInstance();
                //Create a connection
                conn = DriverManager.getConnection(getDataBaseProp().getProperty("MsSql_Host"));
                break;
            case POSTGRES:
                //Load Postgres driver class
                Class.forName(getDataBaseProp().getProperty("Postgres_Driver")).newInstance();
                //Create a connection
                conn = DriverManager.getConnection(getDataBaseProp().getProperty("Postgres_Host"));
                break;
            case MARIADB:
                //Load MariaDB driver class
                Class.forName(getDataBaseProp().getProperty("MariaDB_Driver")).newInstance();
                //Create a connection
                conn = DriverManager.getConnection(getDataBaseProp().getProperty("MariaDB_Host"));
                break;
            case MONGO:
                //Load MySql driver class
                Class.forName(getDataBaseProp().getProperty("MongoDB_Driver")).newInstance();
                conn = DriverManager.getConnection(getDataBaseProp().getProperty("MongoDB_Host"));
                //Create a connection
                break;
            default:
                break;
        }
        return conn;
    }

    public static void closeConnection(){

    }

    public static void executeQuery(String queryFile, Connection conn){
        stmt = null;
        try{
            stmt = conn.createStatement();

            reader = new BufferedReader(new FileReader(QUERIES_DIR+queryFile));
            ResultSet resultSet;

            String line = null;
            // Read Script line by line
            while ((line = reader.readLine()) != null) {
                // Execute the query and store in ResultSet
                resultSet = stmt.executeQuery(line);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static Properties getDataBaseProp() {
        try{
            // Read propertie file
            InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+ "/src/main/resources/database.properties"));
            // Load all properties in order to manipulate them
            p.load(stream);
        }catch(IOException ioe){
            System.err.println(ioe.getMessage());
        }
        return p;
    }
}
