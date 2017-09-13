package dataBase;

import java.sql.*;

public class DB {
     Connection conn = null;
     Statement stmt = null;
  
     private void Conn() 
     {
       try {
         
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url ="jdbc:mysql://localhost:3308/paintdb?user=root&password=";
          conn = DriverManager.getConnection(url); 
        stmt = conn.createStatement();

         } catch (InstantiationException | IllegalAccessException | ClassNotFoundException  | SQLException e) 
         {
               e.printStackTrace();
         }



     }
     
     public boolean doExcute(String sql) throws SQLException
     {
       int r=0;
      try {
        Conn();
          r =  stmt.executeUpdate(sql);
      } catch (SQLException e) {
        closeDB();
        e.printStackTrace();
      }

     if(r==1)
     {
       return true;
     }
     else
     {
       return false;
     }

    
     }
     
     public ResultSet doQuery(String sql) throws SQLException
     {
       ResultSet rs=null;
      try {
        Conn();
        rs =  stmt.executeQuery(sql);
      } catch (SQLException e) {
        closeDB();
        e.printStackTrace();
      }

    return rs;
    
     }
     
     
     private void closeDB() 
     {
       try
       {
      stmt.close();
      conn.close();
       }catch(SQLException e)
       {
         System.out.println(e);
       }
     }
}
