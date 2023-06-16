package project1;
import Classes.Connect;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class CheckoutClass {
    
    static Connection c;
    static Statement s1,s2,s3,s4;
    static String query1,query2,query3,query4;
    static Connect t = new Connect();
    static ResultSet r,r1;
    static int A;
    static String Name,Service ;
    static int ssn,Room_ID,Phone,Duration,p;
        
    public static void Edit_Data(int SSN)
    {
        A=SSN;
        try {
            c=t.setconnect();
            s1=c.createStatement();
            query1="select * from reservation";
            r=s1.executeQuery(query1);
            while(r.next())
            {

                if(SSN==r.getInt("SSN"))
                {
                    Name=r.getString("Name");
                    Service=r.getString("Service");
                    ssn=r.getInt("SSN");
                    Phone=r.getInt("Phone");
                    Room_ID=r.getInt("Room_ID");
                    Duration=r.getInt("Duration");  
                    break;
                }
            }
            Date D=new Date();
            SimpleDateFormat txtdate = new SimpleDateFormat("dd,MM,yyyy");
            String Date1 =txtdate.format(D);
            s2=c.createStatement();
            query2="insert into Checkout values ('"+Name+"','"+ssn+"','"+Phone+"',"
                    + "'"+Duration+"','"+Room_ID+"','"+Service+"','"+Date1+"')";
            s2.execute(query2);
            s3=c.createStatement();
            query3="delete from Reservation where SSN ='"+SSN+"'";
            s3.execute(query3);
            s4=c.createStatement();
            query4="select * from service";
            r1=s4.executeQuery(query4);
            while(r1.next())
            {
                if(Service.equals(r1.getString("Name")))
                {
                    p=r1.getInt("Price");
                    break;
                }
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                s1.close();
                s2.close();
                s3.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }    

    
}
