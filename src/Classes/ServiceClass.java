package Classes;
import java.sql.*;
public class ServiceClass {
    static Connection c;
    static Statement ss,s;
    static String query,query1;
    static Connect t = new Connect();
    static ResultSet r;
    
    public static void Change_Data(int num  ,String typeOFInfo ,String NewInfo)
    {    
        
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="update service set "+typeOFInfo+ " = "+NewInfo+" where Number= "+num+" ";
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
    public static void Add_Service(int num ,String name,String Discription,int Price )
    {
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="insert into service values ('"+num+"','"+name+"','"+Discription+"','"+Price+"')";
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

    public static void Delete_Service(int D_Service)
    {
        try {
            c=t.setconnect();
            ss=c.createStatement();
            query="delete from service where Number="+D_Service+"";
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

    public static void Update_Service(int SSN  ,int Number_Of_Service)
    {    
        String NewInfo=null;
        try {
            c=t.setconnect();
            s=c.createStatement();
            query1="select * from Service";
            r=s.executeQuery(query1);
            while(r.next())
            {
                if (Number_Of_Service==r.getInt("Number"))
                {
                    NewInfo=r.getString("Name");
                    break;
                }
            }
            ss=c.createStatement();
            query="update Reservation set Service='"+NewInfo+"' where SSN='"+SSN+"' ";
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
}