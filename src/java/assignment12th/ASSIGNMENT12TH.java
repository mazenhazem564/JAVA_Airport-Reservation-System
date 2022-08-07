/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment12th;

import PK1.Loginjava;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mazen
 */
public class ASSIGNMENT12TH {
Connection connection;
    public ASSIGNMENT12TH(){
    
    try {
        
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
         connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly","fly","fly1");
         
         Statement stmt = connection.createStatement();
         
        
         stmt.executeUpdate("create table users(id integer primary key  generated always as identity,name varchar(30),email varchar(30),password varchar(30),no_tickets INTEGER)");//,no_tickets INTEGER
         //date DATE,time TIME
         stmt.executeUpdate("create table flight(flight_id integer primary key  generated always as identity,depparture varchar(30),arrival varchar(30),date varchar(30),time varchar(30),no_seats INTEGER)");
         //stmt.executeUpdate("create table users(id char(9), name varchar(30), password varchar(30), email varchar(30), no_tickets number,primary key(id))");
         //stmt.executeUpdate("create table users(flight_id number, departure varchar(30), arrival varchar(30),date varchar(10), time (), no_seat number,primary key(flight_id))");
         
    } 
    
    catch (ClassNotFoundException ex) {
    
        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
    
        
    } catch (SQLException ex) {
       
        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
   
    }
    
    finally
    {
    
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    }
    
    public void insertusersdata(String name ,String email,String password ,int no_tickets)
    
    {
    
        try {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly","fly","fly1");
        PreparedStatement pstmt=connection.prepareStatement("insert into users(name, email, password, no_tickets)  values(?,?,?,?)"); //tickets ? removed
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.setInt(4, no_tickets);
        pstmt.executeUpdate();
        }
    
    catch (SQLException ex) {
        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
    }
        finally
    {
    
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
        public void insertflightdata(String depart ,String arrive,String date ,String time,int availableseats)
    
    {
    //stmt.executeUpdate("create table flight(flight_id char(9),depparture varchar(30),arrival varchar(30),date DATE,time TIME,primary key(flight_id))");
        try {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly","fly","fly1");
        PreparedStatement pstmt2=connection.prepareStatement("insert into flight (depparture,arrival,date,time,no_seats)  values(?,?,?,?,?)");
        pstmt2.setString(1, depart);
        pstmt2.setString(2, arrive);
       pstmt2.setString(3, date);
       pstmt2.setString(4, time);
       pstmt2.setInt(5, availableseats);
        pstmt2.executeUpdate();
        }
    
    catch (SQLException ex) {
        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
    }
        finally
    {
    
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
      /*  public void printdata()
        {
        
                    try {
        connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Fly","fly","fly1");
     
                    //select * from category(all ComputerSCience) whose prices > 300.00$
            
            //therefore use querey
            
            Statement stmt = connection.createStatement();
            //ResultSet result =stmt.executeQuery("select * from Books");
            ResultSet result =stmt.executeQuery("select category,price from Books");
            
           // while(result.next()){ System.out.println("category"+"="+"Computer Science");    System.out.println("price"+">"+"300$");}
               
               
                
            

         
           while(result.next())
            {
                if(result.getString(1).equals("Computer Science")){
                System.out.println(result.getString(1));
                System.out.println(result.getString(2));
                }
            
}
        }
    
    catch (SQLException ex) {
        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
    }
        finally
    {
    
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        }
    */
        
        	public int storeUser(Loginjava s){
		int i=0;
		try {
			connection = DriverManager.getConnection("jdbc:derby:db/db;create=true");
			System.out.println("Connected");

                        //use PreparedStatement because we want to inject variables in the
                        //middle of the sql
                        //put ? in place of each variable
                        PreparedStatement pstmt = 
                                connection.prepareStatement("insert into Loginjava values (?,?,?,?)");
                        
                        //set first ? to user's email, 2nd ? to use's first name, ...etc.
                        pstmt.setString(1, s.getUsername());
                        pstmt.setString(2, s.getFname());
                        pstmt.setString(3, s.getLname());
                        pstmt.setString(4, s.getPassword());
                        
                        //executeUpdate returns the number of rows that were updated from the sql
                        //if the user was successfuly inserted then i = 1
                        //if an error occured i = -1
			i = pstmt.executeUpdate();
                        
                        
		} catch (SQLException e) {
                    e.printStackTrace();
		}
                finally{
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
		return i;
		
	}
        
   
        public boolean loginuser(Loginjava s)
{
        try {
            connection=DriverManager.getConnection("jdbc:derby://localhost:1527/Fly","fly","fly1");
          System.out.println("Connected to Database for insert");
          //select * from loginjava where email= '' and password = ''
          PreparedStatement pstmt=connection.prepareStatement("select * from loginjava where email= ? and password = ?");
          pstmt.setString(1, s.getUsername());
         
          pstmt.setString(2, s.getPassword());
      
          ResultSet result = pstmt.executeQuery();

         
            if (result.next()) {
                System.out.println("USER EXISTS");
                return true;
            }
            else{
                System.out.println("USER DOESN'T EXISTS");
            return false;
            }
          
          
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
              finally{
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ASSIGNMENT12TH.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    
    
    
    
return false;
}
        
        
        
        
    public static void main(String[] args) {
        ASSIGNMENT12TH reservation1 =new ASSIGNMENT12TH();
        reservation1.insertusersdata("MAZEN", "mazen@gmailcom",  "mazen344", 0);
        
        
        /*****************************INSERTFLIGHT DATA****************************************/
        
      reservation1.insertflightdata("CAIRO", "YEMEN", "8/5/2020", "6:30", 20);
      reservation1.insertflightdata("CAIRO", "YEMEN", "3/5/2021", "11:30", 110);
      reservation1.insertflightdata("CAIRO", "YEMEN", "8/5/2021", "11:30", 0);

    }
    
}
