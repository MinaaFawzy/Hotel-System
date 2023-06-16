package Classes;
import java.sql.*;
public class ReservationClass {
        
    static Connection c;
    static Statement s1,s2,s3;
    static String query,query1,query2;
    static Connect t = new Connect();
    static ResultSet r,r1;
    public static void Add_Reservation(String name,int SSN,int Phone, int Duration,
                int Room_ID,String Service,String Check_In )
    {
        int x=0;
        try {
            c=t.setconnect();
            s1=c.createStatement();
            s3=c.createStatement();
            query2="select *from service";
            r1=s3.executeQuery(query2);
            String test=Service.toUpperCase();
            while(r1.next())
            {
                if (test.equals(r1.getString("Name").toUpperCase()))
                {
                    x++;
                    break;  
                }
            }
            if (x==0)
            {
                Service="No Service";  
            }
            query="insert into Reservation values ('"+name+"','"+SSN+"','"+Phone+"','"+Duration+"',"
                    + "'"+Room_ID+"','"+Service+"','"+Check_In+"')";
            s1.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                s1.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }
    public static void Add_Reservation(int SSN ,int Duration,int Room_ID,String Service,String Check_In )
    {
        String name = null;
        int phone = 0,x=0;
        try {
            c=t.setconnect();
            s1=c.createStatement();
            s2=c.createStatement();
            query1="select *from Customers";
            r=s2.executeQuery(query1);
            while(r.next())
            {
                if (SSN==r.getInt("SSN"))
                {
                  name=r.getString("Name");
                  phone=r.getInt("Phone");
                }
            }
            s3=c.createStatement();
            query2="select *from service";
            r1=s3.executeQuery(query2);
            String test=Service.toUpperCase();
            while(r1.next())
            {
                if (test.equals(r1.getString("Name").toUpperCase()))
                {
                    x++;
                    break;  
                }
            }
            if (x==0)
            {
                Service="No Service";  
            }
            
            query="insert into Reservation values ('"+name+"','"+SSN+"','"+phone+"','"+Duration+"',"
                    + "'"+Room_ID+"','"+Service+"','"+Check_In+"')";
            s1.execute(query);
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
                finally {
            try {
                c.close();
                s1.close();
                s2.close();
            }              
            catch(SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }


}
