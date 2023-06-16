package Classes;
import java.sql.*;
import java.util.ArrayList;
public class Login {
    
    static Connection c;
    static Statement ss;
    static String query;
    static ResultSet r;
    static Connect t = new Connect();

    public static void Add_Info_Of_User(String User_Name,String Password , int code)
    {
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="insert into  login values ('"+code+"','"+User_Name+"','"+ Password+"')";
            ss.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                ss.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }
    public static int Check_Login(String user_name,String password )
    {
        int x=0;
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="select * from login";
            r=ss.executeQuery(query);
            while (r.next())
            {    
                String U=r.getString("User_Name").toUpperCase();
                String P=r.getString("Password").toUpperCase();
                 
                if (U.equals(user_name)){
                    if (P.equals(password)){
                        x=1;
                        return x;
                    }else{
                        x=2;
                        return x;
                    }
                }else{ 
                    x=2;
                }  
            }                
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                ss.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    return x;
    }
}
