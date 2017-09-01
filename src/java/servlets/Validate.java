/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Elliot y Sachiro
 * @version 2.0
 * @date 01-09-2017
 */
public class Validate {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
      try{

	 //drivers con MYSQL
         Class.forName("com.mysql.jdbc.Driver");

 	 //conectando con la Base de Datos
         Connection con=DriverManager.getConnection("jdbc:mysql:/ /localhost/log","root","n0m3l0");
         PreparedStatement ps =con.prepareStatement("select * from register where uss=? and pass=?");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
}
